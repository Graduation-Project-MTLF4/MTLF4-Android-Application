package amirahmed.com.mtlf4androidapplication.Fragments;


import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.Utils.RequestHandler;

public class NewUserFragment extends Fragment {

    public NewUserFragment()
    {
        //Empty Constrictor
    }

    EditText firstname,lastname,username,email,city,birthdate,mobile,password;
    Calendar myCalendar;
    Button button;
    RadioGroup radioGroup;

    String url = "https://matlefesh.000webhostapp.com/mobile/user_register.php";

    String fname,lname,user,emaill,citys,birthday,mobilee,pass,sex;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_new_user, container, false);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        firstname = (EditText) getActivity().findViewById(R.id.fname);
        lastname = (EditText) getActivity().findViewById(R.id.lname);
        username = (EditText) getActivity().findViewById(R.id.username);
        email = (EditText) getActivity().findViewById(R.id.email);
        city = (EditText) getActivity().findViewById(R.id.city);
        mobile = (EditText) getActivity().findViewById(R.id.mobile);
        password = (EditText) getActivity().findViewById(R.id.password);
        birthdate = (EditText) getActivity().findViewById(R.id.birthdate);

        button = (Button) getActivity().findViewById(R.id.submitButton);

        radioGroup = (RadioGroup) getActivity().findViewById(R.id.radioSex);

        fname = firstname.getText().toString();
        lname = lastname.getText().toString();
        user = username.getText().toString();
        emaill = email.getText().toString();
        citys = city.getText().toString();
        mobilee = mobile.getText().toString();
        pass = password.getText().toString();


        myCalendar = Calendar.getInstance();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case (R.id.radioMale):
                        sex = "Male";
                        break;
                    case (R.id.radioFemale):
                        sex = "Female";
                        break;
                }
            }
        });

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "dd/MM/yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                birthdate.setText(sdf.format(myCalendar.getTime()));
            }

        };

        birthdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                        birthday = birthdate.getText().toString();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Execution();
            }
        });

    }

    private void Execution() {

        if(isOnline())
        {
            if(!isEmpty(firstname,lastname,username,email,birthdate,city,mobile,password)) {
                StringRequest stringRequest = new StringRequest(
                        Request.Method.POST,
                        url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //showProgress(false);

                        switch (response) {
                            case "1":
                                showMessage("Registration Successfully");
                                break;
                            case "2":
                                showMessage("Email Already Used");
                                break;
                            case "3":
                                showMessage("Password Already Used");
                                break;
                            default:
                                showMessage("Registration Failed");
                                break;
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        //showMessage(error.getMessage());
                        showMessage("error");

                    }
                }

                ) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("fname", fname);
                        params.put("lname", lname);
                        params.put("mobile", mobilee);
                        params.put("mail", emaill);
                        params.put("pass", pass);
                        params.put("gender", sex);
                        params.put("username", user);
                        params.put("date", birthday);
                        params.put("city", citys);
                        return params;
                    }
                };

                RequestHandler.getInstance(getContext()).addToRequestQueue(stringRequest);

            }else
            {
                showMessage("Input Missing");
            }
        }else
        {
            showMessage("No Connection");
        }
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    private boolean isEmpty(EditText fullname,EditText lastname,EditText username,EditText email,EditText birthdate,EditText city,EditText mobile,EditText password) {
        return !(fullname.getText().toString().trim().length() > 0 && lastname.getText().toString().trim().length() > 0
                && username.getText().toString().trim().length() > 0 && email.getText().toString().trim().length() > 0
                && birthdate.getText().toString().trim().length() > 0 && city.getText().toString().trim().length() > 0
                && mobile.getText().toString().trim().length() > 0 && password.getText().toString().trim().length() > 0);
    }

    private void showMessage(String _s) {
        Toast.makeText(getContext(), _s, Toast.LENGTH_SHORT).show();
    }

}
