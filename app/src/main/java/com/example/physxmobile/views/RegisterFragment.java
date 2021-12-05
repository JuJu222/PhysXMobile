package com.example.physxmobile.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.physxmobile.R;
import com.example.physxmobile.viewmodels.RegisterViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterFragment extends Fragment {
    Button button_register;

    TextView buttonLogin, buttonLogin1;
    TextInputLayout input_name_register, input_username_register, input_password_register,input_passwordconfirmation_register,input_school_register,input_city_register,input_birthyear_register, input_email_register;

    private RegisterViewModel registerViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonLogin = getActivity().findViewById(R.id.buttonLogin);
        buttonLogin1 = getActivity().findViewById(R.id.buttonLogin1);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment);
            }
        });
        buttonLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment);
            }
        });

        input_name_register = view.findViewById(R.id.input_name_register);
        input_username_register = view.findViewById(R.id.input_username_register);
        input_email_register = view.findViewById(R.id.input_email_register);
        input_password_register = view.findViewById(R.id.input_password_register);
        input_passwordconfirmation_register = view.findViewById(R.id.input_passwordconfirmation_register);
        input_city_register = view.findViewById(R.id.input_city_register);
        input_birthyear_register = view.findViewById(R.id.input_birthyear_register);
        input_school_register = view.findViewById(R.id.input_school_register);
        button_register = view.findViewById(R.id.button_register);

        registerViewModel = new ViewModelProvider(getActivity()).get(RegisterViewModel.class);

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input_name_register.getEditText().getText().toString().isEmpty()
                        && !input_username_register.getEditText().getText().toString().isEmpty()
                        && !input_email_register.getEditText().getText().toString().isEmpty()
                        && !input_password_register.getEditText().getText().toString().isEmpty()
                        && !input_passwordconfirmation_register.getEditText().getText().toString().isEmpty()
                        && !input_city_register.getEditText().getText().toString().isEmpty()
                        && !input_birthyear_register.getEditText().getText().toString().isEmpty()
                        && !input_school_register.getEditText().getText().toString().isEmpty()) {
                    String name= input_name_register.getEditText().getText().toString().trim();
                    String username= input_username_register.getEditText().getText().toString().trim();
                    String email = input_email_register.getEditText().getText().toString().trim();
                    String pass = input_password_register.getEditText().getText().toString().trim();
                    String passconfirmation = input_passwordconfirmation_register.getEditText().getText().toString().trim();
                    String city = input_city_register.getEditText().getText().toString().trim();
                    String birthyear = input_birthyear_register.getEditText().getText().toString().trim();
                    int finalbirthyear = Integer.parseInt(birthyear);
                    String school = input_school_register.getEditText().getText().toString().trim();
                    registerViewModel.register(name, email, pass, passconfirmation, username, school, city, finalbirthyear).observe(requireActivity(), registerResponse -> {
                        if (registerResponse!=null){
                            Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment);
                            Toast.makeText(requireActivity(), "Register Success", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(requireActivity(), "Register Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(requireActivity(), "All field must not empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}