package com.company.launchmodemaster.domain;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.company.launchmodemaster.R;

import java.util.ArrayList;
import java.util.List;


public class SelectActivityAdapter extends BaseAdapter {

    private class ViewHolder {
        TextView activityName;
        TextView activityDesc;
        AppCompatCheckBox checkBox;
        CardView cardView;
    }


    private List<ActivityContent> displayActivityList = new ArrayList<>();
    private List<String> selectedActivityList = new ArrayList<>();

    private Context context;

    public SelectActivityAdapter(Context context) {
        this.context = context;
    }

    public void setDisplayActivityList(List<ActivityContent> displayActivityList){
        this.displayActivityList.addAll(displayActivityList);
    }

    public void setSelectedActivity(String activityName) {
        selectedActivityList.clear();

        selectedActivityList.add(activityName);
    }

    public String getSelectedActivity() {
        if (selectedActivityList.size() == 0) {
            return "";
        }
        return selectedActivityList.get(0);
    }

    @Override
    public int getCount() {
        return displayActivityList.size();
    }

    @Override
    public Object getItem(int position) {
        return displayActivityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_activity_choice_layout, null);
            viewHolder.activityName = (TextView) convertView.findViewById(R.id.item_choice_activity_text);
            viewHolder.activityDesc = (TextView) convertView.findViewById(R.id.item_choice_activity_desc);
            viewHolder.checkBox = (AppCompatCheckBox) convertView.findViewById(R.id.item_choice_activity_check_box);
            viewHolder.cardView = (CardView) convertView.findViewById(R.id.choice_activity_card);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final String activityName = displayActivityList.get(position).activityName;
        viewHolder.activityName.setText(activityName);
        viewHolder.activityDesc.setText(displayActivityList.get(position).activityDesc);
        viewHolder.checkBox.setChecked(selectedActivityList.contains(activityName));

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedActivityList.contains(activityName)) {
                    return;
                }

                selectedActivityList.clear();
                selectedActivityList.add(activityName);

                notifyDataSetChanged();
            }
        });
        return convertView;
    }
}
