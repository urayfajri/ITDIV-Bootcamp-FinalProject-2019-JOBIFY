package com.example.finalproject.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalproject.R;
import com.example.finalproject.main.MainActivity;


public class Architecture extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gallery_architecture, container, false);

        final LinearLayout postCounter;
        final HorizontalScrollView hsvAnimation;
        final TextView gallery, seeMore, seeLess;
        final RelativeLayout parent, vertical;

        postCounter = view.findViewById(R.id.architecture_post_counter);
        hsvAnimation = view.findViewById(R.id.hsv_architecture);
        seeMore = view.findViewById(R.id.architect_see_more);
        seeLess = view.findViewById(R.id.architect_see_less);
        parent = view.findViewById(R.id.rl_architecture_parent);
        vertical = view.findViewById(R.id.vertical_architecture);
        gallery = view.findViewById(R.id.tv_gallery);

        seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postCounter.setVisibility(View.GONE);
                hsvAnimation.setVisibility(View.GONE);
                seeMore.setVisibility(View.GONE);
                seeLess.setVisibility(View.VISIBLE);
                vertical.setVisibility(View.VISIBLE);
                gallery.setVisibility(View.GONE);

                parent.setBackgroundResource(R.drawable.architecture_more);
            }
        });

        seeLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postCounter.setVisibility(View.VISIBLE);
                hsvAnimation.setVisibility(View.VISIBLE);
                seeMore.setVisibility(View.VISIBLE);
                seeLess.setVisibility(View.GONE);
                vertical.setVisibility(View.GONE);
                gallery.setVisibility(View.VISIBLE);

                parent.setBackgroundResource(R.drawable.architecture);
            }
        });

        return view;
    }

    public void onResume(){
        super.onResume();

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Architecture");
    }
}
