package com.example.finalproject.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.finalproject.R;
import com.example.finalproject.gallery.Animation;
import com.example.finalproject.gallery.Architecture;
import com.example.finalproject.gallery.CivilEngineer;
import com.example.finalproject.gallery.GraphicDesign;
import com.example.finalproject.gallery.Photographer;
import com.example.finalproject.gallery.UXDesign;


public class TakeALookFragment extends Fragment {

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_take_a_look, container, false);

        final LinearLayout animation, architecture, civilEngineer, graphicDesign, photographer, uxDesign;

        animation = (LinearLayout)view.findViewById(R.id.ll_animator_view);
        architecture = (LinearLayout)view.findViewById(R.id.ll_architect_view);
        civilEngineer = (LinearLayout)view.findViewById(R.id.ll_civil_engineer_view);
        graphicDesign = (LinearLayout)view.findViewById(R.id.ll_grapic_designer_view);
        photographer = (LinearLayout)view.findViewById(R.id.ll_photographer_view);
        uxDesign = (LinearLayout)view.findViewById(R.id.ll_ux_designer_view);

        animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new Animation()).addToBackStack(null).commit();
            }
        });

        architecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new Architecture()).addToBackStack(null).commit();
            }
        });

        civilEngineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new CivilEngineer()).addToBackStack(null).commit();
            }
        });

        graphicDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new GraphicDesign()).addToBackStack(null).commit();
            }
        });

        photographer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new Photographer()).addToBackStack(null).commit();
            }
        });

        uxDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new UXDesign()).addToBackStack(null).commit();
            }
        });

        return view;
    }

    public void onResume(){
        super.onResume();

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Take a Look");

    }
}
