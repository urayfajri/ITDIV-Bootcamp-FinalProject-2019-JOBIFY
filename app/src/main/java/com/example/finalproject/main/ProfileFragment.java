package com.example.finalproject.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.finalproject.R;
import com.example.finalproject.edit.EditAbilityFragment;
import com.example.finalproject.edit.EditEducationFragment;
import com.example.finalproject.edit.EditProfessionalExperienceFragment;
import com.example.finalproject.edit.EditProfileFragment;
import com.example.finalproject.model.User;
import com.example.finalproject.session.SharedPreference;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile_fragment, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("My Profile");

        SharedPreference sharedPreference = new SharedPreference(getActivity());
        User user = sharedPreference.load();
        TextView name = view.findViewById(R.id.tv_my_profile_name);
        TextView title = view.findViewById(R.id.tv_my_profile_title);
        name.setText(user.getName());
        title.setText(user.getTitle());
        ImageView editProfile;
        editProfile = view.findViewById(R.id.btn_edit_profile);


        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EditProfileFragment()).addToBackStack(null).commit();
            }
        });


        return view;
    }
}
