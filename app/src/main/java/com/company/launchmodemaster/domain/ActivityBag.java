package com.company.launchmodemaster.domain;

import android.app.Activity;

/**
 * Created by wangmeng on 17/4/9.
 */

public class ActivityBag {
    public Activity activity;
    public int orderNum;

    public ActivityBag(int orderNum, Activity activity) {
        this.activity = activity;
        this.orderNum = orderNum;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ActivityBag)) {
            return false;
        }
        return ((ActivityBag) o).activity.equals(activity) && ((ActivityBag) o).orderNum == orderNum;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + activity.hashCode();
        result = result * 31 + orderNum;
        return result;
    }
}
