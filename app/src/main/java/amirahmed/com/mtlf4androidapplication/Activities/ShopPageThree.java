package amirahmed.com.mtlf4androidapplication.Activities;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.Utils.RequestHandler;

public class ShopPageThree extends AppCompatActivity {

    String fname,lname,username,emaill,serialno,birthday,mobilee,pass,sex,cites;
    EditText comname,comaddress,comdetails,commobile,commail,recordedittext;
    String cname,caddres,cdetails,cmobile,cmail;
    String men,women,child,shoes,access,glasses;
    String record,logo;
    CheckBox c1,c2,c3,c4,c5,c6;
    ImageView companylogo;

    String url = "https://matlefesh.000webhostapp.com/mobile/company_register.php";

    private Bitmap logoBitmap;
    private Bitmap recordBitmap;

    private int PICK_IMAGE_REQUEST = 1;
    private int PICK_IMAGE_REQUEST_2 = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_owner2);

        companylogo = (ImageView) findViewById(R.id.companylogo);

        recordedittext = (EditText) findViewById(R.id.recordedittext);

        comname = (EditText) findViewById(R.id.companyname);
        comaddress = (EditText) findViewById(R.id.companyaddress);
        comdetails = (EditText) findViewById(R.id.companydetails);
        commobile = (EditText) findViewById(R.id.companymobile);
        commail = (EditText) findViewById(R.id.companyemail);

        c1 = (CheckBox) findViewById(R.id.men);
        c2 = (CheckBox) findViewById(R.id.women);
        c3 = (CheckBox) findViewById(R.id.access);
        c4 = (CheckBox) findViewById(R.id.child);
        c5 = (CheckBox) findViewById(R.id.shoes);
        c6 = (CheckBox) findViewById(R.id.glasses);

        if(c1.isChecked())
        {
            men = "1";
        }else
        {
            men = "0";
        }

        if(c2.isChecked())
        {
            women = "1";
        }else
        {
            women = "0";
        }

        if(c3.isChecked())
        {
            child = "1";
        }else
        {
            child = "0";
        }

        if(c4.isChecked())
        {
            shoes = "1";
        }else
        {
            shoes = "0";
        }

        if(c5.isChecked())
        {
            access = "1";
        }else
        {
            access = "0";
        }

        if(c6.isChecked())
        {
            glasses = "1";
        }else
        {
            glasses = "0";
        }

        Bundle bundle = getIntent().getExtras();

        fname = bundle.getString("firstname");
        lname = bundle.getString("lastname");
        username = bundle.getString("username");
        emaill = bundle.getString("email");
        serialno = bundle.getString("serial");
        birthday = bundle.getString("birthdate");
        mobilee = bundle.getString("mobile");
        pass = bundle.getString("password");
        sex = bundle.getString("gender");
        cites = bundle.getString("city");

        cname = comname.getText().toString().toLowerCase();
        caddres = comaddress.getText().toString().toLowerCase();
        cdetails = comdetails.getText().toString().toLowerCase();
        cmobile = commobile.getText().toString().toLowerCase();
        cmail = commail.getText().toString().toLowerCase();

        recordedittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser2();
                recordedittext.setText(record);
            }
        });

        companylogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser();
            }
        });

        Button b = (Button) findViewById(R.id.submitButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                logo = getStringImage(logoBitmap);
                record = recordedittext.getText().toString().trim();

                if(isOnline())
                {

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
                            params.put("companyName", cname);
                            params.put("companyAddress", caddres);
                            params.put("companyDetail", cdetails);
                            params.put("companyMobile", cmobile);
                            params.put("companyMail", cmail);
                            params.put("companylogo", logo);
                            params.put("companyCommercialRegistration", record);
                            params.put("men", men);
                            params.put("women", women);
                            params.put("child", child);
                            params.put("bag", "0");
                            params.put("shoes", shoes);
                            params.put("hour", "0");
                            params.put("accessories", access);
                            params.put("glasses", glasses);
                            params.put("fname", fname);
                            params.put("lname", lname);
                            params.put("companyPhone", mobilee);
                            params.put("ownerMail", emaill);
                            params.put("companyPass", pass);
                            params.put("gender", sex);
                            params.put("username", username);
                            params.put("date", birthday);
                            params.put("companyCity", cites);

                            return params;
                        }
                    };

                    RequestHandler.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);


                }else
                {
                    showMessage("No Connection");
                }


                Intent intent = new Intent(ShopPageThree.this , ShopPageFour.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Getting the Bitmap from Gallery
                logoBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //Setting the Bitmap to ImageView
                companylogo.setImageBitmap(logoBitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (requestCode == PICK_IMAGE_REQUEST_2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Getting the Bitmap from Gallery
                recordBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //Setting the Bitmap to ImageView
                record = getStringImage(recordBitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    private void showFileChooser2() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST_2);
    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }

}
