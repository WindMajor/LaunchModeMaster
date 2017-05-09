package com.company.launchmodemaster.data;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;

import com.company.launchmodemaster.domain.ActivityBag;
import com.company.launchmodemaster.domain.TaskInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangmeng on 17/4/8.
 */

public class TaskManager {

    private static TaskManager instance;

    public static void init(Context context) {
        instance = new TaskManager(context);
    }

    public static TaskManager getInstance() {
        return instance;
    }

    private ActivityManager activityManager;

    private Context context;

    private List<TaskInfo> taskInfos = new ArrayList<>();


    private TaskManager(Context context) {
        this.context = context;
        activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    }

    public List<TaskInfo> getTaskInfos() {
        refreshTaskInfos();
        return taskInfos;
    }

    public void addActivity(int taskId, Activity activity) {
        for (TaskInfo taskInfo : taskInfos) {
            if (taskInfo.taskId == taskId) {
                taskInfo.activityBags.add(new ActivityBag(taskInfo.activityCount, activity));
                break;
            }
        }
    }

    public void removeActivity(int taskId, Activity activity) {
        ActivityBag toRemoveObject = null;
        for (TaskInfo taskInfo : taskInfos) {
            if (taskInfo.taskId == taskId) {
                for (ActivityBag activityBag : taskInfo.activityBags) {
                    if (activityBag.activity.equals(activity)) {
                        toRemoveObject = activityBag;
                        break;
                    }
                }
                if (toRemoveObject != null) {
                    int roRemoveOrderNum = toRemoveObject.orderNum;
                    taskInfo.activityBags.remove(toRemoveObject);
                }
            }
        }
    }

    private void refreshTaskInfos() {
        taskInfos.clear();
        for (ActivityManager.RunningTaskInfo info : activityManager.getRunningTasks(100)) {
            TaskInfo taskInfo = new TaskInfo();
            taskInfo.taskId = info.id;
            taskInfo.activityCount = info.numActivities;
            taskInfo.bottomActivity = info.baseActivity.getShortClassName();
            taskInfo.topActivity = info.topActivity.getShortClassName();
            taskInfos.add(taskInfo);
        }
    }
}
