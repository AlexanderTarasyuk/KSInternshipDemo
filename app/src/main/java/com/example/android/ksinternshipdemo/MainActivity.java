package com.example.android.ksinternshipdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private AppCompatButton btnAdd;
    private AppCompatButton btnRemove;
    private AppCompatButton btnReplace;
    private SwitchCompat backstackSwitch;

    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;

    private final static String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(LOG_TAG, "onCreate()");

        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Image viewer");

        btnAdd = findViewById(R.id.btn_add);
        btnRemove = findViewById(R.id.btn_remove);
        btnReplace = findViewById(R.id.btn_replace);
        backstackSwitch = findViewById(R.id.backstack_switch);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(fragmentOne);
            }
        });

        btnReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(fragmentTwo);
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragment(fragmentOne);
            }
        });


    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, fragment);
        if (backstackSwitch.isChecked()) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    private void removeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(fragment);
        if (backstackSwitch.isChecked()) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        if (backstackSwitch.isChecked()) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG, "onSaveInstanceState()");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // This One Called after "onStart()". "savedInstanceState" guaranteed not to be null.
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(LOG_TAG, "onRestoreInstanceState()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy()");
    }

}
