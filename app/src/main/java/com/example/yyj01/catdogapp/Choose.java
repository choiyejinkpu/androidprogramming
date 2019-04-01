package com.example.yyj01.catdogapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Set;

public class Choose extends AppCompatActivity {
 /*   static final int CAT_CH=1;
    static final int DOG_CH=2;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

    ImageView cat=(ImageView)findViewById(R.id.cat);
    ImageView dog=(ImageView)findViewById(R.id.dog);

        cat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent in=new Intent(Choose.this,SetCat.class);
            in.putExtra("CHOOSE","cat");
            startActivity(in);
        }
    });

        dog.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent in=new Intent(Choose.this,SetDog.class);

            startActivity(in);
        }
    });
}
}
