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
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.SearchJob;
import com.example.finalproject.adapter.BookmarkAdapter;
import com.example.finalproject.adapter.SearchJobAdapter;
import com.example.finalproject.database.DatabaseHelper;
import com.example.finalproject.model.Job;
import com.example.finalproject.session.SharedPreference;

import java.util.ArrayList;

public class BookmarkFragment extends Fragment {

    private RecyclerView rvView;
    private BookmarkAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Job> bookmarkList = new ArrayList<>();
    private ImageView ivbookmark;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_bookmark_fragment, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Bookmark");

        DatabaseHelper myDb = new DatabaseHelper(getActivity());

        bookmarkList = myDb.getBookmark();

        ivbookmark = view.findViewById(R.id.iv_bookmarked);

        if(bookmarkList.size() == 0)
        {
            Toast.makeText(getActivity(), "Data Not Exists", Toast.LENGTH_SHORT).show();
        }
        else
        {
            rvView=(RecyclerView)view.findViewById(R.id.reycv_job_list);
            rvView.setHasFixedSize(true);

            layoutManager = new LinearLayoutManager(getActivity());
            rvView.setLayoutManager(layoutManager);

            adapter = new BookmarkAdapter(bookmarkList, new BookmarkAdapter.OnItemClick() {
                @Override
                public void OnClick(Job job) {
                    SharedPreference sharedPreference = new SharedPreference(getActivity());
                    sharedPreference.saveJob(new Job(
                            job.getId(),
                            job.getJobName(),
                            job.getJobLocation(),
                            job.getJobPlace(),
                            job.getJobDate(),
                            job.getJobType(),
                            job.getIsBookmark()
                    ));
                    FragmentManager fm = getFragmentManager();
                    fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new ApplyjobFragment()).addToBackStack(null).commit();
                }
            });
            rvView.setAdapter(adapter);
        }

        return view;
    }
}
