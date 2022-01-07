package com.example.physxmobile.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
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
        if (leaderboardList.get(position).getTitle() == null) {
            holder.leaderboardTitleTextView.setText("Novice");
        } else {
            holder.leaderboardTitleTextView.setText(leaderboardList.get(position).getTitle());
        }
        if (leaderboardList.get(position).getAvatar() == null) {
            Glide.with(holder.leaderboardAvatarImageView.getContext()).load("http://159.89.208.113/img/avatars/avatar_1.png")
                    .into(holder.leaderboardAvatarImageView);
        } else {
            Glide.with(holder.leaderboardAvatarImageView.getContext()).load("http://159.89.208.113/img/avatars/" + leaderboardList.get(position).getAvatar())
                    .into(holder.leaderboardAvatarImageView);
        }
    }

    @Override
    public int getItemCount() {
        return leaderboardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView index_leaderboard;
        TextView name_leaderboard;
        TextView score_leaderboard;
        TextView leaderboardTitleTextView;
        ImageView leaderboardAvatarImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            index_leaderboard = itemView.findViewById(R.id.index_leaderboard);
            name_leaderboard = itemView.findViewById(R.id.name_leaderboard);
            score_leaderboard = itemView.findViewById(R.id.score_leaderboard);
            leaderboardTitleTextView = itemView.findViewById(R.id.leaderboardTitleTextView);
            leaderboardAvatarImageView = itemView.findViewById(R.id.leaderboardAvatarImageView);
        }
    }
}
