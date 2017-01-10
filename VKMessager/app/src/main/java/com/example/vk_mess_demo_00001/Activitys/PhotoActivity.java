package com.example.vk_mess_demo_00001.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.vk_mess_demo_00001.R;
import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

public class PhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        setTitle("Photo");
        String photo = getIntent().getStringExtra("photo");
        ImageView view = (ImageView) findViewById(R.id.imageView);

        Picasso.with(this)
                .load(photo)
                .into(view);
        PhotoViewAttacher mAttacher;
        mAttacher = new PhotoViewAttacher(view);
        mAttacher.update();
    }
}
