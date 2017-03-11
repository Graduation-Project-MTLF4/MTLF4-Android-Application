package amirahmed.com.mtlf4androidapplication.Activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;

import amirahmed.com.mtlf4androidapplication.R;

public class FilterActivity extends AppCompatActivity {

    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_filter);

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
            }
        });
    }
}
