package com.company.launchmodemaster.domain;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.company.launchmodemaster.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangmeng on 17/4/9.
 */

public class TaskInfoRecyclerAdapter extends RecyclerView.Adapter {

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView taskId;
        TextView count;
        ListView listView;

        public ViewHolder(View itemView) {
            super(itemView);
            taskId = (TextView) itemView.findViewById(R.id.item_task_info_recycler_task_id);
            count = (TextView) itemView.findViewById(R.id.item_task_info_recycler_activity_count);
            listView = (ListView) itemView.findViewById(R.id.item_task_info_recycler_list_view);
        }
    }

    private class ListViewAdapter extends BaseAdapter {

        private class ListViewHolder {
            TextView activityName;
        }

        private int activityCount;

        private String bottomName;
        private String topName;

        private void setActivityCount(int activityCount) {
            this.activityCount = activityCount;
        }

        private void setBottomName(String bottomName) {
            this.bottomName = bottomName;
        }

        private void setTopName(String topName) {
            this.topName = topName;
        }

        @Override
        public int getCount() {
            return activityCount;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ListViewHolder listViewHolder;
            if (convertView == null) {
                listViewHolder = new ListViewHolder();
                convertView = View.inflate(context, R.layout.item_task_info_recycler_list_view_layout, null);
                listViewHolder.activityName = (TextView) convertView.findViewById(R.id.item_task_info_recycler_list_text_view);

                convertView.setTag(listViewHolder);
            } else {
                listViewHolder = (ListViewHolder) convertView.getTag();
            }

            if (position == 0) {
                listViewHolder.activityName.setText(topName);
            } else if (position == activityCount - 1) {
                listViewHolder.activityName.setText(bottomName);
            } else {
                listViewHolder.activityName.setText("...");
            }

            return convertView;
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

            ListViewAdapter listViewAdapter = new ListViewAdapter();
            listViewAdapter.setActivityCount(taskInfo.activityCount);
            listViewAdapter.setBottomName(taskInfo.bottomActivity);
            listViewAdapter.setTopName(taskInfo.topActivity);

            viewHolder.listView.setAdapter(listViewAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return taskInfos.size();
    }
}
