package com.example.yyj01.catdogapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainDog extends AppCompatActivity {
    TextView text;
    ImageView dogImage;
    String name,sex,date;
    static final int DIALOG_DOG_INFO=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dog);

        text=(TextView)findViewById(R.id.name);
        dogImage=(ImageView)findViewById(R.id.dog);

        Intent intent=getIntent();
        name=intent.getStringExtra("NAME_DOG");
        date=intent.getStringExtra("DATE_DOG");
        sex=intent.getStringExtra("SEX_DOG");

        text.setText(name);

       dogImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_DOG_INFO);
            }
        });
    }
    public void onClick(View button){
        PopupMenu popup=new PopupMenu(this,button);
        popup.getMenuInflater().inflate(R.menu.main,popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.gal:
                        Intent intent=new Intent(MainDog.this,Gallery.class);
                        startActivity(intent);
                        break;
                    case R.id.cum:
                        Intent intent2= new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.animal.go.kr/portal_rnl/index.jsp"));
                        startActivity(intent2);
                        break;
                }

                return true;
            }
        });
        popup.show();
    }

    public void onButtonClicked(View view){
        Intent intent=null;

        switch (view.getId()){
            case R.id.mission:
                intent=new Intent(MainDog.this,MissionMain.class);
                break;
            case R.id.game:
                intent=new Intent(MainDog.this,Clicker2.class);
                break;
            case R.id.know:
                intent=new Intent(MainDog.this,CautionDog.class);
                break;
            case R.id.camera:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                break;

        }
        if(intent!=null){
            startActivity(intent);
        }
    }

    protected Dialog onCreateDialog(int id){
        switch(id) {
            case DIALOG_DOG_INFO:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(name + "의 정보");
                builder.setIcon(R.drawable.dog_info);
                builder.setMessage("이름 : " + name + "\n" + "성별 : " + sex  +"\n" + "생일 : " + date);
                builder.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog=builder.create();
                return alertDialog;
        }
        return null;
    }
}
