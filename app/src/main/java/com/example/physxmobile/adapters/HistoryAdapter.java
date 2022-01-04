package com.example.physxmobile.adapters;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physxmobile.R;
import com.example.physxmobile.models.History;
import com.example.physxmobile.models.ShopItem;
import com.example.physxmobile.viewmodels.HistoryViewModel;
import com.example.physxmobile.viewmodels.ShopViewModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<History.Histories> historiesList;
    private HistoryViewModel historyViewModel;

    public HistoryAdapter(List<History.Histories> historiesList, HistoryViewModel historyViewModel) {
        this.historiesList = historiesList;
        this.historyViewModel = historyViewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_history, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        holder.title_history.setText(String.valueOf(historiesList.get(position).getTopic_name()));
        holder.score_history.setText(String.valueOf(historiesList.get(position).getTotal_score()));
    }

    @Override
    public int getItemCount() { return historiesList.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title_history, score_history;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_history = itemView.findViewById(R.id.title_history);
            score_history = itemView.findViewById(R.id.score_history);
        }
    }
}
