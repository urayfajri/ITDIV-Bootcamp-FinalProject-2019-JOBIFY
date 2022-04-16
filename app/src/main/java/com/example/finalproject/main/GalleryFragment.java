package com.example.finalproject.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.adapter.MailAdapter;
import com.example.finalproject.database.DatabaseHelper;
import com.example.finalproject.model.Mail;


import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_gallery_fragment, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Gallery");

        LinearLayout llstartGallery,llGalleryMenu,llListMenu;
        llstartGallery=(LinearLayout)view.findViewById(R.id.ll_start_gallery);
        llGalleryMenu=(view.findViewById(R.id.ll_galery_menu));
        llListMenu=(view.findViewById(R.id.ll_job_menu));




        llstartGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new TakeALookFragment()).addToBackStack(null).commit();

            }
        });

        llListMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new JoblistFragment()).addToBackStack(null).commit();
            }
        });

        return view;
    }



}
