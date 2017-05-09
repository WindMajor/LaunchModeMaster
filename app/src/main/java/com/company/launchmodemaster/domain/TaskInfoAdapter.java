package com.company.launchmodemaster.domain;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.company.launchmodemaster.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangmeng on 17/4/8.
 */

public class TaskInfoAdapter extends BaseAdapter {

    private class ViewHolder {
        TextView taskId;
        TextView count;
        TextView bottomActivity;
        TextView topActivity;
    }

    private List<TaskInfo> taskInfos = new ArrayList<>();

    private Context context;

    public void setTaskInfos(List<TaskInfo> taskInfos) {
        this.taskInfos.clear();
        this.taskInfos.addAll(taskInfos);
    }

    public TaskInfoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return taskInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return taskInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_task_info_layout, null);
            viewHolder.taskId = (TextView) convertView.findViewById(R.id.item_task_info_task_id);
            viewHolder.count = (TextView) convertView.findViewById(R.id.item_task_info_activity_count);
            viewHolder.bottomActivity = (TextView) convertView.findViewById(R.id.item_task_info_bottom_activity);
            viewHolder.topActivity = (TextView) convertView.findViewById(R.id.item_task_info_top_activity);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        TaskInfo taskInfo = taskInfos.get(position);

        viewHolder.taskId.setText(context.getResources().getString(R.string.task_id, String.valueOf(taskInfo.taskId)));
        viewHolder.count.setText(context.getResources().getString(R.string.activity_count, String.valueOf(taskInfo.activityCount)));
        viewHolder.bottomActivity.setText(context.getResources().getString(R.string.bottom_activity, taskInfo.bottomActivity));
        viewHolder.topActivity.setText(context.getResources().getString(R.string.top_activity, taskInfo.topActivity));

        return convertView;
    }
}
