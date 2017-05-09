package com.company.launchmodemaster;

import android.os.Bundle;

import com.company.launchmodemaster.data.ActivityStartManager;
import com.company.launchmodemaster.data.LaunchFlagManager;
import com.company.launchmodemaster.data.TaskManager;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TaskManager.getInstance().addActivity(getTaskId(), this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setToolbarTitle() {
        toolbar.setTitle(R.string.main_activity_title);
    }
}