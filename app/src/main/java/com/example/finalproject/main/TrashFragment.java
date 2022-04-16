package com.example.finalproject.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.adapter.MailAdapter;
import com.example.finalproject.database.DatabaseHelper;
import com.example.finalproject.model.Mail;

import java.util.ArrayList;

public class TrashFragment extends Fragment {

    RecyclerView rvView;
    RecyclerView.LayoutManager layoutManager;
    MailAdapter adapter;
    ArrayList<Mail> mailList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_trash_fragment, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Trash");

        TextView delete = view.findViewById(R.id.tv_empty_trash);
        rvView=(RecyclerView)view.findViewById(R.id.recycler_view);


        final DatabaseHelper myDb = new DatabaseHelper(getActivity());
        layoutManager = new LinearLayoutManager(getActivity());
        rvView.setLayoutManager(layoutManager);

//        mailList = myDb.getTrash();

        adapter = new MailAdapter(mailList);
        rvView.setAdapter(adapter);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.deleteTrash();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                Toast.makeText(getActivity(), "Delete Trash Completed", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        return view;
    }
}
