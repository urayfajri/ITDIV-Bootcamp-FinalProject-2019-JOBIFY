package com.example.finalproject.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.finalproject.R;
import com.example.finalproject.loginregist.LoginActivity;

public class HomeFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home_fragment, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Home");

        LinearLayout profile = view.findViewById(R.id.ll_profile);
        LinearLayout look = view.findViewById(R.id.ll_look);
        LinearLayout bookmark = view.findViewById(R.id.ll_bookmark);
        LinearLayout applybox = view.findViewById(R.id.ll_applybox);
        LinearLayout trash = view.findViewById(R.id.ll_trash);
        LinearLayout help = view.findViewById(R.id.ll_help);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new ProfileFragment()).addToBackStack(null).commit();
            }
        });

        look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new LookFragment()).addToBackStack(null).commit();
            }
        });

        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new BookmarkFragment()).addToBackStack(null).commit();
            }
        });

        applybox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new ApplyboxFragment()).addToBackStack(null).commit();
            }
        });

        trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new TrashFragment()).addToBackStack(null).commit();
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new HelpFragment()).addToBackStack(null).commit();
            }
        });

        return view;
    }

}
