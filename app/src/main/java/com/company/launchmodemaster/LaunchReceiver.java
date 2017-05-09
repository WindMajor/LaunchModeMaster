package com.company.launchmodemaster;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.company.launchmodemaster.activitys.SingleInstance_D1_Activity;

/**
 * Created by wangmeng on 17/4/26.
 */

public class LaunchReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("WMLog", "LaunchReceiver onReceive()");

        if (Intent.ACTION_PACKAGE_REMOVED.equals(intent.getAction())
                && !intent.getBooleanExtra(Intent.EXTRA_REPLACING, false)) {
            context.startActivity(new Intent(context, SingleInstance_D1_Activity.class));
        }
    }
}
