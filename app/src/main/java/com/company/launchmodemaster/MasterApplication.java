package com.company.launchmodemaster;

import android.app.Application;
import android.content.Context;

import com.company.launchmodemaster.data.ActivityStartManager;
import com.company.launchmodemaster.data.LaunchFlagManager;

/**
 * Created by wangmeng on 17/4/26.
 */

public class MasterApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        LaunchFlagManager.init();
        ActivityStartManager.init();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        context = base;
    }

    public static Context getContext() {
        return context;
    }
}
