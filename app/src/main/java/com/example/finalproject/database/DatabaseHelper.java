package com.example.finalproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.finalproject.model.Job;
import com.example.finalproject.model.Mail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Recruitment";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String MsUser = "CREATE TABLE MsUser (" +
                "UserID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT NULL," +
                "Email TEXT NULL," +
                "Password TEXT NULL," +
                "JobPosition TEXT NULL," +
                "Title TEXT NULL)";
        Log.d("Data", "onCreate: " + MsUser);
        db.execSQL(MsUser);

        String MsCompany = "CREATE TABLE MsCompany(" +
                "CompanyID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CompanyName TEXT," +
                "CompanyDesc TEXT," +
                "HRDName TEXT," +
                "Contact TEXT)";

        db.execSQL(MsCompany);

        String ROW1 = "INSERT INTO MsCompany VALUES(1, 'GARENA Indonesia', 'Garena is a consumer Internet platform provider based in Asia. It was founded in Singapore in 2009. Garena exclusively distributes game titles on Garena+ in various countries across Southeast Asia and Taiwan, such as the multiplayer online battle arena games League of Legends and Heroes of Newerth, the online soccer game FIFA Online 3 and the first-person shooter games, Point Blank and Alliance of Valiant Arms. In 2014, Garena was valued at $1 billion until the investment of the Ontario Teachers Pension Plan in the company on March 2015 increased its value to $2.5 billion.', 'HrdGarena', 'hrdgarena@gmail.com')";
        db.execSQL(ROW1);
        String ROW2 = "INSERT INTO MsCompany VALUES(2, 'SONY Corporation ', 'IKEA, home furnishings retailer that was the world’s largest seller of furniture in the early 21st century, operating more than 300 stores around the world. IKEA specializes in low-priced goods, sold whenever possible in compact “flat-pack” form for in-home assembly by the customer. IKEA was founded (1943) in Sweden and still flaunts its origins—store exteriors are decorated in the colours of the Swedish flag (blue and yellow).', 'HrdSony', 'hrdsony@gmail.com')";
        db.execSQL(ROW2);
        String ROW3 = "INSERT INTO MsCompany VALUES(3, 'UNILEVER Indonesia', 'Unilever is a multinational corporation selling consumer goods including foods, beverages, cleaning agents and personal care products. Unilever is a dual-listed company consisting of Unilever NV in Rotterdam and Unilever PLC in London. Unilever owns more than 400 brands including 11 billion-dollar brands, which each achieve annual sales in excess of €1 billion.', 'HrdUnilever', 'hrdunilever@gmail.com')";
        db.execSQL(ROW3);
        String ROW4 = "INSERT INTO MsCompany VALUES(4, 'GOOGLE LLC', 'Sony Corporation is a Japanese multinational conglomerate corporation headquartered in Kōnan, Minato, Tokyo. Its diversified business includes consumer and professional electronics, gaming, entertainment and financial services. The company owns the largest music entertainment business in the world, the largest video game console business and one of the largest video game publishing businesses, and is one of the leading manufacturers of electronic products for the consumer and professional markets, and a leading player in the film and television entertainment industry', 'HrdGoogle', 'hrdgoogle@gmail.com')";
        db.execSQL(ROW4);

        db.execSQL("CREATE TABLE MsJobDesc(" +
                "JobNameID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "JobName TEXT, " +
                "AboutJob TEXT ," +
                "SkillExp TEXT ," +
                "WhatWeOffered TEXT)");

        String rOW1 = "INSERT INTO MsJobDesc VALUES(1, 'Animator', 'A) work with your team to produce through specification for developer and to ensure the specifications of the animations are implemented providing constructive and timely feedback;\n B) Work with the senior animator and animation director to plan and track the design progress', '1) 2(+) or more years of experience recommended;\n2) Passionate about Understanding current workflow and emerging animate trends;\n3) Proficient with animation software (Adobe Animate Autodesk 3DS Max, Blender, etc)', 'A) Remuneration according to the experience of the animator;\nB) Possibillity of integration in the staff of the company')";
        db.execSQL(rOW1);

        String rOW2 = "INSERT INTO MsJobDesc VALUES(2, 'Architect', 'Architects work in the construction industry designing new buildings, restoring and\n conserving old buildings and developing new ways of using existing buildings\n Their work includes:\n A) preparing and presenting design proposals to clients\n B) advising clients\n C) producing detailed drawings, etc', '1) have strong visual awareness and an eye for detail\n2) have good drawing skills, with the ability to work in three dimensions (3D)\n3) be inventive and imaginative\n4) have reasonable mathematical skills, etc', 'A) Newly-qualified architects may earn more money than average architect salary of the year\nB) Average salaries are between £30,000 and £40,000\nC) Partners and directors can earn up to £100,000 or more')";
        db.execSQL(rOW2);

        String rOW3 = "INSERT INTO MsJobDesc VALUES(3, 'Civil Engineer', 'As engaged, open minded and curious experts in all parts of the real estate business we take responsibility for the real estate business at Ingka Group as a trustworthy, appreciated and wanted business partner. We secure new and maintain existing physical locations in order to meet the needs of the many people. We provide strategic insight based on our knowledge and understanding of the real estate portfolio in Ingka. We take the lead in delivering safe, compliant, sustainable and innovative property solutions', '1) Project management: Knowledge of how to initiate, plan, execute, control and close a project\n2) Construction management: Knowledge of how to initiate, plan, organize, execute and manage the construction of Ingka properties according to the latest Ingka standards\n3) Design management: Knowledge on setting up, organisation, management and follow-up the design of Ingka Properties throughout the project development, etc', 'The median annual wage for civil engineers is $86,640. The median wage is the wage at which half the workers in an occupation earned more than that amount and half earned less. The lowest 10 percent earned less than $54,780, and the highest 10 percent earned more than $142,560')";
        db.execSQL(rOW3);

        String rOW4 = "INSERT INTO MsJobDesc VALUES(4, 'Graphic Designer', 'To work with the Graphic Design team on the design and development of the Jigsaw brand and The Shop at Bluebird. Responsible for assisting and maintaining assets and styling across the site to ensure consistency. The role is heavily weighted to digital design, however the ideal candidate would be comfortable designing for print when required.', '1) design degree or similar\n2) advanced skills in Photoshop, Illustrator, InDesign\n3) exceptional attention to detail and creative thinking\n4) a love of fashion and knowledge of trends and designers\n5) ability to work well as part of a team', 'A) 23 days holidays\nB) Life Assurance\nC) Pension\nD) Staff discount – up to 50%, etc')";
        db.execSQL(rOW4);

        String rOW5 = "INSERT INTO MsJobDesc VALUES(5, 'Photographer', 'A rapidly growing gifting and accessories business are looking for a Product Photographer to join their team. Expanding their reach and product range has meant a hugely exciting opportunity for an experienced Product Photographer with commercial experience, a creative edge and ideally experience within the industry. A super friendly, young team who are keen on collaboration and role flexibility; looking for someone with an enthusiastic Product Photographer enthusiastic approach and a positive attitude', '1) Minimum 5 years’ experience shooting videotape and knowledge of live remote capabilities in a Broadcast station\n2) Minimum 5 years’ experience editing stories\n3) Externalapplicants must submit a resume/CV through nbcunicareers.com to be considered, etc', '1. Many entrants to the profession start as assistants, where salaries can be set at the national minimum wage\n2. In full-time employment, early career salaries are typically between £16,000 and £22,000\n3. Salaries can increase to anywhere from £25,000 to £65,000. The top end of the scale is typically for those who have a strong reputation and are highly sought-after, which takes years of experience')";
        db.execSQL(rOW5);

        String rOW6 = "INSERT INTO MsJobDesc VALUES(6, 'UX Designer', 'We’re looking for a user centred Product Designer to join our growing Product Team. You will be responsible for creating end to end, digital experiences, that meet user needs, but also deliver on business goals. You will work collaboratively with our wider product team, owning the design on a broad range of features that enable our fundraisers, donors and charities', 'A) A variety of technical skills, including, but not limited to:\n1. Interaction design and prototyping\n2.Visual design\n3. Information architecture\n4. User research and analysis\nB) Software desirables: Figma, Sketch, Invision, Adobe Creative Suite\nC) 3+ years of experience in a User Experience (UX) Design role, etc', '1) Salary is dependent on experience and goes up to around £35,000\n2) Bonus and pension scheme\n3) Flexible working to fit around commutes and commitments\n4) Amazing opportunities for training and development, etc')";
        db.execSQL(rOW6);

        db.execSQL("CREATE TABLE MsJob(" +
                "JobID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "JobNameID INTEGER," +
                "CompanyID INTEGER," +
                "JobType TEXT ," +
                "JobLocation TEXT ," +
                "isBookmark INTEGER ," +
                "JobDate TEXT ," +
                "JobCategory TEXT ," +
                "JobCounter TEXT," +
                "FOREIGN KEY(CompanyID) REFERENCES MsCompany(CompanyID)," +
                "FOREIGN KEY(JobNameID) REFERENCES MsJobDesc(JobNameID))");



        String Row1 = "INSERT INTO MsJob VALUES(1, 1, 1, 'Full Time', 'Banten', 0, 'January 12, 2019', 'Arts', 48)";
        db.execSQL(Row1);
        String Row2 = "INSERT INTO MsJob VALUES(2, 1, 1, 'Full Time', 'Banten', 0, 'Mei 3, 2019', 'Arts', 28)";
        db.execSQL(Row2);
        String Row3 = "INSERT INTO MsJob VALUES(3, 1, 2, 'Full Time', 'Banten', 1, 'Juni 15, 2019', 'Arts', 46)";
        db.execSQL(Row3);
        String Row4 = "INSERT INTO MsJob VALUES(4, 2, 3, 'Part Time', 'DKI Jakarta', 1, 'Agustus 8, 2019', 'Architecture', 27)";
        db.execSQL(Row4);
        String Row5 = "INSERT INTO MsJob VALUES(5, 2, 3, 'Full Time', 'Pekanbaru', 0,  'Desember 23, 2019', 'Architecture', 94)";
        db.execSQL(Row5);
        String Row6 = "INSERT INTO MsJob VALUES(6, 2, 4, 'Part Time', 'DKI Jakarta', 1, 'January 19, 2019', 'Architecture', 36)";
        db.execSQL(Row6);
        String Row7 = "INSERT INTO MsJob VALUES(7, 3, 1, 'Temporary', 'Pekanbaru', 0, 'January 24, 2019', 'Manufacturing', 3)";
        db.execSQL(Row7);
        String Row8 = "INSERT INTO MsJob VALUES(8, 4, 2, 'Internship', 'Batam', 0, 'March 12, 2019', 'DKV', 78)";
        db.execSQL(Row8);
        String Row9 = "INSERT INTO MsJob VALUES(9, 5, 3, 'Full Time', 'DKI Jakarta', 0, 'April 24, 2019', 'DKV', 38)";
        db.execSQL(Row9);
        String Row10 = "INSERT INTO MsJob VALUES(10, 5, 4, 'Full Time', 'Batam', 0, 'January 6, 2019', 'DKV', 36)";
        db.execSQL(Row10);
        String Row11 = "INSERT INTO MsJob VALUES(11, 6, 2, 'Outsourched', 'Pekanbaru', 1, 'Mei 12, 2019', 'DKV', 32)";
        db.execSQL(Row11);
        String Row12 = "INSERT INTO MsJob VALUES(12 ,6, 2, 'Internship', 'Pekanbaru', 0, 'Oktober 12, 2019', 'DKV', 13)";
        db.execSQL(Row12);

        db.execSQL("CREATE TABLE TrApply(" +
                "ApplyID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "JobID INTEGER, " +
                "UserID INTEGER, " +
                "TimeStamp TEXT ," +
                "ApplyDate TEXT ," +
                "Message TEXT ," +
                "isRemoved INTEGER ," +
                "isRead INTEGER, " +
                "FOREIGN KEY(JobID) REFERENCES MsJob(JobID)," +
                "FOREIGN KEY(UserID) REFERENCES MsUser(UserID))");

    }

    public int getUserId(String email)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        int idx = 1;
        String selectQuery = "SELECT * FROM MsUser";
        try{
            Cursor cursor = db.rawQuery(selectQuery, null);
            try{
                if(cursor.moveToFirst()){
                    do{
                        if(cursor.getString(cursor.getColumnIndex("Email")).equals(email))
                        {
                            return idx;
                        }
                        else idx++;
                    }while (cursor.moveToNext());
                }
            }finally {
                try {
                    cursor.close();
                }catch (Exception ignore) {}
            }
        }finally {
            try{
                db.close();
            }catch (Exception ignore){}
        }

        return 0;
    }

    public int getJobID(String jobDate)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = ("SELECT * FROM  MsJob j " +
                "WHERE JobDate = '" +  jobDate + "' ");

        Cursor cursor = db.rawQuery(sql, null);
        int idx = 0;
        if(cursor.moveToFirst())
        {
            idx = cursor.getInt(cursor.getColumnIndex("JobID"));
        }
        return idx;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS MsUser");
        db.execSQL("DROP TABLE IF EXISTS TrApply");
        db.execSQL("DROP TABLE IF EXISTS MsJob");
        db.execSQL("DROP TABLE IF EXISTS MsCompany");
        db.execSQL("DROP TABLE IF EXISTS MsJobDesc");
    }

    public boolean insert(String name, String email, String password, String jobposition, String title)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Email", email);
        contentValues.put("Password", password);
        contentValues.put("JobPosition", jobposition);
        contentValues.put("Title", title);
        long ins = db.insert("MsUser", null, contentValues);
        if(ins == -1) return false;
        else return true;
    }

    public void updateUser(String keyemail,String name, String email, String title, String pass)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "UPDATE MsUser SET Name = '" + name + "', " +
                "Email = '" + email + "', " +
                "Title = '" + title + "', " +
                "Password = '" + pass + "' " +
                "WHERE Email = '" + keyemail + "'";
        db.execSQL(sql);
    }

    public boolean checkUser(String email)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM MsUser WHERE Email=? ",new String[]{email});
        if(cursor.getCount() > 0) return false;
        return true;
    }

    public boolean getUser(String email, String pass)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM MsUser WHERE Email=? AND Password=?",new String[]{email, pass});
        if(cursor.getCount() > 0) return true;
        return false;
    }

    public void updatePass(String email, String pass)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "UPDATE MsUser SET Password = '" + pass + "' WHERE Email = '" + email + "'";
        db.execSQL(sql);
    }


    public boolean insertApply(int JobID, int UserID)
    {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
        String applyDate = dateformat.format(calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR, 7);
        dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        String timeStamp = dateformat.format(calendar.getTime());


        Mail mail = new Mail();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("JobID", JobID);
        contentValues.put("UserID", UserID);
        contentValues.put("TimeStamp", timeStamp);
        contentValues.put("ApplyDate", applyDate);
        contentValues.put("Message", mail.getMessage());
        contentValues.put("isRemoved", 0);
        contentValues.put("isRead", 0);
        long ins = db.insert("TrApply", null, contentValues);
        if(ins == -1) return false;
        else return true;
    }

    public ArrayList<Mail> getMail(int userID){
        ArrayList<Mail> mailList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = null;
        selectQuery = ("SELECT * FROM  TrApply a " +
                "JOIN MsUser u ON u.UserID = a.UserID " +
                "JOIN MsJob j ON j.JobID = a.JobID " +
                "JOIN MsCompany c ON c.CompanyID = j.CompanyID " +
                "JOIN MsJobDesc jd ON jd.JobNameID = j.JobNameID " +
                "WHERE a.userID = '" +  userID + "' AND isRemoved = 0");

        try{
            Cursor cursor = db.rawQuery(selectQuery, null);
            try{
                if(cursor.moveToFirst()){
                    do{
                        Mail mail = new Mail();
                        mail.setUser_name(cursor.getString(cursor.getColumnIndex("Name")));
                        mail.setHrd_name(cursor.getString(cursor.getColumnIndex("HRDName")));
                        mail.setTimestamp(cursor.getString(cursor.getColumnIndex("TimeStamp")));
                        mail.setJob_name(cursor.getString(cursor.getColumnIndex("JobName")));
                        mail.setCompany_name(cursor.getString(cursor.getColumnIndex("CompanyName")));
                        mail.setJob_type(cursor.getString(cursor.getColumnIndex("JobType")));
                        mail.setJob_location(cursor.getString(cursor.getColumnIndex("JobLocation")));
                        mail.setJob_apply_date(cursor.getString(cursor.getColumnIndex("ApplyDate")));
                        mail.setRemoved(0);
                        mail.setRead(0);
                        mail.setMessage();
                        mail.setContact(cursor.getString(cursor.getColumnIndex("Contact")));
                        mailList.add(mail);
                    }while (cursor.moveToNext());
                }
            }finally {
                try {
                    cursor.close();
                }catch (Exception ignore) {}
            }
        }finally {
            try{
                db.close();
            }catch (Exception ignore){}
        }

        return mailList;
    }

    public ArrayList<Mail> getTrash(int userID){
        ArrayList<Mail> mailList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = null;
        selectQuery = ("SELECT * FROM  TrApply a " +
                "JOIN MsUser u ON u.UserID = a.UserID " +
                "JOIN MsJob j ON j.JobID = a.JobID " +
                "JOIN MsCompany c ON c.CompanyID = j.CompanyID " +
                "JOIN MsJobDesc jd ON jd.JobNameID = j.JobNameID " +
                "WHERE a.userID = '" +  userID + "' AND isRemoved = 1");

        try{
            Cursor cursor = db.rawQuery(selectQuery, null);
            try{
                if(cursor.moveToFirst()){
                    do{
                        Mail mail = new Mail();
                        mail.setUser_name(cursor.getString(cursor.getColumnIndex("Name")));
                        mail.setHrd_name(cursor.getString(cursor.getColumnIndex("HRDName")));
                        mail.setTimestamp(cursor.getString(cursor.getColumnIndex("TimeStamp")));
                        mail.setJob_name(cursor.getString(cursor.getColumnIndex("JobName")));
                        mail.setCompany_name(cursor.getString(cursor.getColumnIndex("CompanyName")));
                        mail.setJob_type(cursor.getString(cursor.getColumnIndex("JobType")));
                        mail.setJob_location(cursor.getString(cursor.getColumnIndex("JobLocation")));
                        mail.setJob_apply_date(cursor.getString(cursor.getColumnIndex("ApplyDate")));
                        mail.setRemoved(0);
                        mail.setRead(0);
                        mail.setMessage();
                        mail.setContact(cursor.getString(cursor.getColumnIndex("Contact")));
                        mailList.add(mail);
                    }while (cursor.moveToNext());
                }
            }finally {
                try {
                    cursor.close();
                }catch (Exception ignore) {}
            }
        }finally {
            try{
                db.close();
            }catch (Exception ignore){}
        }

        return mailList;
    }


    public ArrayList<Job> getSelectedJobList(String category,String type,String location){
        ArrayList<Job> jobList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = null;

        if(type.equals("All Type"))
        {
            selectQuery = "SELECT * FROM MsJob j " +
                    "JOIN MsJobDesc d ON j.JobNameID = d.JobNameID " +
                    "JOIN MsCompany c ON j.CompanyID = c.CompanyID "+
                    "WHERE JobCategory = '" + category + "' " +
                    "AND JobLocation = '" +  location + "' ";
        }
        else
        {
            selectQuery = "SELECT * FROM MsJob j " +
                    "JOIN MsJobDesc d ON j.JobNameID = d.JobNameID " +
                    "JOIN MsCompany c ON j.CompanyID = c.CompanyID "+
                    "WHERE JobCategory = '" + category + "' " +
                    "AND JobType = '" + type + "' " +
                    "AND JobLocation = '" +  location + "' ";
        }

        try{
            Cursor cursor = db.rawQuery(selectQuery, null);
            try{
                if(cursor.moveToFirst()){
                    do{
                        Job job = new Job();
                        job.setId((cursor.getColumnIndex("JobID")));
                        job.setJobName(cursor.getString(cursor.getColumnIndex("JobName")));
                        job.setJobCategory(cursor.getString(cursor.getColumnIndex("JobCategory")));
                        job.setJobLocation(cursor.getString(cursor.getColumnIndex("JobLocation")));
                        job.setJobPlace(cursor.getString(cursor.getColumnIndex("CompanyName")));
                        job.setIsBookmark(cursor.getInt(cursor.getColumnIndex("isBookmark")));
                        job.setJobType(cursor.getString(cursor.getColumnIndex("JobType")));
                        job.setJobCounter(cursor.getInt(cursor.getColumnIndex("JobCounter")));
                        job.setJobDate(cursor.getString(cursor.getColumnIndex("JobDate")));
                        jobList.add(job);
                    }while (cursor.moveToNext());
                }
            }finally {
                try {
                    cursor.close();
                }catch (Exception ignore) {}
            }
        }finally {
            try{
                db.close();
            }catch (Exception ignore){}
        }

        return jobList;
    }

    public void deleteTrash()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM MsTrash");
    }

    public ArrayList <Job> getBookmark(){
        ArrayList<Job> jobList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = ("SELECT * FROM MsJob j " +
                "JOIN MsJobDesc d ON j.JobNameID = d.JobNameID " +
                "JOIN MsCompany c ON j.CompanyID = c.CompanyID " +
                "WHERE isBookmark = 1");
        try{
            Cursor cursor = db.rawQuery(selectQuery, null);
            try{
                if(cursor.moveToFirst()){
                    do{
                        Job job = new Job();
                        job.setJobName(cursor.getString(cursor.getColumnIndex("JobName")));
                        job.setJobCategory(cursor.getString(cursor.getColumnIndex("JobCategory")));
                        job.setJobLocation(cursor.getString(cursor.getColumnIndex("JobLocation")));
                        job.setJobPlace(cursor.getString(cursor.getColumnIndex("CompanyName")));
                        job.setIsBookmark(cursor.getInt(cursor.getColumnIndex("isBookmark")));
                        job.setJobType(cursor.getString(cursor.getColumnIndex("JobType")));
                        job.setJobCounter(cursor.getInt(cursor.getColumnIndex("JobCounter")));
                        job.setJobDate(cursor.getString(cursor.getColumnIndex("JobDate")));
                        jobList.add(job);
                    }while (cursor.moveToNext());
                }
            }finally {
                try {
                    cursor.close();
                }catch (Exception ignore) {}
            }
        }finally {
            try{
                db.close();
            }catch (Exception ignore){}
        }

        return jobList;
    }



}
