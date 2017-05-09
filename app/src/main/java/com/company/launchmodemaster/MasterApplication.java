package com.company.launchmodemaster;

import android.app.Application;

import com.company.launchmodemaster.data.ActivityStartManager;
import com.company.launchmodemaster.data.LaunchFlagManager;
import com.company.launchmodemaster.data.TaskManager;

/**
 * Created by wangmeng on 17/4/26.
 */

public class MasterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        TaskManager.init(this);


        LaunchFlagManager.init();
        ActivityStartManager.init();
    }
}
