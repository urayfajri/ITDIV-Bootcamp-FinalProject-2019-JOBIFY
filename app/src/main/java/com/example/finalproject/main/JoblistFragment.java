package com.example.finalproject.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.SearchJob;
import com.example.finalproject.adapter.SearchJobAdapter;
import com.example.finalproject.database.DatabaseHelper;
import com.example.finalproject.model.Job;
import com.example.finalproject.session.SharedPreference;

import java.util.ArrayList;

public class JoblistFragment extends Fragment {


    private RecyclerView rvView;
    private SearchJobAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Job> jobList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_joblist_fragment, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Job List");

        LinearLayout gallery = view.findViewById(R.id.ll_goto_gallery);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new GalleryFragment()).addToBackStack(null).commit();

            }
        });
        DatabaseHelper myDb = new DatabaseHelper(getActivity());
        final SharedPreference sharedPreference = new SharedPreference(getActivity());
        Job job = sharedPreference.loadFilter();
        jobList = myDb.getSelectedJobList(job.getJobCategory(),job.getJobType(),job.getJobLocation());


        if(jobList.size() == 0)
        {
            Toast.makeText(getActivity(), "Data Not Exists", Toast.LENGTH_SHORT).show();
        }
        else
        {
            rvView=(RecyclerView)view.findViewById(R.id.reycv_job_list);
            rvView.setHasFixedSize(true);

            layoutManager = new LinearLayoutManager(getActivity());
            rvView.setLayoutManager(layoutManager);

            adapter = new SearchJobAdapter(jobList, new SearchJobAdapter.OnItemClick() {
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

    public static JoblistFragment newInstance(String category, String type, String location, String order){
        JoblistFragment fragment = new JoblistFragment();
        Bundle bundle = new Bundle();
        bundle.putString("category", category);
        bundle.putString("type", type);
        bundle.putString("location", location);
        bundle.putString("order", order);

        fragment.setArguments(bundle);
        return fragment;
    }
}
