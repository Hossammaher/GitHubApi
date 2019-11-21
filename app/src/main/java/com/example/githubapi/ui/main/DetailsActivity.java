package com.example.githubapi.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.githubapi.R;

public class DetailsActivity extends AppCompatActivity {

    TextView user_name , user_url;
    ImageView user_image ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        user_name = findViewById(R.id.detail_user_Name);
        user_url = findViewById(R.id.detail_user_Url);
        user_image=findViewById(R.id.userImage);


        Intent intent = getIntent();
        String Name = intent.getStringExtra("login");
        String Url = intent.getStringExtra("URL");
        String img = intent.getStringExtra("Img");

        user_name.setText(Name);
        user_url.setText(Url);
        Linkify.addLinks(user_url,Linkify.WEB_URLS);

        Glide.with(this)
                .load(img)
                .into(user_image);

        getSupportActionBar().setTitle(Name + " Detail");


    }
}
