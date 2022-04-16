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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.finalproject.R;

public class ContactFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_contact_fragment, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Contact Us");

        final EditText problem = view.findViewById(R.id.et_problem_box);
        TextView report = view.findViewById(R.id.tv_report);
        TextView gotofaq = view.findViewById(R.id.tv_go_to_faq);

        gotofaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new FaqFragment()).addToBackStack(null).commit();
            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(problem.getText().toString().isEmpty())
                {
                    Toast.makeText(getActivity(), "Please insert your problem first", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getActivity(), "Report Success", Toast.LENGTH_SHORT).show();
                    FragmentManager fm = getFragmentManager();
                    fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new ContactFragment()).addToBackStack(null).commit();
                }
            }
        });

        return view;
    }
}
