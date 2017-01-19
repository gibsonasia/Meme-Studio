package com.example.asiagibson.memestudio.Activities;

;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;

import com.example.asiagibson.memestudio.MemeFragment;
import com.example.asiagibson.memestudio.PainterView;
import com.example.asiagibson.memestudio.R;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        MemeFragment fragment = new MemeFragment();
        ft.add(R.id.frag_container, fragment);
        ft.commit();
    }

    }


