package amirahmed.com.mtlf4androidapplication.Activities;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.mvc.imagepicker.ImagePicker;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import amirahmed.com.mtlf4androidapplication.MainActivity;
import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.Utils.TinyDB;
import io.realm.internal.IOException;

public class AddPost2 extends AppCompatActivity {

    //public Realm realm;
    EditText e1,e2,e3,e4,e5;
    CheckBox c1,c2;

    TinyDB tb;

    String size1,size2,productpic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpost2);

        tb = new TinyDB(getApplicationContext());

        e1 = (EditText) findViewById(R.id.productname);
        e2 = (EditText) findViewById(R.id.productdesc);
        e3 = (EditText) findViewById(R.id.productpic);
        e4 = (EditText) findViewById(R.id.price);
        e5 = (EditText) findViewById(R.id.quantity);

        c1 = (CheckBox) findViewById(R.id.size1);
        c2 = (CheckBox) findViewById(R.id.size2);

        if(c1.isChecked())
        {
            size1 = "XL";
        }

        if(c2.isChecked())
        {
            size2 = "XXL";
        }


        e3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImagePicker.pickImage(AddPost2.this, "Select your image:");
            }
        });


        Button b = (Button) findViewById(R.id.publish);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Realm.init(getApplicationContext());

                realm = Realm.getDefaultInstance();

                realm.beginTransaction();

                RealmTask t = realm.createObject(RealmTask.class, UUID.randomUUID().toString());
                t.setProductname(e1.getText().toString());
                t.setProductdescription(e2.getText().toString());
                t.setPrice(e4.getText().toString());
                t.setQuantity(e5.getText().toString());
                t.setProductpic(productpic);
                t.setSize1(size1);
                t.setSize2(size2);
                realm.commitTransaction();*/

        /*RealmResults<RealmTask> tasks = realm.allObjects(RealmTask.class,UUID.randomUUID().toString())
                .where("title","ass")
                .contains()
                .findAll();*/

                tb.putString("confirm","confirm2");

                Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(intent);

                showMessage("تم نشر العرض بنجاح");
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = ImagePicker.getImageFromResult(this, requestCode, resultCode, data);

        if (bitmap != null) {
            productpic = getStringImage(bitmap);
        }
        InputStream is = ImagePicker.getInputStreamFromResult(this, requestCode, resultCode, data);
        if (is != null) {

            try {
                is.close();
            } catch (IOException ex) {
                // ignore
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }

        // TODO do something with the bitmap
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //realm.close();
    }

    public void onPickImage(View view) {
        // Click on image button
        ImagePicker.pickImage(this, "Select your image:");
    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }



    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }
}
