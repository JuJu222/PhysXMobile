package com.example.physxmobile.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.physxmobile.R;
import com.example.physxmobile.adapters.LeaderboardAdapter;
import com.example.physxmobile.adapters.MCQAdapter;
import com.example.physxmobile.adapters.ShopTitleAdapter;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.LeaderboardModel;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.viewmodels.LeaderboardViewModel;
import com.example.physxmobile.viewmodels.QuestionViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeaderboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeaderboardFragment extends Fragment {

    private LeaderboardViewModel leaderboardViewModel;
    private SharedPreferenceHelper helper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leaderboard, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        RecyclerView leaderboard = view.findViewById(R.id.leaderboard_rv);

        leaderboardViewModel = new ViewModelProvider(getActivity()).get(LeaderboardViewModel.class);
        helper = SharedPreferenceHelper.getInstance(getContext());

        leaderboardViewModel.init(helper.getAccessToken());
        leaderboardViewModel.getLeaderboard().observe(getActivity(), new Observer<LeaderboardModel>() {
            @Override
            public void onChanged(LeaderboardModel leaderboardModel) {
                int index = 0;
                List<LeaderboardModel.Leaderboard> leaderboardList = leaderboardModel.getLeaderboard();

                LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(leaderboardList);
                RecyclerView leaderboard = view.findViewById(R.id.leaderboard_rv);
                leaderboard.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                RecyclerView choose_topic = view.findViewById(R.id.topic_choose_rv);
                leaderboard.setAdapter(leaderboardAdapter);

            }


        });


    }
}