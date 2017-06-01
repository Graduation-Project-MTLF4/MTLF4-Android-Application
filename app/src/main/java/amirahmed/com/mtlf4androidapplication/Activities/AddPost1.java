package amirahmed.com.mtlf4androidapplication.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import amirahmed.com.mtlf4androidapplication.R;

public class AddPost1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpost1);

        Button b = (Button) findViewById(R.id.contonu);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , AddPost2.class);
                startActivity(intent);
            }
        });
    }
}
