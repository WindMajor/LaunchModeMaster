package com.company.launchmodemaster.domain;

import android.app.Activity;

import java.util.List;
import java.util.Map;

/**
 * Created by wangmeng on 17/4/8.
 */

public class TaskInfo {

    public int taskId;
    public int activityCount;
    public String bottomActivity;
    public String topActivity;

    public List<ActivityBag> activityBags;
}
