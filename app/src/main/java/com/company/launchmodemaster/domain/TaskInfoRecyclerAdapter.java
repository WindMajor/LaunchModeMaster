package com.company.launchmodemaster.domain;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.company.launchmodemaster.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wangmeng on 17/4/9.
 */

public class TaskInfoRecyclerAdapter extends RecyclerView.Adapter {

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView taskId;
        TextView count;
        TextView bottomActivity;
        TextView topActivity;

        public ViewHolder(View itemView) {
            super(itemView);
            taskId = (TextView) itemView.findViewById(R.id.item_task_info_recycler_task_id);
            count = (TextView) itemView.findViewById(R.id.item_task_info_recycler_activity_count);
            bottomActivity = (TextView) itemView.findViewById(R.id.item_task_info_recycler_bottom_activity);
            topActivity = (TextView) itemView.findViewById(R.id.item_task_info_recycler_top_activity);
        }
    }


    private Context context;

    private List<TaskInfo> taskInfos = new ArrayList<>();

    public TaskInfoRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void setTaskInfos(List<TaskInfo> taskInfos) {
        this.taskInfos.clear();
        this.taskInfos.addAll(taskInfos);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.item_task_info_recycler_layout, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolder) {
            final ViewHolder viewHolder = (ViewHolder) holder;

            TaskInfo taskInfo = taskInfos.get(position);

            viewHolder.taskId.setText(context.getResources().getString(R.string.task_id, String.valueOf(taskInfo.taskId)));
            viewHolder.count.setText(context.getResources().getString(R.string.activity_count, String.valueOf(taskInfo.activityCount)));
            viewHolder.bottomActivity.setText(context.getResources().getString(R.string.bottom_activity, taskInfo.bottomActivity));
            viewHolder.topActivity.setText(context.getResources().getString(R.string.top_activity, taskInfo.topActivity));
        }
    }

    @Override
    public int getItemCount() {
        return taskInfos.size();
    }
}
