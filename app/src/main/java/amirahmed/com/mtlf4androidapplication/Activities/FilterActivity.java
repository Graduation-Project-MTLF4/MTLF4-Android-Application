package amirahmed.com.mtlf4androidapplication.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import amirahmed.com.mtlf4androidapplication.MainActivity;
import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.Utils.TinyDB;

public class FilterActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;

    TinyDB ti;

    String filter;

    TextView activate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_filter);

        ti = new TinyDB(getApplicationContext());

        c1 = (CheckBox) findViewById(R.id.c1);
        c2 = (CheckBox) findViewById(R.id.c2);
        c3 = (CheckBox) findViewById(R.id.c3);
        c4 = (CheckBox) findViewById(R.id.c4);
        c5 = (CheckBox) findViewById(R.id.c5);
        c6 = (CheckBox) findViewById(R.id.c6);
        c7 = (CheckBox) findViewById(R.id.c7);
        c8 = (CheckBox) findViewById(R.id.c8);
        c9 = (CheckBox) findViewById(R.id.c9);
        c10 = (CheckBox) findViewById(R.id.c10);

        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        c5.setOnClickListener(this);
        c6.setOnClickListener(this);
        c7.setOnClickListener(this);
        c8.setOnClickListener(this);
        c9.setOnClickListener(this);
        c10.setOnClickListener(this);



        TextView clear = (TextView) findViewById(R.id.clearbutton);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1.setChecked(false);
                c2.setChecked(false);
                c3.setChecked(false);
                c4.setChecked(false);
                c5.setChecked(false);
                c6.setChecked(false);
                c7.setChecked(false);
                c8.setChecked(false);
                c9.setChecked(false);
                c10.setChecked(false);

                ti.putString("filter","5");

                Intent intent = new Intent(FilterActivity.this , MainActivity.class);
                startActivity(intent);

            }
        });


        activate = (TextView) findViewById(R.id.activate);

        activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ti.putString("filter",filter);

                Intent intent = new Intent(FilterActivity.this , MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.c1:
                if((((CheckBox)view).isChecked()))
                {
                    filter = "1";
                    break;
                }

            case R.id.c2:
                if((((CheckBox)view).isChecked()))
                {
                    filter = "2";
                    break;
                }
            case R.id.c3:
                if((((CheckBox)view).isChecked()))
                {
                    filter = "3";
                    break;
                }
            case R.id.c4:
                if((((CheckBox)view).isChecked()))
                {
                    filter = "4";
                    break;
                }
            case R.id.c5:
                if((((CheckBox)view).isChecked()))
                {
                    filter = "1";
                    break;
                }
            case R.id.c6:
                if((((CheckBox)view).isChecked()))
                {
                    filter = "2";
                    break;
                }
            case R.id.c7:
                if((((CheckBox)view).isChecked()))
                {
                    filter = "3";
                    break;
                }
            case R.id.c8:
                if((((CheckBox)view).isChecked()))
                {
                    filter = "4";
                    break;
                }
            case R.id.c9:
                if((((CheckBox)view).isChecked()))
                {
                    filter = "1";
                    break;
                }
            case R.id.c10:
                if((((CheckBox)view).isChecked()))
                {
                    filter = "2";
                    break;
                }

        }

    }
}
