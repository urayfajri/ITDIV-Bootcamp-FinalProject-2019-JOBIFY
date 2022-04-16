package com.example.finalproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.model.Job;


import java.util.ArrayList;
import java.util.List;

import static android.view.View.VISIBLE;

public class SearchJobAdapter extends RecyclerView.Adapter<SearchJobAdapter.SearchJobViewHolder> {

    private OnItemClick listener;
    private List<Job> jobListDatabase = new ArrayList<>();

    public SearchJobAdapter(ArrayList<Job> List,  OnItemClick listener) {
        this.jobListDatabase = List;
        this.listener = listener;
    }

    public SearchJobAdapter(ArrayList<Job> inputData)
    {
        jobListDatabase=inputData;
    }

    @NonNull
    @Override
    public SearchJobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_search_list, parent, false);

        return new SearchJobViewHolder(view);

    }

    public class SearchJobViewHolder extends RecyclerView.ViewHolder{

        TextView tvJobName,tvJobPlace,tvJobLocation,tvJobDate,tvJobType;
        RelativeLayout rlJobList;
        ImageView ivBookmark;
        ImageView ivUnBookmark;

        public SearchJobViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJobName=itemView.findViewById(R.id.tv_job_name);
            tvJobPlace=itemView.findViewById(R.id.tv_place_job);
            tvJobLocation=itemView.findViewById((R.id.tv_location_job));
            tvJobDate=itemView.findViewById(R.id.tv_date_job);
            tvJobType=itemView.findViewById(R.id.tv_job_type);
            rlJobList= itemView.findViewById(R.id.rl_job_list);
            ivBookmark = itemView.findViewById(R.id.iv_bookmarked);
            ivUnBookmark = itemView.findViewById(R.id.iv_unbookmarked);
        }


        public void bind(final Job job){
            tvJobName.setText(job.getJobName());
            tvJobPlace.setText(job.getJobPlace());
            tvJobLocation.setText(job.getJobLocation());
            tvJobDate.setText(job.getJobDate());
            tvJobType.setText(job.getJobType());
        }

        private void setBookmark(){
            ivBookmark.setVisibility(VISIBLE);

        }

        private void setUnBookmark(){
            ivBookmark.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull final SearchJobViewHolder holder, final int position) {

        Job job = jobListDatabase.get(position);
        holder.bind(job);

        holder.rlJobList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnClick(jobListDatabase.get(position));
            }
        });

        holder.ivUnBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.setBookmark();
            }
        });

        holder.ivBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.setUnBookmark();
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
