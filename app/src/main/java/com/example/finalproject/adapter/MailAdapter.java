package com.example.finalproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.main.ApplyboxFragment;
import com.example.finalproject.model.Job;
import com.example.finalproject.model.Mail;

import java.util.ArrayList;
import java.util.List;

public class MailAdapter extends RecyclerView.Adapter<MailAdapter.ViewHolder> {

    private List<Mail> mailList = new ArrayList<>();

    public MailAdapter(ArrayList<Mail> inputData)
    {
        mailList=inputData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvAddedby, tvAssignName, tvTimeStamp, tvJob, tvJobName, tvJobType, tvCompanyName;
        public TextView tvJobLocation, tvApplyDate,tvCandidateName, tvMessage, tvContact;
        LinearLayout linearLayout;
        ImageButton checklist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAddedby = (TextView) itemView.findViewById(R.id.tv_addedby);
            tvAssignName = (TextView) itemView.findViewById(R.id.tv_assignname);
            tvTimeStamp = (TextView) itemView.findViewById(R.id.tv_timestamp);
            tvJob = (TextView) itemView.findViewById(R.id.tv_job);
            tvJobName = (TextView) itemView.findViewById(R.id.job_name);
            tvJobType = (TextView) itemView.findViewById(R.id.job_type);
            tvCompanyName = (TextView) itemView.findViewById(R.id.company_name);
            tvJobLocation = (TextView) itemView.findViewById(R.id.job_location);
            tvApplyDate = (TextView) itemView.findViewById(R.id.job_apply_date);
            tvCandidateName = (TextView) itemView.findViewById(R.id.tv_candidateName);
            tvMessage = (TextView) itemView.findViewById(R.id.tv_message);
            tvContact = (TextView) itemView.findViewById(R.id.tv_contact);
            checklist = itemView.findViewById(R.id.imgbtn_ceklis);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Mail mail = mailList.get(position);
        holder.tvAddedby.setText("Added by " + mail.getHrd_name());
        holder.tvAssignName.setText(mail.getUser_name());
        holder.tvTimeStamp.setText(mail.getTimestamp());
        holder.tvJob.setText(mail.getJob_name());
        holder.tvJobName.setText(mail.getJob_name());
        holder.tvJobType.setText(mail.getJob_type());
        holder.tvCompanyName.setText(mail.getCompany_name());
        holder.tvJobLocation.setText(mail.getJob_location());
        holder.tvApplyDate.setText(mail.getJob_apply_date());
        holder.tvCandidateName.setText("Dear " + mail.getUser_name());
        holder.tvMessage.setText(mail.getMessage());
        holder.tvContact.setText(mail.getContact());
        holder.checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, mailList.size());
            }
        });
    }


    @Override
    public int getItemCount() {
        return mailList.size();
    }



}
