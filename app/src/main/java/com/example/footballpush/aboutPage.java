package com.example.footballpush;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class aboutPage extends AppCompatActivity {
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_page);

        final ImageView faq = (ImageView) findViewById(R.id.imageView2);
        final ImageView contact = (ImageView) findViewById(R.id.imageView4);

        faq.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(aboutPage.this, FAQpage.class));
            }

        });
        contact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(aboutPage.this, contact.class));
            }

        });


    }



}
