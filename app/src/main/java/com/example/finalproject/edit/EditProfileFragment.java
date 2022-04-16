package com.example.finalproject.edit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalproject.R;
import com.example.finalproject.database.DatabaseHelper;
import com.example.finalproject.main.MainActivity;
import com.example.finalproject.model.User;
import com.example.finalproject.session.SharedPreference;


public class EditProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        TextView name = view.findViewById(R.id.tv_my_profile_name);
        TextView title = view.findViewById(R.id.tv_my_profile_title);

        final EditText etName = view.findViewById(R.id.et_name_edit_profile);
        final EditText etEmail = view.findViewById(R.id.et_email_edit_profile);
        final EditText etTitle = view.findViewById(R.id.et_title_edit_profile);
        final EditText etPass = view.findViewById(R.id.et_password_edit_profile);
        final EditText etRepPass = view.findViewById(R.id.et_repeat_password_edit_profile);
        Button save = view.findViewById(R.id.btn_save);

        final SharedPreference sharedPreference = new SharedPreference(getActivity());
        User user = sharedPreference.load();

        final String _keyEmail = user.getEmail();
        final String _keyJob = user.getJobPosition();

        name.setText(user.getName());
        title.setText(user.getTitle());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etPass.getText().toString().equals(etRepPass.getText().toString()))
                {
                    DatabaseHelper myDb = new DatabaseHelper(getActivity());
                    myDb.updateUser(_keyEmail, etName.getText().toString(), etEmail.getText().toString(), etTitle.getText().toString() ,etPass.getText().toString());
                    Toast.makeText(getActivity(),"Update Completed", Toast.LENGTH_SHORT).show();
                    sharedPreference.save(new User(
                            etName.getText().toString(),
                            etEmail.getText().toString(),
                            etPass.getText().toString(),
                            _keyJob,
                            etTitle.getText().toString()
                    ));
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getActivity(), "Password Not Match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    public void onResume(){
        super.onResume();

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Edit Profile");
    }
}
