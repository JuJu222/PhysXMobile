package com.example.physxmobile.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.physxmobile.R;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.UserModel;
import com.example.physxmobile.viewmodels.ProfileViewModel;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditProfileFragment extends Fragment {

    TextInputLayout name_input, email_input, username_input, school_input, birthyear_input, city_input, id_input;
    SharedPreferenceHelper helper;
    ProfileViewModel profileViewModel;
    Button save_button, back_button;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditProfileFragment newInstance(String param1, String param2) {
        EditProfileFragment fragment = new EditProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name_input = view.findViewById(R.id.name_input);
        email_input = view.findViewById(R.id.email_input);
        username_input = view.findViewById(R.id.username_input);
        school_input = view.findViewById(R.id.school_input);
        city_input = view.findViewById(R.id.city_input);
        birthyear_input = view.findViewById(R.id.birthyear_input);
        id_input = view.findViewById(R.id.id_input);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        profileViewModel = new ViewModelProvider(getActivity()).get(ProfileViewModel.class);
        profileViewModel.init(helper.getAccessToken());


        profileViewModel.getUser().observe(getViewLifecycleOwner(), new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel user) {
                name_input.getEditText().setText(user.getUser().getName());
                email_input.getEditText().setText(user.getUser().getEmail());
                birthyear_input.getEditText().setText(String.valueOf(user.getUser().getBirthyear()));
                username_input.getEditText().setText(user.getUser().getUsername());
                school_input.getEditText().setText(user.getUser().getSchool());
                city_input.getEditText().setText(user.getUser().getCity());
                id_input.getEditText().setText(String.valueOf(user.getUser().getId()));
            }
        });

        save_button = view.findViewById(R.id.save_button);
        back_button = view.findViewById(R.id.back_button);
        save_button.setOnClickListener(view1 -> {
            if (!name_input.getEditText().getText().toString().isEmpty()
                    && !username_input.getEditText().getText().toString().isEmpty()
                    && !email_input.getEditText().getText().toString().isEmpty()
                    && !city_input.getEditText().getText().toString().isEmpty()
                    && !birthyear_input.getEditText().getText().toString().isEmpty()
                    && !school_input.getEditText().getText().toString().isEmpty()) {
                String name = name_input.getEditText().getText().toString().trim();
                String username = username_input.getEditText().getText().toString().trim();
                String email = email_input.getEditText().getText().toString().trim();
                String city = city_input.getEditText().getText().toString().trim();
                String birthyear = birthyear_input.getEditText().getText().toString().trim();
                String school = school_input.getEditText().getText().toString().trim();
                String id = id_input.getEditText().getText().toString().trim();
                UserModel.User profile = addProfileData(name, username, email, birthyear, city, school);

                profileViewModel.editUser(profile).observe(requireActivity(), userModel -> {
                    if (userModel !=null){
                        NavDirections actions = EditProfileFragmentDirections.actionEditProfileFragmentToProfileFragment();
                        Navigation.findNavController(view1).navigate(actions);
                        Toast.makeText(requireActivity(), "Edit Profile Success", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(requireActivity(), "Edit Profile Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(requireActivity(), "All fields must be filled", Toast.LENGTH_SHORT).show();
            }
        });


        back_button.setOnClickListener(view1 -> {
            Navigation.findNavController(view1).navigate(R.id.action_editProfileFragment_to_profileFragment);
        });
    }

    private UserModel.User addProfileData(String name, String username, String email, String birthyear, String city, String school) {
        UserModel.User profile = new UserModel.User(name, username, email, Integer.parseInt(birthyear), city, school);
        return profile;
    }

}