package com.example.finalproject.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.finalproject.R;

public class HelpFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_help_fragment, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Help");

        LinearLayout faq = view.findViewById(R.id.ll_faq);
        LinearLayout contact = view.findViewById(R.id.ll_contact_us);

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new FaqFragment()).addToBackStack(null).commit();
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new ContactFragment()).addToBackStack(null).commit();
            }
        });

        return view;
    }
}
