package amirahmed.com.mtlf4androidapplication.Activities;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import amirahmed.com.mtlf4androidapplication.R;
import amirahmed.com.mtlf4androidapplication.Utils.TinyDB;
import io.realm.internal.IOException;

public class AddPost1 extends AppCompatActivity {

    //public Realm realm;
    TinyDB tb;
    EditText e1,e2,e3,e4;
    CheckBox c1,c2,c3,c4;

    String postpic,catigory1,catigory2,catigory3,catigory4;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpost1);

        tb = new TinyDB(getApplicationContext());

        e1 = (EditText) findViewById(R.id.postname);
        e2 = (EditText) findViewById(R.id.postdesc);
        e3 = (EditText) findViewById(R.id.postpic);
        e4 = (EditText) findViewById(R.id.discount);

        c1 = (CheckBox) findViewById(R.id.cat1);
        c2 = (CheckBox) findViewById(R.id.cat2);
        c3 = (CheckBox) findViewById(R.id.cat3);
        c4 = (CheckBox) findViewById(R.id.cat4);


        if(c1.isChecked())
        {
            catigory1 = "1";
        }else
        {
            catigory1 = "0";
        }

        if(c2.isChecked())
        {
            catigory2 = "1";
        }else
        {
            catigory2 = "0";
        }

        if(c3.isChecked())
        {
            catigory3 = "1";
        }else
        {
            catigory3 = "0";
        }

        if(c4.isChecked())
        {
            catigory4 = "1";
        }else
        {
            catigory4 = "0";
        }




        e3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImagePicker.pickImage(AddPost1.this, "Select your image:");
            }
        });



        Button b = (Button) findViewById(R.id.contonu);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tb.putString("postname",e1.getText().toString());
                tb.putString("postdesc",e2.getText().toString());
                //tb.putString("postpic",postpic);


                /*Realm.init(getApplicationContext());

                realm = Realm.getDefaultInstance();

                realm.beginTransaction();

                RealmTask t = realm.createObject(RealmTask.class, UUID.randomUUID().toString());
                t.setPostname(e1.getText().toString());
                t.setDescription(e2.getText().toString());
                t.setDiscount(e4.getText().toString());
                t.setPic(postpic);
                t.setCategory(catigory1);
                realm.commitTransaction();*/

        /*RealmResults<RealmTask> tasks = realm.allObjects(RealmTask.class,UUID.randomUUID().toString())
                .where("title","ass")
                .contains()
                .findAll();*/


                Intent intent = new Intent(getApplicationContext() , AddPost2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = ImagePicker.getImageFromResult(this, requestCode, resultCode, data);

        if (bitmap != null) {
            postpic = getStringImage(bitmap);
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

    public Bitmap getBitmapImage(String string)
    {
        byte[] imageBytes = Base64.decode(string, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        return decodedImage;
    }

    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }

}
