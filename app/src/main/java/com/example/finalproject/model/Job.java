package com.example.finalproject.model;

public class Job {

    String jobName,jobCategory, jobLocation,jobPlace,jobDate,jobType;
    int isBookmark,jobCounter, id;

    public Job(int id, String jobName, String jobCategory, String jobLocation, String jobPlace, String jobDate, String jobType, int isBookmark, int jobCounter) {
        this.id = id;
        this.jobName = jobName;
        this.jobCategory = jobCategory;
        this.jobLocation = jobLocation;
        this.jobPlace = jobPlace;
        this.jobDate = jobDate;
        this.jobType = jobType;
        this.isBookmark = isBookmark;
        this.jobCounter = jobCounter;
    }

    public Job(String jobCategory, String jobType, String jobLocation) {

        this.jobCategory = jobCategory;
        this.jobLocation = jobLocation;
        this.jobType = jobType;

    }

    public Job(int id, String jobName, String jobLocation, String jobPlace, String jobDate, String jobType, int isBookmark) {
        this.id = id;
        this.jobName = jobName;
        this.jobLocation = jobLocation;
        this.jobPlace = jobPlace;
        this.jobDate = jobDate;
        this.jobType = jobType;
        this.isBookmark = isBookmark;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public void setJobPlace(String jobPlace) {
        this.jobPlace = jobPlace;
    }

    public String getJobDate() {
        return jobDate;
    }

    public void setJobDate(String jobDate) {
        this.jobDate = jobDate;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public int getIsBookmark() {
        return isBookmark;
    }

    public void setIsBookmark(int isBookmark) {
        this.isBookmark = isBookmark;
    }

    public int getJobCounter() {
        return jobCounter;
    }

    public void setJobCounter(int jobCounter) {
        this.jobCounter = jobCounter;
    }

    public Job(){};
}
