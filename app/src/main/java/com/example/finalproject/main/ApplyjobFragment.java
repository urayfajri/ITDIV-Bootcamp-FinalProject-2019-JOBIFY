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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.finalproject.R;
import com.example.finalproject.adapter.MailAdapter;
import com.example.finalproject.database.DatabaseHelper;
import com.example.finalproject.model.Job;
import com.example.finalproject.model.Mail;
import com.example.finalproject.model.User;
import com.example.finalproject.session.SharedPreference;

public class ApplyjobFragment extends Fragment {


    ImageView blur;
    LinearLayout apply;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_applyjob_fragment, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Apply Job");


        ImageButton ib = view.findViewById(R.id.ib_back);
        final DatabaseHelper myDb = new DatabaseHelper(getActivity());
        blur = view.findViewById(R.id.iv_blur);
        apply = view.findViewById(R.id.ll_apply);

        TextView place = view.findViewById(R.id.tv_place_job);
        TextView name = view.findViewById(R.id.tv_job_name);
        TextView location = view.findViewById(R.id.tv_location_job);
        TextView date = view.findViewById(R.id.tv_date_job); //ini getdate yang pas klik apply
        TextView type = view.findViewById(R.id.tv_job_type);

        SharedPreference sharedPreference = new SharedPreference(getActivity());
        Job job = sharedPreference.loadJob();

        final int jobid = myDb.getJobID(job.getJobDate());
        place.setText(job.getJobPlace());
        name.setText(job.getJobName());
        location.setText(job.getJobLocation());
        date.setText(job.getJobDate());
        type.setText(job.getJobType());

        TextView applyBtn = view.findViewById(R.id.tv_apply_for_this_job);
        final TextView contBtn = view.findViewById(R.id.tv_continue_button);


        User user = sharedPreference.load();
        final int userid = myDb.getUserId(user.getEmail());

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupBlur(true);
                contBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean check = myDb.insertApply(jobid, userid);
                        if(check)
                        {
                            FragmentManager fm = getFragmentManager();
                            fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new JoblistFragment()).addToBackStack(null).commit();
                        }
                    }
                });
            }
        });

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new JoblistFragment()).addToBackStack(null).commit();
            }
        });

        return view;
    }

    private void popupBlur(boolean isShow){
        blur.setVisibility(isShow ? View.VISIBLE : View.GONE);
        apply.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }
}
