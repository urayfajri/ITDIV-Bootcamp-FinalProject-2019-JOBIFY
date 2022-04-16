package com.example.finalproject.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.finalproject.R;
import com.example.finalproject.SearchJob;
import com.example.finalproject.model.Job;
import com.example.finalproject.session.SharedPreference;


public class LookFragment extends Fragment {

    String selectedCategory,selectedOrder;

    TextView clear;
    RelativeLayout selectCategory;
    RelativeLayout selectOrder;
    TextView textViewSelectCategory,textViewSelectOrder;


    Button jobAll,jobFullTime,jobPartTime,jobTemporaryTime,jobInternshipTime,jobOutsourcedTime;
    Button locationBanten,locationJakarta,locationWestJava;


    boolean allTime=false,fullTime=false,partTime=false,temporaryTime=false,internShipTime=false,outsourchedTime=false; // validate  choosing only 1
    boolean banten=false,jakarta=false,westJava=false;
    Button searchJobButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_look_fragment, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Look for a Job");

        selectCategory =(RelativeLayout) view.findViewById(R.id.rl_select_category);


        textViewSelectCategory = view.findViewById(R.id.et_select_category);

        searchJobButton = view.findViewById(R.id.btn_search_job);
//        clear = view.findViewById(R.id.tv_clear);

        //button job type
        jobAll= (Button)view.findViewById(R.id.btn_all_type);
        jobFullTime=(Button) view.findViewById(R.id.btn_full_time);
        jobPartTime=(Button) view.findViewById(R.id.btn_part_time);
        jobInternshipTime=(Button) view.findViewById(R.id.btn_internship_time);
        jobTemporaryTime =(Button) view.findViewById(R.id.btn_temporary_time);
        jobOutsourcedTime=(Button) view.findViewById((R.id.btn_outsourced_time));

        //button location
        locationBanten=(Button) view.findViewById(R.id.btn_location_banten);
        locationJakarta=(Button) view.findViewById(R.id.btn_location_jakarta);
        locationWestJava=(Button) view.findViewById(R.id.btn_location_westjava);


