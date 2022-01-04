package com.example.physxmobile.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physxmobile.R;
import com.example.physxmobile.models.LeaderboardModel;

import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder>{
    private List<LeaderboardModel.Leaderboard> leaderboardList;

    public LeaderboardAdapter(@NonNull List<LeaderboardModel.Leaderboard> leaderboardList) {
        this.leaderboardList = leaderboardList;
    }
    @NonNull
    @Override
    public LeaderboardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LeaderboardAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_card_leaderboard, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardAdapter.ViewHolder holder, int position) {
        holder.name_leaderboard.setText(String.valueOf(leaderboardList.get(position).getName()));
        holder.index_leaderboard.setText(String.valueOf(position + 1));
        holder.score_leaderboard.setText(String.valueOf(leaderboardList.get(position).getTotal_score()));
    }

    @Override
    public int getItemCount() {
        return leaderboardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView index_leaderboard;
        TextView name_leaderboard;
        TextView score_leaderboard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            index_leaderboard = itemView.findViewById(R.id.index_leaderboard);
            name_leaderboard = itemView.findViewById(R.id.name_leaderboard);
            score_leaderboard = itemView.findViewById(R.id.score_leaderboard);
        }
    }
}
