package com.example.physxmobile.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.physxmobile.R;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.UserModel;
import com.example.physxmobile.viewmodels.ProfileViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileFragment extends Fragment {
    Button btn_logout, btn_edit, history;
    BottomNavigationView bottomNavigationView;

    SharedPreferenceHelper helper;
    ProfileViewModel profileViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView profileNameTextView = view.findViewById(R.id.profileNameTextView);
        TextView profileEmailTextView = view.findViewById(R.id.profileEmailTextView);
        TextView profileBirthyearTextView = view.findViewById(R.id.profileBirthyearTextView);
        TextView profileUsernameTextView = view.findViewById(R.id.profileUsernameTextView);
        TextView profileSchoolTextView = view.findViewById(R.id.profileSchoolTextView);
        TextView profileCityTextView = view.findViewById(R.id.profileCityTextView);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        profileViewModel = new ViewModelProvider(getActivity()).get(ProfileViewModel.class);
        profileViewModel.init(helper.getAccessToken());

        profileViewModel.getUser().observe(getViewLifecycleOwner(), new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel user) {
                profileNameTextView.setText(user.getUser().getName());
                profileEmailTextView.setText(user.getUser().getEmail());
                profileBirthyearTextView.setText(String.valueOf(user.getUser().getBirthyear()));
                profileUsernameTextView.setText(user.getUser().getUsername());
                profileSchoolTextView.setText(user.getUser().getSchool());
                profileCityTextView.setText(user.getUser().getCity());
            }
        });

        bottomNavigationView = getActivity().findViewById(R.id.mainBottomNavigationView);
        btn_edit = view.findViewById(R.id.edit_button);
        btn_edit.setOnClickListener(view1 -> {
            Navigation.findNavController(view1).navigate(R.id.action_profileFragment_to_editProfileFragment);
        });
        history = view.findViewById(R.id.history);
        history.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_historyFragment);
        });
        btn_logout = view.findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(view1 -> {
            profileViewModel.logout().observe(requireActivity(), s -> {
                if (!s.isEmpty()) {
                    helper.clearPref();
                    BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.mainBottomNavigationView);
                    bottomNavigationView.setVisibility(View.GONE);

                    Navigation.findNavController(view1).navigate(R.id.action_profileFragment_to_loginFragment);
                    Toast.makeText(requireActivity(), s, Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}