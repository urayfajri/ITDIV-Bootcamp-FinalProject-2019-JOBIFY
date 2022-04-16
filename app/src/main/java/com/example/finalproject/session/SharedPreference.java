package com.example.finalproject.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.finalproject.model.Job;
import com.example.finalproject.model.User;

public class SharedPreference {

    private SharedPreferences sharedPreferences;

    public SharedPreference(Context context) {
        sharedPreferences = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
    }

    public void save(User user)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", user.getName());
        editor.putString("Email", user.getEmail());
        editor.putString("Password", user.getPassword());
        editor.putString("JobPosition", user.getJobPosition());
        editor.putString("Title", user.getTitle());
        editor.apply();
    }

    public void saveFilter(Job job)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Category", job.getJobCategory());
        editor.putString("Type", job.getJobType());
        editor.putString("Location", job.getJobLocation());
        editor.apply();
    }

    public void saveJob(Job job)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Id", job.getId());
        editor.putString("Name", job.getJobName());
        editor.putString("Location", job.getJobLocation());
        editor.putString("Place", job.getJobPlace());
        editor.putString("Date", job.getJobDate());
        editor.putString("Type", job.getJobType());
        editor.putInt("Bookmark", job.getIsBookmark());
        editor.apply();
    }

    public Job loadJob()
    {
        Job job = new Job();
        job.setId(sharedPreferences.getInt("Id", 0));
        job.setJobName(sharedPreferences.getString("Name", ""));
        job.setJobLocation(sharedPreferences.getString("Location", ""));
        job.setJobPlace(sharedPreferences.getString("Place", ""));
        job.setJobDate(sharedPreferences.getString("Date", ""));
        job.setJobType(sharedPreferences.getString("Type", ""));
        job.setIsBookmark(sharedPreferences.getInt("Bookmark", 0));
        return job;
    }

    public Job loadFilter()
    {
        Job job = new Job();
        job.setJobCategory(sharedPreferences.getString("Category", ""));
        job.setJobType(sharedPreferences.getString("Type", ""));
        job.setJobLocation(sharedPreferences.getString("Location", ""));
        return job;
    }

    public User load()
    {
        User user = new User();
        user.setName(sharedPreferences.getString("Name", ""));
        user.setEmail(sharedPreferences.getString("Email", ""));
        user.setPassword(sharedPreferences.getString("Password", ""));
        user.setJobPosition(sharedPreferences.getString("JobPosition", ""));
        user.setTitle(sharedPreferences.getString("Title", ""));
        return user;
    }

}
