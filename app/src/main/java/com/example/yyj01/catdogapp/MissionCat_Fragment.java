package com.example.yyj01.catdogapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MissionCat_Fragment extends Fragment {
    static int percent=0;
    ProgressBar progress;


    public MissionCat_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.mission_cat_fragment, container, false);


        progress=(ProgressBar)v.findViewById(R.id.progressbar);

        TextView text=(TextView)v.findViewById(R.id.love);
        text.setText("\uD83D\uDC9C애정도");

        CheckBox one=(CheckBox)v.findViewById(R.id.one);
        CheckBox two=(CheckBox)v.findViewById(R.id.two);
        CheckBox three=(CheckBox)v.findViewById(R.id.three);
        CheckBox four=(CheckBox)v.findViewById(R.id.four);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckboxClicked(v);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckboxClicked(v);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckboxClicked(v);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckboxClicked(v);
            }
        });


        return v;
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
                if (checked) {
                    percent += 20;
                    progress.setProgress(percent);
                }
                else{
                    percent -= 20;
                    progress.setProgress(percent);
                }
        }
    }

}
