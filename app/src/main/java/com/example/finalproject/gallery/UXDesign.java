package com.example.finalproject.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalproject.R;
import com.example.finalproject.main.MainActivity;


public class UXDesign extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gallery_ux_designer, container, false);

        final LinearLayout llShowMore, llShowLess;
        final RelativeLayout rvShowHorizontal, rvShowVertical, rvGallery;
        final ImageView ivHorizontal;

        llShowLess = view.findViewById(R.id.ll_show_less_ux);
        llShowMore = view.findViewById(R.id.ll_show_more_ux);
        rvShowHorizontal = view.findViewById(R.id.rv_image_show_horizontal);
        rvShowVertical = view.findViewById(R.id.rv_image_show_vertical);
        ivHorizontal = view.findViewById(R.id.iv_background_horizontal);
        rvGallery = view.findViewById(R.id.rv_galery_title);

        llShowLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llShowLess.setVisibility(View.GONE);
                llShowMore.setVisibility(View.VISIBLE);

                rvShowHorizontal.setVisibility(View.VISIBLE);
                rvShowVertical.setVisibility(View.GONE);

                ivHorizontal.setVisibility(View.VISIBLE);
                rvGallery.setVisibility(View.VISIBLE);
            }
        });

        llShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llShowMore.setVisibility(View.GONE);
                llShowLess.setVisibility(View.VISIBLE);

                rvShowHorizontal.setVisibility(View.GONE);
                rvShowVertical.setVisibility(View.VISIBLE);

                ivHorizontal.setVisibility(View.GONE);
                rvGallery.setVisibility(View.GONE);
            }
        });

        return view;
    }

    public void onResume(){
        super.onResume();

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("UX Design");
    }
}
