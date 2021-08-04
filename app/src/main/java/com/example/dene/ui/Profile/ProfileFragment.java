package com.example.dene.ui.Profile;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dene.LoginActivity;
import com.example.dene.R;
import com.example.dene.user;

public class ProfileFragment extends Fragment {

    private ProfileViewModel mViewModel;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }
    TextView name, surname, email;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.profile_fragment, container, false);
        name = root.findViewById(R.id.name);
        surname = root.findViewById(R.id.lastName);
        email = root.findViewById(R.id.email);
        for (user u: LoginActivity.userList) {
            if(u.getEmail().equals(LoginActivity.username[0])){
                name.setText("İsim: "+u.getUser_name());
                surname.setText("Soyisim: "+u.getUser_lastname());
                email.setText("E-mail: "+u.getEmail());
            }
        }
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        // TODO: Use the ViewModel
    }

}