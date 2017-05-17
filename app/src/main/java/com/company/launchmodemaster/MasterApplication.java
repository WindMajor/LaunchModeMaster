package com.company.launchmodemaster;

import android.app.Application;

import com.company.launchmodemaster.data.ActivityStartManager;
import com.company.launchmodemaster.data.LaunchFlagManager;

/**
 * Created by wangmeng on 17/4/26.
 */

public class MasterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LaunchFlagManager.init();
        ActivityStartManager.init();
    }
}
