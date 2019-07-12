package com.example.android.ksinternshipdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.android.ksinternshipdemo.llisteners.PictureSelectListener;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private FragmentChooser fragmentChooser;
    private FragmentViewer fragmentViewer;
    private PictureSelectListener pictureSelectListener;

    boolean inLandscapeMode;

    private final static String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(LOG_TAG, "onCreate()");

        setContentView(R.layout.activity_main);

        inLandscapeMode = findViewById(R.id.fragment_two) != null;

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Image viewer");

        fragmentChooser = (FragmentChooser) getSupportFragmentManager().findFragmentById(R.id.fragment_one);
        if (inLandscapeMode) {
            fragmentViewer = (FragmentViewer) getSupportFragmentManager().findFragmentById(R.id.fragment_two);
        }

        pictureSelectListener = new PictureSelectListener() {
            @Override
            public void onCatSelected() {
                displaySelected(R.drawable.cat);
            }

            @Override
            public void onFoodSelected() {
                displaySelected(R.drawable.food);
            }

            @Override
            public void onSunsetSelected() {
                displaySelected(R.drawable.sunset);
            }

            @Override
            public void onSpaceSelected() {
                displaySelected(R.drawable.space);
            }
        };

        fragmentChooser.setPictureSelectListener(pictureSelectListener);

    }

    private void displaySelected(@DrawableRes int selectedImageResId) {

        if (inLandscapeMode) {
            fragmentViewer.displayResource(selectedImageResId);
        } else {
            Intent viewIntent = new Intent(MainActivity.this, SecondActivity.class);
            viewIntent.putExtra("KEY_RESID", selectedImageResId);
            startActivity(viewIntent);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG, "onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
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
