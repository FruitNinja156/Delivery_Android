package com.example.apppppp.ui.contacts;

import static android.content.Intent.ACTION_DIAL;

import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.apppppp.R;

public class contactFragment extends Fragment {

    Activity context;

    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState){
        View root =inflater.inflate(R.layout.contact_fragment, container, false);
        context = getActivity();
        return root;
    }
    public void onStart(){
        super.onStart();
        Button button;
        button=(Button)context.findViewById(R.id.btn_contact);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locate();
            }
        });

    }
public void locate(){
    Intent intent = new Intent(Intent.ACTION_DIAL);
    intent.setData(Uri.parse("tel:0911111111"));
    startActivity(intent);
}


}