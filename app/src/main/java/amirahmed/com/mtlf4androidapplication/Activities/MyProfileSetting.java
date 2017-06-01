package amirahmed.com.mtlf4androidapplication.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import amirahmed.com.mtlf4androidapplication.R;

public class MyProfileSetting extends AppCompatActivity {

    LinearLayout l1,l2,l3,l4,l5,iv1,iv2,iv3,iv4,iv5;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_setting);

        l1 = (LinearLayout) findViewById(R.id.changePicteur);
        l2 = (LinearLayout) findViewById(R.id.loginsetting);
        l3 = (LinearLayout) findViewById(R.id.storesetting);
        l4 = (LinearLayout) findViewById(R.id.personsetting);
        l5 = (LinearLayout) findViewById(R.id.connectionsetting);

        l1.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);
        l5.setVisibility(View.GONE);

        iv1 = (LinearLayout) findViewById(R.id.storelogo);
        iv2 = (LinearLayout) findViewById(R.id.login);
        iv3 = (LinearLayout) findViewById(R.id.storedata);
        iv4 = (LinearLayout) findViewById(R.id.ownerdata);
        iv5 = (LinearLayout) findViewById(R.id.connectdata);

        Button b = (Button) findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , MyProfileActivity.class);
                startActivity(intent);
                showMessage("تم حفظ التغيرات بنجاح");
            }
        });

        iv1.setOnClickListener(new View.OnClickListener() {
            boolean st1=false;
            @Override
            public void onClick(View view) {

                if (!st1)
                {
                    l1.setVisibility(View.VISIBLE);
                    st1=true;
                }else
                {
                    l1.setVisibility(View.GONE);
                    st1=false;
                }
            }
        });

        iv2.setOnClickListener(new View.OnClickListener() {
            boolean st2=false;
            @Override
            public void onClick(View view) {

                if (!st2)
                {
                    l2.setVisibility(View.VISIBLE);
                    st2=true;
                }else
                {
                    l2.setVisibility(View.GONE);
                    st2=false;
                }
            }
        });

        iv3.setOnClickListener(new View.OnClickListener() {
            boolean st3=false;
            @Override
            public void onClick(View view) {

                if (!st3)
                {
                    l3.setVisibility(View.VISIBLE);
                    st3=true;
                }else
                {
                    l3.setVisibility(View.GONE);
                    st3=false;
                }
            }
        });

        iv4.setOnClickListener(new View.OnClickListener() {
            boolean st4=false;
            @Override
            public void onClick(View view) {

                if (!st4)
                {
                    l4.setVisibility(View.VISIBLE);
                    st4=true;
                }else
                {
                    l4.setVisibility(View.GONE);
                    st4=false;
                }
            }
        });

        iv5.setOnClickListener(new View.OnClickListener() {
            boolean st5=false;
            @Override
            public void onClick(View view) {

                if (!st5)
                {
                    l5.setVisibility(View.VISIBLE);
                    st5=true;
                }else
                {
                    l5.setVisibility(View.GONE);
                    st5=false;
                }
            }
        });
    }

    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }
}
