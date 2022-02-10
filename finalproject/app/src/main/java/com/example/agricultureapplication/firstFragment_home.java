package com.example.agricultureapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class firstFragment_home extends Fragment {

    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_home, container, false);

        btn = view.findViewById(R.id.btnPost);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnPost:
                        Intent intent = new Intent(getActivity(), Add_post.class);
                        startActivity(intent);
                        break;
                }
                //Toast.makeText(getActivity(), "HELLO", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
