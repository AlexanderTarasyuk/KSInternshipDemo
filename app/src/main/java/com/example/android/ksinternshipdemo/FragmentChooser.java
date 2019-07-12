package com.example.android.ksinternshipdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.ksinternshipdemo.llisteners.PictureSelectListener;

public class FragmentChooser extends Fragment {

    private AppCompatButton catButton;
    private AppCompatButton foodButton;
    private AppCompatButton sunsetButton;
    private AppCompatButton spaceButton;

    private PictureSelectListener pictureSelectListener;


    public FragmentChooser() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);

        catButton = v.findViewById(R.id.btn_cat);
        foodButton = v.findViewById(R.id.btn_food);
        sunsetButton = v.findViewById(R.id.btn_sunset);
        spaceButton = v.findViewById(R.id.btn_space);

        catButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pictureSelectListener != null) {
                    pictureSelectListener.onCatSelected();
                }
            }
        });

        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pictureSelectListener != null) {
                    pictureSelectListener.onFoodSelected();
                }
            }
        });

        sunsetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pictureSelectListener != null) {
                    pictureSelectListener.onSunsetSelected();
                }
            }
        });

        spaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pictureSelectListener != null) {
                    pictureSelectListener.onSpaceSelected();
                }
            }
        });

        return v;
    }

    public void setPictureSelectListener(PictureSelectListener listener) {
        this.pictureSelectListener = listener;
    }

}
