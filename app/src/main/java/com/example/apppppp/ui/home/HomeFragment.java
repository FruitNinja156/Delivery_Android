package com.example.apppppp.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.apppppp.R;
import com.example.apppppp.create_account;
import com.example.apppppp.ui.gallery.GalleryFragment;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    Activity context;

    public View onCreateView (@NonNull LayoutInflater inflater,
                ViewGroup container, Bundle savedInstanceState){
            View root =inflater.inflate(R.layout.fragment_home, container, false);
            context = getActivity();
            return root;
        }
public void onStart() {
    super.onStart();
}

    }
