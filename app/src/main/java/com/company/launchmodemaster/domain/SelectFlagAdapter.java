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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wangmeng on 17/4/8.
 */

public class SelectFlagAdapter extends BaseAdapter {

    private class ViewHolder {
        TextView flagName;
        AppCompatCheckBox checkBox;
        CardView cardView;
    }

    private Context context;

    private List<String> flagList = new ArrayList<>();
    private List<String> checkedFlagList = new ArrayList<>();

    public SelectFlagAdapter(Context context) {
        this.context = context;
        flagList.addAll(Arrays.asList(context.getResources().getStringArray(R.array.launch_flag_content)));
        Collections.sort(flagList, new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareToIgnoreCase(rhs);
            }
        });
    }

    public List<String> getCheckedFlagList() {
        return checkedFlagList;
    }

    public void setCheckedFlagList(List<String> checkedFlagList) {
        this.checkedFlagList.clear();
        this.checkedFlagList.addAll(checkedFlagList);
    }

    @Override
    public int getCount() {
        return flagList.size();
    }

    @Override
    public Object getItem(int position) {
        return flagList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_launch_flag_layout, null);
            viewHolder.flagName = (TextView) convertView.findViewById(R.id.item_launch_flag_text);
            viewHolder.checkBox = (AppCompatCheckBox) convertView.findViewById(R.id.item_launch_flag_check);
            viewHolder.cardView = (CardView) convertView.findViewById(R.id.launch_flag_card);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final String flagName = flagList.get(position);

        viewHolder.flagName.setText(flagName);
        viewHolder.checkBox.setChecked(checkedFlagList.contains(flagName));

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkedFlagList.contains(flagName)) {
                    checkedFlagList.remove(flagName);
                    viewHolder.checkBox.setChecked(false);

                } else {
                    checkedFlagList.add(flagName);
                    viewHolder.checkBox.setChecked(true);
                }
            }
        });

        return convertView;
    }
}
