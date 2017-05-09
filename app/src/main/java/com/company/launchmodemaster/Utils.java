package com.company.launchmodemaster;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.company.launchmodemaster.domain.TaskInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangmeng on 17/4/8.
 */

public class Utils {

    public static List<TaskInfo> getTaskInfos(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        List<TaskInfo> taskInfos = new ArrayList<>();
        for (ActivityManager.RunningTaskInfo info : am.getRunningTasks(100)) {
            TaskInfo taskInfo = new TaskInfo();
            taskInfo.taskId = info.id;
            taskInfo.activityCount = info.numActivities;
            taskInfo.bottomActivity = info.baseActivity.getShortClassName();
            taskInfo.topActivity = info.topActivity.getShortClassName();
            taskInfos.add(taskInfo);
        }
        return taskInfos;
    }

    public static Intent addFlagToIntent(List<String> checkedFlagList, Intent intent) {
        for (String flag : checkedFlagList) {
            switch (flag) {
                case "FLAG_ACTIVITY_BROUGHT_TO_FRONT":
                    intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                    break;

                case "FLAG_ACTIVITY_CLEAR_TASK":
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    break;

                case "FLAG_ACTIVITY_CLEAR_TOP":
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    break;

                case "FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET":
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                    break;

                case "FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS":
                    intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                    break;

                case "FLAG_ACTIVITY_FORWARD_RESULT":
                    intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                    break;

                case "FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY":
                    intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
                    break;

                case "FLAG_ACTIVITY_MULTIPLE_TASK":
                    intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    break;

                case "FLAG_ACTIVITY_NEW_DOCUMENT":
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
                    break;

                case "FLAG_ACTIVITY_NEW_TASK":
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    break;

                case "FLAG_ACTIVITY_NO_ANIMATION":
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    break;

                case "FLAG_ACTIVITY_NO_HISTORY":
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    break;

                case "FLAG_ACTIVITY_NO_USER_ACTION":
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                    break;

                case "FLAG_ACTIVITY_PREVIOUS_IS_TOP":
                    intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                    break;

                case "FLAG_ACTIVITY_REORDER_TO_FRONT":
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    break;

                case "FLAG_ACTIVITY_RESET_TASK_IF_NEEDED":
                    intent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                    break;

                case "FLAG_ACTIVITY_RETAIN_IN_RECENTS":
                    intent.addFlags(Intent.FLAG_ACTIVITY_RETAIN_IN_RECENTS);
                    break;
                case "FLAG_ACTIVITY_SINGLE_TOP":
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    break;

                case "FLAG_ACTIVITY_TASK_ON_HOME":
                    intent.addFlags(Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                    break;
                default:
                    break;
            }
        }
        return intent;
    }
}
