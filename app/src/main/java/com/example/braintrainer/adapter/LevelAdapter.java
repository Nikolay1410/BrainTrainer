package com.example.braintrainer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.braintrainer.R;
import com.example.braintrainer.levels.Level;

import java.util.ArrayList;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.LevelViewHolder> {
    private OnLevelClickListener onLevelClickListener;
    private final ArrayList<Level> levels;

    public LevelAdapter(ArrayList<Level> levels) {
        this.levels = levels;
    }

    public interface OnLevelClickListener {
        void onLevelClick(int position);
    }

    public void setOnLevelClickListener(OnLevelClickListener onLevelClickListener) {
        this.onLevelClickListener = onLevelClickListener;
    }

    @NonNull
    @Override
    public LevelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.level_item, parent, false);
        return new LevelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelViewHolder holder, int position) {
        Level level = levels.get(position);
        holder.textViewMaxBall.setText(String.format("Максимум балов: %s", level.getMaxBall()));
        holder.textViewLevelString.setText(String.format("Level: %s", level.getLevelNumber()));
        holder.textViewExample.setText(level.getExample());
    }

    @Override
    public int getItemCount() {
        return levels.size();
    }

    class LevelViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewMaxBall;
        private final TextView textViewLevelString;
        private final TextView textViewExample;
        public LevelViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMaxBall = itemView.findViewById(R.id.textViewMaxBall);
            textViewLevelString = itemView.findViewById(R.id.textViewLevelString);
            textViewExample = itemView.findViewById(R.id.textViewExample);

            itemView.setOnClickListener(view -> onLevelClickListener.onLevelClick(getAdapterPosition()));
        }
    }
}
