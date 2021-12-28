package com.example.physxmobile.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.physxmobile.R;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.HomeResponse;
import com.example.physxmobile.viewmodels.HomeViewModel;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferenceHelper helper = SharedPreferenceHelper.getInstance(getContext());
        HomeViewModel homeViewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        TextView homeNameTextView = view.findViewById(R.id.homeNameTextView);
        TextView homeTotalScoreTextView = view.findViewById(R.id.homeTotalScoreTextView);
        TextView homeRankingTextView = view.findViewById(R.id.homeRankingTextView);
        FrameLayout frameLayout1 = view.findViewById(R.id.homeTopic1Layout);

        homeViewModel.init(helper.getAccessToken());

        homeViewModel.getHome().observe(getViewLifecycleOwner(), new Observer<HomeResponse>() {
            @Override
            public void onChanged(HomeResponse homeResponse) {
                String hiName = "Hi " + homeResponse.getName() + "!";
                homeNameTextView.setText(hiName);
                homeTotalScoreTextView.setText(String.valueOf(homeResponse.getTotal_score()));
                homeRankingTextView.setText(String.valueOf(homeResponse.getRanking()));
            }
        });

        frameLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "a", Toast.LENGTH_SHORT).show();
            }
        });
    }
}