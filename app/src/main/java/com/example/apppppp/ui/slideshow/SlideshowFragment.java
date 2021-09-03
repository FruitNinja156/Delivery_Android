package com.example.apppppp.ui.slideshow;

import static android.content.Intent.ACTION_VIEW;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.apppppp.R;
import com.example.apppppp.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {
Activity context;
    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState){
        View root =inflater.inflate(R.layout.fragment_slideshow, container, false);
        context = getActivity();
        return root;
    }
    public void onStart(){
        super.onStart();
        Button button;
        button = (Button)context.findViewById(R.id.btn_locate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });
    }
    public void call(){
        Intent intent = new Intent(ACTION_VIEW);
        intent.setData(Uri.parse("geo:9.00.28.0,38.48.18.2"));
        startActivity(intent);
    }
}