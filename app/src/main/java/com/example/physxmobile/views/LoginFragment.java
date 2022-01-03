package com.example.physxmobile.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.physxmobile.R;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.viewmodels.LoginViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment {
    Button btn_login;
    TextInputLayout input_email_login, input_password_login;
    TextView buttonRegister, buttonRegister1;
    BottomNavigationView bottomNavigationView;

    private LoginViewModel loginViewModel;
    private SharedPreferenceHelper helper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        input_email_login = view.findViewById(R.id.input_email_login);
        input_password_login = view.findViewById(R.id.input_password_login);
        btn_login = view.findViewById(R.id.btn_mulai_sekarang);
        buttonRegister = getActivity().findViewById(R.id.buttonRegister);
        buttonRegister1 = getActivity().findViewById(R.id.buttonRegister1);
        bottomNavigationView = getActivity().findViewById(R.id.mainBottomNavigationView);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
        buttonRegister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });

        loginViewModel = new ViewModelProvider(getActivity()).get(LoginViewModel.class);
        helper = SharedPreferenceHelper.getInstance(requireActivity());

        btn_login.setOnClickListener(view1 -> {
            if (!input_email_login.getEditText().getText().toString().isEmpty() && !input_password_login.getEditText().getText().toString().isEmpty()){
                String email = input_email_login.getEditText().getText().toString().trim();
                String pass = input_password_login.getEditText().getText().toString().trim();

                loginViewModel.login(email, pass).observe(requireActivity(), loginResponse -> {
                    if (loginResponse != null){
                        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.mainBottomNavigationView);
                        bottomNavigationView.setVisibility(View.VISIBLE);

                        helper.saveAccessToken(loginResponse.getAuthorization());
                        NavDirections actions = LoginFragmentDirections.actionLoginFragmentToHomeFragment();
                        Navigation.findNavController(view1).navigate(actions);
                        Toast.makeText(requireActivity(), "Login Success", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(requireActivity(), "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                Toast.makeText(requireActivity(), "Please Insert Email and Password", Toast.LENGTH_SHORT).show();
            }
        });
    }



}