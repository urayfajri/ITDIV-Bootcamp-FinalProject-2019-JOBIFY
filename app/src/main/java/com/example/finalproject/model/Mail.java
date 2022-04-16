package com.example.finalproject.model;

public class Mail {

    private String user_name;
    private String hrd_name;
    private String timestamp;
    private int isRead;
    private int isRemoved;
    private String job_name;
    private String company_name;
    private String job_type;
    private String job_location;
    private String job_apply_date;
    private String message;
    private String contact;

    public Mail(String user_name, String hrd_name, String timestamp, int isRead, int isRemoved, String job_name, String company_name, String job_type, String job_location, String job_apply_date, String userGender, String message, String contact) {
        this.user_name = user_name;
        this.hrd_name = hrd_name;
        this.timestamp = timestamp;
        this.isRead = isRead;
        this.isRemoved = isRemoved;
        this.job_name = job_name;
        this.company_name = company_name;
        this.job_type = job_type;
        this.job_location = job_location;
        this.job_apply_date = job_apply_date;
        this.message = message;
        this.contact = contact;
    }

    public Mail(){

    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String hrd_name) {
        this.user_name = user_name;
    }

    public String getHrd_name() {
        return hrd_name;
    }

    public void setHrd_name(String hrd_name) {
        this.hrd_name = hrd_name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int isRead() {
        return isRead;
    }

    public void setRead(int read) {
        isRead = read;
    }

    public int isRemoved() {
        return isRemoved;
    }

    public void setRemoved(int removed) {
        isRemoved = removed;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getJob_location() {
        return job_location;
    }

    public void setJob_location(String job_location) {
        this.job_location = job_location;
    }

    public String getJob_apply_date() {
        return job_apply_date;
    }

    public void setJob_apply_date(String job_apply_date) {
        this.job_apply_date = job_apply_date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage() {
        this.message = "Thank you for your intention to apply as an\n "+ getJob_name() +
                " at "+ getCompany_name() +" Company, we will\n contact you furthermore about this via email." +
                "\n\nIf you require any further information,\nfeel free to contact us!" +
                "\n\nBest Regards,\n" + getHrd_name() + "\n" + getCompany_name();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
