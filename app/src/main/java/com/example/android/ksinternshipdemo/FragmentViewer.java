package com.example.android.ksinternshipdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentViewer extends Fragment {

    private AppCompatImageView imageView;

    public FragmentViewer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two, container, false);
        imageView = v.findViewById(R.id.image_view);
        return v;
    }

    public void displayResource(int resId) {
        imageView.setImageResource(resId);
    }

}
