package com.example.yyj01.catdogapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Clicker2 extends AppCompatActivity {
    static final int DIALOG_DOG_INFO=1;
    CustomList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker2);

        adapter=new CustomList(Clicker2.this);

        Button button = (Button) findViewById(R.id.clickerbutton);
        Button button1 = (Button) findViewById(R.id.whatisclciker);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_DOG_INFO);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context c = v.getContext();

                MediaPlayer mediaPlayer = MediaPlayer.create(c, R.raw.clicker);
                mediaPlayer.start();
            }
        });
    }
    protected Dialog onCreateDialog(int id){
        switch(id) {
            case DIALOG_DOG_INFO:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
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

    String[] titles={
            "클리커란?",
            "이런 효과가 있어요!",
            "이런 점은 주의하세요!"
    };
    String[] content={
            "클리커를 누르면 '딸깍'소리가 나는 반려견 교육 도구로 산책,명령어 교육, 배변 교육 등 다양한 상황에서 이용할 수 있어요.",
            "반려견이 올바른 행동을 했을 때, 클리커 소리를 들려준 후 간식을 주면 점차 클리커 소리를 칭찬으로 인식하게 돼요. 이때부터는 클리커 소리를 들으면 보상을 연상하게 되는데, 칭찬을 통해 문제 행동을 교정할 수 있기 때문에, 반려견과 교감이 더욱 깊어진 상태에서 즐겁게 교육할 수 있어요.",
            "메세지 인식에 혼란을 주지 않도록, 반려견이 잘못했거나, 반려견을 꾸짖을 때는 클리커를 이용하지 말아 주세요."
    };
    Integer[] image={
            R.drawable.information,
            R.drawable.star2,
            R.drawable.danger
    };

    public class CustomList extends ArrayAdapter<String>{
        private final Activity context;
        public CustomList(Activity context){
            super(context,R.layout.clicklist,titles);
            this.context=context;
        }

        public View getView(int position, View view, ViewGroup parent){
            LayoutInflater inflater=context.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.clicklist,null,true);
            ImageView imageView=(ImageView)rowView.findViewById(R.id.infoimage1);
            TextView title=(TextView)rowView.findViewById(R.id.infotext1);
            TextView contents=(TextView)rowView.findViewById(R.id.infotext_1);

            imageView.setImageResource(image[position]);
            title.setText(titles[position]);
            contents.setText(content[position]);

            return rowView;
        }
    }

}
