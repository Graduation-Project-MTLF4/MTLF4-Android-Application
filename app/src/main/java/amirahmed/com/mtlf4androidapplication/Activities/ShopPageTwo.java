package amirahmed.com.mtlf4androidapplication.Activities;


import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Locale;

import amirahmed.com.mtlf4androidapplication.R;

public class ShopPageTwo extends AppCompatActivity {

    EditText firstname,lastname,username,email,serial,birthdate,mobile,password,city;
    Calendar myCalendar;
    Button b;
    RadioGroup radioGroup;

    String fname,lname,user,emaill,serialno,birthday,mobilee,pass,sex,cites;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_owner);

        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        email = (EditText) findViewById(R.id.email);
        serial = (EditText) findViewById(R.id.serial);
        mobile = (EditText) findViewById(R.id.mobile);
        password = (EditText) findViewById(R.id.password);
        birthdate = (EditText) findViewById(R.id.birthday);
        city = (EditText) findViewById(R.id.city);
        username = (EditText) findViewById(R.id.username);

        radioGroup = (RadioGroup) findViewById(R.id.radioSex);

        fname = firstname.getText().toString().toLowerCase();
        lname = lastname.getText().toString().toLowerCase();
        serialno = serial.getText().toString().toLowerCase();
        emaill = email.getText().toString().toLowerCase();
        mobilee = mobile.getText().toString().toLowerCase();
        pass = password.getText().toString().toLowerCase();
        cites = city.getText().toString().toLowerCase();
        user = username.getText().toString().toLowerCase();

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

            @TargetApi(Build.VERSION_CODES.N)
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

            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getApplicationContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                birthday = birthdate.getText().toString();
            }
        });



        b = (Button) findViewById(R.id.follow_button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ShopPageTwo.this , ShopPageThree.class);
                intent.putExtra("firstname",fname);
                intent.putExtra("lastname",lname);
                intent.putExtra("username",user);
                intent.putExtra("serial",serialno);
                intent.putExtra("email",emaill);
                intent.putExtra("mobile",mobilee);
                intent.putExtra("password",pass);
                intent.putExtra("birthdate",birthday);
                intent.putExtra("city",cites);
                intent.putExtra("gender",sex);
                startActivity(intent);
            }
        });
    }
}
