package com.example.physxmobile.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.example.physxmobile.R;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.UserModel;
import com.example.physxmobile.viewmodels.ProfileViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.mainBottomNavigationView);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragmentContainerView);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        SharedPreferenceHelper helper = SharedPreferenceHelper.getInstance(this);
        ProfileViewModel profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        profileViewModel.init(helper.getAccessToken());

        bottomNavigationView.setVisibility(View.GONE);

        profileViewModel.getUser().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel userModel) {
                if (userModel == null) {
                    helper.clearPref();
                }

                if (!helper.getAccessToken().isEmpty()){
                    navController.navigate(R.id.action_splashFragment_to_homeFragment);
                    bottomNavigationView.setVisibility(View.VISIBLE);
                } else {
                    navController.navigate(R.id.action_splashFragment_to_loginFragment);
                    bottomNavigationView.setVisibility(View.GONE);
                }

                profileViewModel.resetRepositoryInstance();
            }
        });
    }
}