        locationBanten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(banten==false){
                    locationBanten.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.button_change));
                    locationBanten.setTextColor(getResources().getColor(R.color.white));
                    banten=true;

                    if(jakarta==true){
                        locationJakarta.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        locationJakarta.setTextColor(getResources().getColor(R.color.black));
                        jakarta=false;
                    }
                    else if(westJava==true){
                        locationWestJava.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        locationWestJava.setTextColor(getResources().getColor(R.color.black));
                        westJava=false;
                    }
                }
            }
        });

        locationJakarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jakarta==false){
                    locationJakarta.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.button_change));
                    locationJakarta.setTextColor(getResources().getColor(R.color.white));
                    jakarta=true;

                    if(banten==true){
                        locationBanten.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        locationBanten.setTextColor(getResources().getColor(R.color.black));
                        banten=false;
                    }
                    else if(westJava==true){
                        locationWestJava.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        locationWestJava.setTextColor(getResources().getColor(R.color.black));
                        westJava=false;
                    }
                }
            }
        });

        locationWestJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(westJava==false){
                    locationWestJava.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.button_change));
                    locationWestJava.setTextColor(getResources().getColor(R.color.white));
                    westJava=true;

                    if(jakarta==true){
                        locationJakarta.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        locationJakarta.setTextColor(getResources().getColor(R.color.black));
                        jakarta=false;
                    }
                    else if(banten==true){
                        locationBanten.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        locationBanten.setTextColor(getResources().getColor(R.color.black));
                        banten=false;
                    }
                }
            }
        });

        jobAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allTime==false) {
                    jobAll.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.button_change));
                    jobAll.setTextColor(getResources().getColor(R.color.white));
                    allTime=true;

                    if(fullTime==true) {
                        jobFullTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobFullTime.setTextColor(getResources().getColor(R.color.black));
                        fullTime=false;
                    }
                    else if(partTime==true) {
                        jobPartTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobPartTime.setTextColor(getResources().getColor(R.color.black));
                        partTime=false;
                    }
                    else if(temporaryTime==true){
                        jobTemporaryTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobTemporaryTime.setTextColor(getResources().getColor(R.color.black));
                        temporaryTime=false;
                    }
                    else if(internShipTime==true){
                        jobInternshipTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobInternshipTime.setTextColor(getResources().getColor(R.color.black));
                        internShipTime=false;
                    }
                    else if(outsourchedTime==true){
                        jobOutsourcedTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobOutsourcedTime.setTextColor(getResources().getColor(R.color.black));
                        outsourchedTime=false;
                    }

                }
            }

        });

        jobFullTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fullTime==false) {
                    jobFullTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.button_change));
                    jobFullTime.setTextColor(getResources().getColor(R.color.white));
                    fullTime=true;

                    if(allTime==true) {
                        jobAll.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobAll.setTextColor(getResources().getColor(R.color.black));
                        allTime=false;
                    }
                    else if(partTime==true) {
                        jobPartTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobPartTime.setTextColor(getResources().getColor(R.color.black));
                        partTime=false;
                    }
                    else if(temporaryTime==true){
                        jobTemporaryTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobTemporaryTime.setTextColor(getResources().getColor(R.color.black));
                        temporaryTime=false;
                    }
                    else if(internShipTime==true){
                        jobInternshipTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobInternshipTime.setTextColor(getResources().getColor(R.color.black));
                        internShipTime=false;
                    }
                    else if(outsourchedTime==true){
                        jobOutsourcedTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobOutsourcedTime.setTextColor(getResources().getColor(R.color.black));
                        outsourchedTime=false;
                    }

                }
            }
        });

        jobPartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(partTime==false){
                    jobPartTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.button_change));
                    jobPartTime.setTextColor(getResources().getColor(R.color.white));
                    partTime=true;

                    if(allTime==true) {
                        jobAll.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobAll.setTextColor(getResources().getColor(R.color.black));
                        allTime=false;
                    }
                    else if(fullTime==true) {
                        jobFullTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobFullTime.setTextColor(getResources().getColor(R.color.black));
                        fullTime=false;
                    }
                    else if(temporaryTime==true){
                        jobTemporaryTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobTemporaryTime.setTextColor(getResources().getColor(R.color.black));
                        temporaryTime=false;
                    }
                    else if(internShipTime==true){
                        jobInternshipTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobInternshipTime.setTextColor(getResources().getColor(R.color.black));
                        internShipTime=false;
                    }
                    else if(outsourchedTime==true){
                        jobOutsourcedTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobOutsourcedTime.setTextColor(getResources().getColor(R.color.black));
                        outsourchedTime=false;
                    }
                }

            }
        });

        jobTemporaryTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(temporaryTime==false){
                    jobTemporaryTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.button_change));
                    jobTemporaryTime.setTextColor(getResources().getColor(R.color.white));
                    temporaryTime=true;

                    if(allTime==true) {
                        jobAll.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobAll.setTextColor(getResources().getColor(R.color.black));
                        allTime=false;
                    }
                    else if(partTime==true) {
                        jobPartTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobPartTime.setTextColor(getResources().getColor(R.color.black));
                        partTime=false;
                    }
                    else if(fullTime==true){
                        jobFullTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobFullTime.setTextColor(getResources().getColor(R.color.black));
                        temporaryTime=false;
                    }
                    else if(internShipTime==true){
                        jobInternshipTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobInternshipTime.setTextColor(getResources().getColor(R.color.black));
                        internShipTime=false;
                    }
                    else if(outsourchedTime==true){
                        jobOutsourcedTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobOutsourcedTime.setTextColor(getResources().getColor(R.color.black));
                        outsourchedTime=false;
                    }
                }

            }
        });

        jobInternshipTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(internShipTime==false){
                    jobInternshipTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.button_change));
                    jobInternshipTime.setTextColor(getResources().getColor(R.color.white));
                    internShipTime=true;

                    if(allTime==true) {
                        jobAll.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobAll.setTextColor(getResources().getColor(R.color.black));
                        allTime=false;
                    }
                    else if(partTime==true) {
                        jobPartTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobPartTime.setTextColor(getResources().getColor(R.color.black));
                        partTime=false;
                    }
                    else if(fullTime==true){
                        jobFullTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobFullTime.setTextColor(getResources().getColor(R.color.black));
                        fullTime=false;
                    }
                    else if(temporaryTime==true){
                        jobTemporaryTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobTemporaryTime.setTextColor(getResources().getColor(R.color.black));
                        temporaryTime=false;
                    }
                    else if(outsourchedTime==true){
                        jobOutsourcedTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobOutsourcedTime.setTextColor(getResources().getColor(R.color.black));
                        outsourchedTime=false;
                    }
                }

            }
        });

        jobOutsourcedTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(outsourchedTime==false){
                    jobOutsourcedTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.button_change));
                    jobOutsourcedTime.setTextColor(getResources().getColor(R.color.white));
                    outsourchedTime=true;

                    if(allTime==true) {
                        jobAll.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobAll.setTextColor(getResources().getColor(R.color.black));
                        allTime=false;
                    }
                    else if(partTime==true) {
                        jobPartTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobPartTime.setTextColor(getResources().getColor(R.color.black));
                        partTime=false;
                    }
                    else if(temporaryTime==true){
                        jobTemporaryTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobTemporaryTime.setTextColor(getResources().getColor(R.color.black));
                        temporaryTime=false;
                    }
                    else if(internShipTime==true){
                        jobInternshipTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobInternshipTime.setTextColor(getResources().getColor(R.color.black));
                        internShipTime=false;
                    }
                    else if(fullTime==true){
                        jobFullTime.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rectangle_corner));
                        jobFullTime.setTextColor(getResources().getColor(R.color.black));
                        fullTime=false;
                    }
                }

            }
        });


        selectCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu categoryMenu = new PopupMenu(getActivity(),selectCategory);
                categoryMenu.getMenuInflater().inflate(R.menu.menu_select_category_job_filter,categoryMenu.getMenu());

                categoryMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        selectedCategory=item.getTitle().toString();
                        textViewSelectCategory.setText(selectedCategory);
                        return true;
                    }
                });

                categoryMenu.show();
            }
        });



        //when search button kliked
        searchJobButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String category = textViewSelectCategory.getText().toString();


                if(category.compareTo("Select Category")==0 ) {
                    Toast.makeText(getActivity(), "Please fill the category and order", Toast.LENGTH_SHORT).show();
                }
                else if(allTime==false && fullTime==false && partTime==false && internShipTime==false && temporaryTime==false && outsourchedTime==false){
                    Toast.makeText(getActivity(),"Please select job type", Toast.LENGTH_SHORT).show();
                }
                else if(banten==false && jakarta==false && westJava==false){
                    Toast.makeText(getActivity(),"Please select location", Toast.LENGTH_SHORT).show();
                }

                if(!(category.compareTo("Select Category")==0 ) &&
                        !(allTime==false && fullTime==false && partTime==false && internShipTime==false && temporaryTime==false && outsourchedTime==false)
                        && !(banten==false && jakarta==false && westJava==false))
                {
                    Toast.makeText(getActivity(),"Success", Toast.LENGTH_SHORT).show();

                    SearchJob searchJob = new SearchJob();

                    searchJob.setCategory(category);

                    //tampung nilai job type
                    if(allTime==true) {
                        searchJob.setJobType("All Type");
                    }
                    else if(fullTime==true){
                        searchJob.setJobType("Full Time");
                    }
                    else if(partTime==true) {
                        searchJob.setJobType("Part Time");
                    }
                    else if(temporaryTime==true){
                        searchJob.setJobType("Temporary");
                    }
                    else if(internShipTime==true){
                        searchJob.setJobType("Internship");

                    }
                    else if(outsourchedTime==true){
                        searchJob.setJobType("Outsourched");
                    }

                    if(banten==true){
                        searchJob.setLocation("Banten");
                    }
                    else if(jakarta==true){
                        searchJob.setLocation("DKI Jakarta");
                    }
                    else if(westJava==true){
                        searchJob.setLocation("West Java");

                    }

                    SharedPreference sharedPreference = new SharedPreference(getActivity());
                    sharedPreference.saveFilter(new Job(
                            searchJob.getCategory(),
                            searchJob.getJobType(),
                            searchJob.getLocation()
                    ));
                    FragmentManager fm = getFragmentManager();
                    fm.beginTransaction().replace(R.id.fragment_container, (Fragment)new JoblistFragment()).addToBackStack(null).commit();
                }
            }
        });

        return view;
    }

}

