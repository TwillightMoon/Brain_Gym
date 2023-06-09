package com.example.braingym.UI.Fragments.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.braingym.Data.Tasks.TaskInfo;
import com.example.braingym.R;

import java.util.ArrayList;

public class TaskCardAdapter extends RecyclerView.Adapter<TaskCardAdapter.ViewHolder> {
    private final ArrayList<TaskInfo> _taskInfos;

    private onCardActionListener actionListener;
    private final int _itemLayoutID;

    public TaskCardAdapter(ArrayList<TaskInfo> cards, int itemLayoutID) {
        _itemLayoutID = itemLayoutID;
        this._taskInfos = cards;
    }

    @NonNull
    @Override
    public TaskCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(_itemLayoutID, parent, false);


        return new TaskCardAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskCardAdapter.ViewHolder holder, int position) {
        TaskInfo taskInfo = _taskInfos.get(position);

        holder.itemView.setTag(taskInfo);
        holder.titleTextView.setText(taskInfo.taskName);
        holder.descriptionTextView.setText(taskInfo.description);
        holder.awardAmountTextView.setText(String.valueOf(taskInfo.award));

        if(taskInfo.progress == 0){
            holder.constraintLayout.setVisibility(View.GONE);
            return;
        }
        holder.constraintLayout.setVisibility(View.VISIBLE);
        holder.progressBar.setMax(taskInfo.currentProgress);
        holder.progressBar.setProgress(taskInfo.currentProgress);

        holder.progressTextView.setText(String.format("%d/%d", taskInfo.currentProgress, taskInfo.progress));
    }

    @Override
    public int getItemCount() {
        return _taskInfos.size();
    }

    public void setActionListener(onCardActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView titleTextView;
        private final TextView descriptionTextView;
        private final TextView awardAmountTextView;
        private final TextView progressTextView;

        private final ProgressBar progressBar;

        private final ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.taskTitle);
            descriptionTextView = itemView.findViewById(R.id.taskTextDescription);
            awardAmountTextView = itemView.findViewById(R.id.awardTextAmount);
            progressTextView = itemView.findViewById(R.id.progressText);

            progressBar = itemView.findViewById(R.id.taskProgress);

            constraintLayout = itemView.findViewById(R.id.progress_layout);
        }
    }
}
