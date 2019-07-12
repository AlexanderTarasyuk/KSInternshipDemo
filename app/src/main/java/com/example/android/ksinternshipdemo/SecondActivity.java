package com.example.android.ksinternshipdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private FragmentViewer fragmentViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int resIdToDisplay = getIntent().getIntExtra("KEY_RESID", -1);

        fragmentViewer = (FragmentViewer) getSupportFragmentManager().findFragmentById(R.id.fragment_two);

        fragmentViewer.displayResource(resIdToDisplay);

    }
}
