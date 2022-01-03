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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.physxmobile.R;
import com.example.physxmobile.adapters.ButtonTopicAdapter;
import com.example.physxmobile.adapters.LeaderboardAdapter;
import com.example.physxmobile.adapters.MCQAdapter;
import com.example.physxmobile.adapters.ShopTitleAdapter;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.LeaderboardModel;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.viewmodels.LeaderboardViewModel;
import com.example.physxmobile.viewmodels.QuestionViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeaderboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeaderboardFragment extends Fragment implements ButtonTopicAdapter.ItemClickListener{

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
                List<LeaderboardModel.Leaderboard> leaderboardList = leaderboardModel.getLeaderboard();

                LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(leaderboardList);
                RecyclerView leaderboard = view.findViewById(R.id.leaderboard_rv);
                leaderboard.setLayoutManager(new LinearLayoutManager(getContext()));
                leaderboard.setAdapter(leaderboardAdapter);

            }


        });

        ArrayList<String> topicNames = new ArrayList<>();
        topicNames.add("Semua");
        topicNames.add("Besaran dan Satuan");
        topicNames.add("Vektor");
        topicNames.add("Gerak Lurus");
        topicNames.add("Gerak Parabola");
        topicNames.add("Gerak Melingkar Beraturan");
        topicNames.add("Hukum Newton (Gerak)");
        topicNames.add("Hukum Newton (Gravitasi)");
        topicNames.add("Usaha dan Energi");
        topicNames.add("Momentum dan Impuls");
        topicNames.add("Getaran Harmonis");

        RecyclerView recyclerView = view.findViewById(R.id.topic_choose_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        ButtonTopicAdapter adapter = new ButtonTopicAdapter(getContext(), topicNames, leaderboardViewModel);
        adapter.setClickListener(this::onItemClick);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "AYE" + position, Toast.LENGTH_SHORT).show();
        leaderboardViewModel = new ViewModelProvider(getActivity()).get(LeaderboardViewModel.class);
        helper = SharedPreferenceHelper.getInstance(getContext());

        leaderboardViewModel.init(helper.getAccessToken());
        leaderboardViewModel.getSpecificLeaderboard(position).observe(getActivity(), new Observer<LeaderboardModel>() {
            @Override
            public void onChanged(LeaderboardModel leaderboardModel) {
                List<LeaderboardModel.Leaderboard> leaderboardList = leaderboardModel.getLeaderboard();

                LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(leaderboardList);
                RecyclerView leaderboard = view.findViewById(R.id.leaderboard_rv);
                leaderboard.setLayoutManager(new LinearLayoutManager(getContext()));
                leaderboard.setAdapter(leaderboardAdapter);
            }
        });
    }


}