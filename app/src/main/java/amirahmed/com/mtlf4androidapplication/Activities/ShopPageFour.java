package amirahmed.com.mtlf4androidapplication.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import amirahmed.com.mtlf4androidapplication.MainActivity;
import amirahmed.com.mtlf4androidapplication.R;

public class ShopPageFour extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_owner3);

        Button b = (Button) findViewById(R.id.follow_button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ShopPageFour.this , MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
