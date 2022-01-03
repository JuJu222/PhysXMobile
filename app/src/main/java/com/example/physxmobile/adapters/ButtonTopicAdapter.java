package com.example.physxmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physxmobile.R;
import com.example.physxmobile.models.LeaderboardModel;
import com.example.physxmobile.models.ShopItem;
import com.example.physxmobile.viewmodels.LeaderboardViewModel;

import java.util.ArrayList;
import java.util.List;

public class ButtonTopicAdapter extends RecyclerView.Adapter<ButtonTopicAdapter.ViewHolder>{

    private ArrayList<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private LeaderboardViewModel leaderboardViewModel;
    private LeaderboardAdapter leaderboardAdapter;
    // data is passed into the constructor
    public ButtonTopicAdapter(Context context, ArrayList<String> data, LeaderboardViewModel leaderboardViewModel) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.leaderboardViewModel = leaderboardViewModel;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_button_leaderboard, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.b.setText(String.valueOf(mData.get(position)));

//            for (String d: mData){
//                holder.b.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        leaderboardViewModel.getSpecificLeaderboard(holder.getAdapterPosition()).observe((LifecycleOwner) holder.b.getContext(), new Observer<LeaderboardModel>() {
//                            @Override
//                            public void onChanged(LeaderboardModel leaderboardModel) {
//                                List<LeaderboardModel.Leaderboard> leaderboardList = leaderboardModel.getLeaderboard();
//
//                                LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(leaderboardList);
//                                RecyclerView leaderboard = view.findViewById(R.id.leaderboard_rv);
//                                leaderboard.setLayoutManager(new LinearLayoutManager(holder.b.getContext()));
//                                leaderboard.setAdapter(leaderboardAdapter);
//                            }
//                        });
//                    }
//                });
//
//            }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button b;

        ViewHolder(View itemView) {
            super(itemView);
            b = itemView.findViewById(R.id.button_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    String getItem(int id) {
        return mData.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
