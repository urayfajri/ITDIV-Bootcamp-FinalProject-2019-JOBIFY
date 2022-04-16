package com.example.finalproject.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.adapter.MailAdapter;
import com.example.finalproject.adapter.SearchJobAdapter;
import com.example.finalproject.database.DatabaseHelper;
import com.example.finalproject.model.Mail;
import com.example.finalproject.model.User;
import com.example.finalproject.session.SharedPreference;

import java.util.ArrayList;

public class ApplyboxFragment extends Fragment {

    RecyclerView rvView;
    RecyclerView.LayoutManager layoutManager;
    MailAdapter adapter;
    ArrayList<Mail> mailList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_applybox_fragment, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Applybox");

        rvView=(RecyclerView)view.findViewById(R.id.recycler_view);

        DatabaseHelper myDb = new DatabaseHelper(getActivity());
        layoutManager = new LinearLayoutManager(getActivity());
        rvView.setLayoutManager(layoutManager);


        SharedPreference sharedPreference = new SharedPreference(getActivity());
        User user = sharedPreference.load();


        int userID = myDb.getUserId(user.getEmail());
        mailList = myDb.getMail(userID);

        adapter = new MailAdapter(mailList);
        rvView.setAdapter(adapter);

        return view;
    }
}