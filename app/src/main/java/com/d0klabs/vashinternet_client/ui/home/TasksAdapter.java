package com.d0klabs.vashinternet_client.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.d0klabs.vashinternet_client.R;
import com.d0klabs.vashinternet_client.event.EventRepo;

import org.jetbrains.annotations.NotNull;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {
    private final Context context;
    private final LayoutInflater mLayoutInflater;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView taskName;
        TextView taskPrice;
        TextView taskDuration;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            this.taskName = (TextView) itemView.findViewById(R.id.textView_TaskName);
            this.taskPrice = (TextView) itemView.findViewById(R.id.textView_TaskPrice);
            this.taskDuration = (TextView) itemView.findViewById(R.id.textView_TaskDuration);
        }
    }

    public TasksAdapter(Context context) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @NotNull
    @Override
    public TasksAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View homeRecyclerItemView = mLayoutInflater.inflate(R.layout.home_recyclerview_items, parent, false);
        return new TasksAdapter.ViewHolder(homeRecyclerItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TasksAdapter.ViewHolder holder, int position) {
        holder.taskName.setText(String.valueOf(EventRepo.currentDay[position][1]));
        //TODO: write taskPrice and taskDuration

    }

    @Override
    public int getItemCount() {
        return EventRepo.currentDay.length;
    }
}
