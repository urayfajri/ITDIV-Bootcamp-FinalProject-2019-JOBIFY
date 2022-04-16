package com.example.finalproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.model.Job;


import java.util.ArrayList;
import java.util.List;


public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder> {

    private OnItemClick listener;
    private List<Job> jobListDatabase = new ArrayList<>();

    public BookmarkAdapter(ArrayList<Job> List,  BookmarkAdapter.OnItemClick listener) {
        this.jobListDatabase = List;
        this.listener = listener;
    }

    public BookmarkAdapter(ArrayList<Job> inputData)
    {
        jobListDatabase=inputData;
    }

    @NonNull
    @Override
    public BookmarkAdapter.BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark_job_list, parent, false);

        return new BookmarkAdapter.BookmarkViewHolder(view);

    }

    public class BookmarkViewHolder extends RecyclerView.ViewHolder{

        TextView tvJobName,tvJobPlace,tvJobLocation,tvJobDate,tvJobType;
        RelativeLayout rlJobList;


        public BookmarkViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJobName=itemView.findViewById(R.id.tv_job_name);
            tvJobPlace=itemView.findViewById(R.id.tv_place_job);
            tvJobLocation=itemView.findViewById((R.id.tv_location_job));
            tvJobDate=itemView.findViewById(R.id.tv_date_job);
            tvJobType=itemView.findViewById(R.id.tv_job_type);
            rlJobList= itemView.findViewById(R.id.rl_job_list);
        }


        public void bind(final Job job){
            tvJobName.setText(job.getJobName());
            tvJobPlace.setText(job.getJobPlace());
            tvJobLocation.setText(job.getJobLocation());
            tvJobDate.setText(job.getJobDate());
            tvJobType.setText(job.getJobType());
        }

    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkAdapter.BookmarkViewHolder holder, final int position) {

        Job job = jobListDatabase.get(position);
        holder.bind(job);

        holder.rlJobList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnClick(jobListDatabase.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobListDatabase.size();
    }



    public interface OnItemClick{
        void OnClick(Job job);
    }

}
