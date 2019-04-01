package com.example.yyj01.catdogapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        GridView gridView=(GridView)findViewById(R.id.gridview1);
        gridView.setAdapter(new ImageAdapter(this));
     /*   gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
*/
    }
}

class ImageAdapter extends BaseAdapter{
    private Context mContext;

    public ImageAdapter(Context c){
        mContext=c;
    }

    public int getCount(){
        return mThumbIds.length;
    }

    public Object getItem(int position){
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position,View converView,ViewGroup parent){
        ImageView imageView;
        if(converView==null){
            imageView=new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85,85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }else{
            imageView=(ImageView)converView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    private Integer[] mThumbIds={
            R.drawable.bu, R.drawable.bumke,
            R.drawable.dfa,R.drawable.h,
            R.drawable.imag,R.drawable.ta,
            R.drawable.tat,R.drawable.a,
            R.drawable.c,R.drawable.d,
            R.drawable.e,R.drawable.f,
            R.drawable.g
    };
}
