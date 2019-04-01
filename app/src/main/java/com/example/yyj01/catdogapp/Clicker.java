package com.example.yyj01.catdogapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class Clicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);

        Button button = (Button) findViewById(R.id.clickerbutton);
        Button button1 = (Button) findViewById(R.id.whatisclciker);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context c = v.getContext();

                MediaPlayer mediaPlayer = MediaPlayer.create(c, R.raw.clicker);
                mediaPlayer.start();
            }
        });
    }
    public void oninfoClick(View v){
        final Dialog infoDialog = new Dialog(this);
        infoDialog.setContentView(R.layout.activity_clicker_info);

        Button button2 = (Button) findViewById(R.id.whatisclciker);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        infoDialog.show();
    }


}
