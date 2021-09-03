package com.example.apppppp.ui.gallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.apppppp.R;

public class GalleryFragment extends Fragment {
Activity context;

    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState){
        View root =inflater.inflate(R.layout.activity_details, container, false);
        context = getActivity();
        return root;
    }
    public void onStart(){
        super.onStart();
    }

}