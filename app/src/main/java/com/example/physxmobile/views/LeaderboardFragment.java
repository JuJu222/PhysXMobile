package com.example.physxmobile.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.physxmobile.R;
import com.example.physxmobile.adapters.ButtonTopicAdapter;
import com.example.physxmobile.adapters.LeaderboardAdapter;
import com.example.physxmobile.adapters.MCQAdapter;
import com.example.physxmobile.adapters.ShopTitleAdapter;
import com.example.physxmobile.helpers.ItemClickSupport;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.LeaderboardModel;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.viewmodels.LeaderboardViewModel;
import com.example.physxmobile.viewmodels.QuestionViewModel;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardFragment extends Fragment{

    private LeaderboardViewModel leaderboardViewModel;
    private SharedPreferenceHelper helper;

    private int code_pos = 0;
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

        Button easy = view.findViewById(R.id.easy_button);
        Button hard = view.findViewById(R.id.hard_button);
        RecyclerView leaderboard = view.findViewById(R.id.leaderboard_rv);
        Button keseluruhan = view.findViewById(R.id.keseluruhan_button);
        TextView peringkat_title = view.findViewById(R.id.peringkat_title);
        ProgressBar leaderboardProgressBar = view.findViewById(R.id.leaderboardProgressBar);
        NestedScrollView leaderboardNestedScrollView = view.findViewById(R.id.leaderboardNestedScrollView);
        leaderboardViewModel = new ViewModelProvider(getActivity()).get(LeaderboardViewModel.class);
        helper = SharedPreferenceHelper.getInstance(getContext());
        leaderboardViewModel.init(helper.getAccessToken());
        leaderboardProgressBar.setVisibility(View.VISIBLE);
        leaderboardNestedScrollView.setVisibility(View.GONE);
        leaderboardViewModel.getLeaderboard().observe(getActivity(), new Observer<LeaderboardModel>() {
            @Override
            public void onChanged(LeaderboardModel leaderboardModel) {
                List<LeaderboardModel.Leaderboard> leaderboardList = leaderboardModel.getLeaderboard();

                LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(leaderboardList);

                leaderboard.setLayoutManager(new LinearLayoutManager(view.getContext()));
                leaderboard.setAdapter(leaderboardAdapter);

                easy.setVisibility(View.GONE);
                hard.setVisibility(View.GONE);

                String temp = "Peringkat " + leaderboardModel.getTopic();
                peringkat_title.setText(temp);

                leaderboardProgressBar.setVisibility(View.GONE);
                leaderboardNestedScrollView.setVisibility(View.VISIBLE);
            }
        });

        ArrayList<String> topicNames = new ArrayList<>();
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
        ButtonTopicAdapter adapter = new ButtonTopicAdapter(getContext(), topicNames);
        recyclerView.setAdapter(adapter);
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Log.e("IN","No: " + position);
                code_pos = position+1;
                Log.e("IN","No: " + code_pos);
                leaderboardViewModel.init(helper.getAccessToken());
                leaderboardViewModel.getSpecificLeaderboard(position+1).observe(getActivity(), new Observer<LeaderboardModel>() {
                    @Override
                    public void onChanged(LeaderboardModel leaderboardModel) {
                        List<LeaderboardModel.Leaderboard> leaderboardList = leaderboardModel.getLeaderboard();

                        LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(leaderboardList);
                        leaderboard.setLayoutManager(new LinearLayoutManager(view.getContext()));
                        leaderboard.setAdapter(leaderboardAdapter);

                        easy.setVisibility(View.VISIBLE);
                        hard.setVisibility(View.VISIBLE);

                        String temp = "Peringkat " + leaderboardModel.getTopic();
                        peringkat_title.setText(temp);
                    }
                });


            }
        });
        keseluruhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code_pos = 0;
                leaderboardViewModel.init(helper.getAccessToken());
                leaderboardViewModel.getLeaderboard().observe(getActivity(), new Observer<LeaderboardModel>() {
                    @Override
                    public void onChanged(LeaderboardModel leaderboardModel) {
                        List<LeaderboardModel.Leaderboard> leaderboardList = leaderboardModel.getLeaderboard();

                        LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(leaderboardList);
                        leaderboard.setLayoutManager(new LinearLayoutManager(view.getContext()));
                        leaderboard.setAdapter(leaderboardAdapter);

                        String temp = "Peringkat " + leaderboardModel.getTopic();
                        peringkat_title.setText(temp);

                        easy.setVisibility(View.GONE);
                        hard.setVisibility(View.GONE);
                    }
                });
            }
        });
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (code_pos == 0){

                }else {
                    leaderboardViewModel.init(helper.getAccessToken());
                    leaderboardViewModel.getSpecificLeaderboard(code_pos).observe(getActivity(), new Observer<LeaderboardModel>() {
                        @Override
                        public void onChanged(LeaderboardModel leaderboardModel) {
                            List<LeaderboardModel.Leaderboard> leaderboardList = leaderboardModel.getLeaderboard();

                            LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(leaderboardList);
                            leaderboard.setLayoutManager(new LinearLayoutManager(view.getContext()));
                            leaderboard.setAdapter(leaderboardAdapter);

                        }


                    });
                }
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (code_pos == 0){

                }else {
                    leaderboardViewModel.init(helper.getAccessToken());
                    leaderboardViewModel.getSpecificLeaderboard(code_pos + 10).observe(getActivity(), new Observer<LeaderboardModel>() {
                        @Override
                        public void onChanged(LeaderboardModel leaderboardModel) {
                            List<LeaderboardModel.Leaderboard> leaderboardList = leaderboardModel.getLeaderboard();

                            LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(leaderboardList);
                            leaderboard.setLayoutManager(new LinearLayoutManager(view.getContext()));
                            leaderboard.setAdapter(leaderboardAdapter);

                        }


                    });
                }
            }
        });
    }




}