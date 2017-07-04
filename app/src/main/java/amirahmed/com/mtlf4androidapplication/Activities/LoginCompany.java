package amirahmed.com.mtlf4androidapplication.Activities;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import amirahmed.com.mtlf4androidapplication.MainActivity;
import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.Utils.RequestHandler;

public class LoginCompany extends Activity {

    EditText email,password;
    Button button;


    String url = "https://matlefesh.000webhostapp.com/mobile/Company_Login.php";

    String emaill,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_logincompany);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);



        button = (Button) findViewById(R.id.email_sign_in_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                execution();
            }
        });
    }
private void execution() {

    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    final SharedPreferences.Editor editor = preferences.edit();

    if(isOnline())
    {
        emaill = email.getText().toString().toLowerCase();
        pass = password.getText().toString().toLowerCase();

        if(!isEmpty(email,password)) {
            StringRequest stringRequest = new StringRequest(
                    Request.Method.POST,
                    url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    //showProgress(false);

                    switch (response) {
                        case "1":
                            showMessage("Login Failed");
                            break;
                        case "2":
                            showMessage("Blocked By Admin");
                            break;
                        default:
                            editor.putString("KeyID","2");
                            editor.apply();

                            Intent i = new Intent(LoginCompany.this,MainActivity.class);
                            startActivity(i);

                            showMessage("Login Successfully");
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
                    params.put("email", emaill);
                    params.put("pass", pass);
                    return params;
                }
            };

            RequestHandler.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

        }else
        {
            showMessage("Input Missing");
        }
    }else
    {
        showMessage("No Connection");
    }

    }

    private boolean isEmpty(EditText email,EditText password) {
        return !(email.getText().toString().trim().length() > 0 && password.getText().toString().trim().length() > 0);
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }

}
