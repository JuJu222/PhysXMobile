package com.example.physxmobile.views;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ImageViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
        NestedScrollView homeNestedScrollView = view.findViewById(R.id.homeNestedScrollView);
        ProgressBar homeProgressBar = view.findViewById(R.id.homeProgressBar);

        homeViewModel.init(helper.getAccessToken());
        ColorStateList greenCircleColor = ColorStateList.valueOf(Color.parseColor("#95DAC1"));
        ColorStateList greenTextColor = ColorStateList.valueOf(Color.parseColor("#436F5F"));
        homeProgressBar.setVisibility(View.VISIBLE);
        homeNestedScrollView.setVisibility(View.GONE);

        homeViewModel.getHome().observe(getViewLifecycleOwner(), new Observer<HomeResponse>() {
            @Override
            public void onChanged(HomeResponse homeResponse) {
                String hiName = "Hi " + homeResponse.getName() + "!";
                homeNameTextView.setText(hiName);
                homeTotalScoreTextView.setText(String.valueOf(homeResponse.getTotal_score()));
                homeRankingTextView.setText(String.valueOf(homeResponse.getRanking()));
                for (HomeResponse.UnlockedTopics unlockedTopic : homeResponse.getUnlocked_topics()) {
                    switch (unlockedTopic.getTopic_id()) {
                        case 2:
                            FrameLayout homeTopic2Layout = view.findViewById(R.id.homeTopic2Layout);
                            ImageView imageView12 = view.findViewById(R.id.imageView12);
                            TextView textView16 = view.findViewById(R.id.textView16);

                            ImageViewCompat.setImageTintList(imageView12, greenCircleColor);
                            textView16.setTextColor(greenTextColor);

                            homeTopic2Layout.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_vektor);
                                }
                            });
                            break;
                        case 3:
                            FrameLayout homeTopic3Layout = view.findViewById(R.id.homeTopic3Layout);
                            ImageView imageView15 = view.findViewById(R.id.imageView15);
                            TextView textView17 = view.findViewById(R.id.textView17);

                            ImageViewCompat.setImageTintList(imageView15, greenCircleColor);
                            textView17.setTextColor(greenTextColor);

                            homeTopic3Layout.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_gerakLurus);
                                }
                            });
                            break;
                        case 4:
                            FrameLayout homeTopic4Layout = view.findViewById(R.id.homeTopic4Layout);
                            ImageView imageView19 = view.findViewById(R.id.imageView19);
                            TextView textView18 = view.findViewById(R.id.textView18);

                            ImageViewCompat.setImageTintList(imageView19, greenCircleColor);
                            textView18.setTextColor(greenTextColor);

                            homeTopic4Layout.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_gerakParabola);
                                }
                            });
                            break;
                        case 5:
                            FrameLayout homeTopic5Layout = view.findViewById(R.id.homeTopic5Layout);
                            ImageView imageView21 = view.findViewById(R.id.imageView21);
                            TextView textView20 = view.findViewById(R.id.textView20);

                            ImageViewCompat.setImageTintList(imageView21, greenCircleColor);
                            textView20.setTextColor(greenTextColor);

                            homeTopic5Layout.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_gerakLingkarBeraturan);
                                }
                            });
                            break;
                        case 6:
                            FrameLayout homeTopic6Layout = view.findViewById(R.id.homeTopic6Layout);
                            ImageView imageView24 = view.findViewById(R.id.imageView24);
                            TextView textView21 = view.findViewById(R.id.textView21);

                            ImageViewCompat.setImageTintList(imageView24, greenCircleColor);
                            textView21.setTextColor(greenTextColor);

                            homeTopic6Layout.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_hukumNewtonGerak);
                                }
                            });
                            break;
                        case 7:
                            FrameLayout homeTopic7Layout = view.findViewById(R.id.homeTopic7Layout);
                            ImageView imageView29 = view.findViewById(R.id.imageView29);
                            TextView textView22 = view.findViewById(R.id.textView22);

                            ImageViewCompat.setImageTintList(imageView29, greenCircleColor);
                            textView22.setTextColor(greenTextColor);

                            homeTopic7Layout.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_hukumNewtonGravitasi);
                                }
                            });
                            break;
                        case 8:
                            FrameLayout homeTopic8Layout = view.findViewById(R.id.homeTopic8Layout);
                            ImageView imageView31 = view.findViewById(R.id.imageView31);
                            TextView textView23 = view.findViewById(R.id.textView23);

                            ImageViewCompat.setImageTintList(imageView31, greenCircleColor);
                            textView23.setTextColor(greenTextColor);

                            homeTopic8Layout.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_usahaDanEnergi);
                                }
                            });
                            break;
                        case 9:
                            FrameLayout homeTopic9Layout = view.findViewById(R.id.homeTopic9Layout);
                            ImageView imageView33 = view.findViewById(R.id.imageView33);
                            TextView textView24 = view.findViewById(R.id.textView24);

                            ImageViewCompat.setImageTintList(imageView33, greenCircleColor);
                            textView24.setTextColor(greenTextColor);

                            homeTopic9Layout.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_momentumDanImpuls);
                                }
                            });
                            break;
                        case 10:
                            FrameLayout homeTopic10Layout = view.findViewById(R.id.homeTopic10Layout);
                            ImageView imageView35 = view.findViewById(R.id.imageView35);
                            TextView textView25 = view.findViewById(R.id.textView25);

                            ImageViewCompat.setImageTintList(imageView35, greenCircleColor);
                            textView25.setTextColor(greenTextColor);

                            homeTopic10Layout.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_getaranHarmonis);
                                }
                            });
                            break;
                    }
                }

                homeProgressBar.setVisibility(View.GONE);
                homeNestedScrollView.setVisibility(View.VISIBLE);
            }
        });

        frameLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_besaran);
            }
        });
    }
}