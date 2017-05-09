package com.company.launchmodemaster.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.company.launchmodemaster.Constants;
import com.company.launchmodemaster.activitys.SingleInstance_D1_Activity;
import com.company.launchmodemaster.activitys.SingleInstance_D2_Activity;
import com.company.launchmodemaster.activitys.SingleInstance_D3_Activity;
import com.company.launchmodemaster.activitys.SingleInstance_D4_Activity;
import com.company.launchmodemaster.activitys.SingleInstance_D5_Activity;
import com.company.launchmodemaster.activitys.SingleTask_C1_Activity;
import com.company.launchmodemaster.activitys.SingleTask_C2_Activity;
import com.company.launchmodemaster.activitys.SingleTask_C3_Activity;
import com.company.launchmodemaster.activitys.SingleTask_C4_Activity;
import com.company.launchmodemaster.activitys.SingleTask_C5_Activity;
import com.company.launchmodemaster.activitys.SingleTop_B1_Activity;
import com.company.launchmodemaster.activitys.SingleTop_B2_Activity;
import com.company.launchmodemaster.activitys.SingleTop_B3_Activity;
import com.company.launchmodemaster.activitys.SingleTop_B4_Activity;
import com.company.launchmodemaster.activitys.SingleTop_B5_Activity;
import com.company.launchmodemaster.activitys.Standard_A1_Activity;
import com.company.launchmodemaster.activitys.Standard_A2_Activity;
import com.company.launchmodemaster.activitys.Standard_A3_Activity;
import com.company.launchmodemaster.activitys.Standard_A4_Activity;
import com.company.launchmodemaster.activitys.Standard_A5_Activity;
import com.company.launchmodemaster.Utils;
import com.company.launchmodemaster.domain.ActivityContent;

import java.util.ArrayList;
import java.util.List;


public class ActivityStartManager {

    private static ActivityStartManager instance;

    private String currentActivityName;
    private String currentActivityDesc;

    private List<ActivityContent> displayActivityList = new ArrayList<>();

    public static void init() {
        instance = new ActivityStartManager();
    }

    public static ActivityStartManager getInstance() {
        return instance;
    }

    private ActivityStartManager() {
        currentActivityName = Constants.STANDARD_A1;

        displayActivityList.add(new ActivityContent(Constants.STANDARD_A1, "Normal"));
        displayActivityList.add(new ActivityContent(Constants.STANDARD_A2, "Normal"));
        displayActivityList.add(new ActivityContent(Constants.STANDARD_A3, "taskAffinity = :new_one"));
        displayActivityList.add(new ActivityContent(Constants.STANDARD_A4, "taskAffinity = com.company.new_two"));
        displayActivityList.add(new ActivityContent(Constants.STANDARD_A5, "process = :work"));

        displayActivityList.add(new ActivityContent(Constants.SINGLE_TOP_B1, "Normal"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TOP_B2, "Normal"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TOP_B3, "taskAffinity = :new_one"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TOP_B4, "taskAffinity = com.company.new_two"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TOP_B5, "process = :work"));

        displayActivityList.add(new ActivityContent(Constants.SINGLE_TASK_C1, "Normal"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TASK_C2, "Normal"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TASK_C3, "taskAffinity = :new_one"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TASK_C4, "taskAffinity = com.company.new_two"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TASK_C5, "process = :work"));

        displayActivityList.add(new ActivityContent(Constants.SINGLE_INSTANCE_D1, "Normal"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_INSTANCE_D2, "Normal"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_INSTANCE_D3, "taskAffinity = :new_one"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_INSTANCE_D4, "taskAffinity = com.company.new_two"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_INSTANCE_D5, "process = :work"));

        displayActivityList.add(new ActivityContent(Constants.ASSIS_STANDARD_A1, "Other App Normal"));
        displayActivityList.add(new ActivityContent(Constants.ASSIS_SINGLE_TOP_B1, "Other App Normal"));
        displayActivityList.add(new ActivityContent(Constants.ASSIS_SINGLE_TASK_C1, "Other App Normal"));
        displayActivityList.add(new ActivityContent(Constants.ASSIS_SINGLE_INSTANCE_D1, "Other App Normal"));
    }

    public ArrayList<ActivityContent> getAllActivityContent() {
        return new ArrayList<>(displayActivityList);
    }

    public void setCurrentActivityName(String currentActivityName) {
        this.currentActivityName = currentActivityName;
    }

    public String getCurrentActivityName() {
        return currentActivityName;
    }

    public String getCurrentActivityDesc() {
        return currentActivityDesc;
    }

    public void startActivityForResult(Activity activity) {
        startActivity(activity, true);
    }

    public void startActivity(Activity activity) {
        startActivity(activity, false);
    }

    private void startActivity(Activity activity, boolean isForResult) {
        if (TextUtils.isEmpty(currentActivityName)) {
            return;
        }

        switch (currentActivityName) {
            case Constants.STANDARD_A1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, Standard_A1_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, Standard_A1_Activity.class)));
                }
                break;

            case Constants.STANDARD_A2:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, Standard_A2_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, Standard_A2_Activity.class)));
                }
                break;

            case Constants.STANDARD_A3:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, Standard_A3_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, Standard_A3_Activity.class)));
                }
                break;

            case Constants.STANDARD_A4:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, Standard_A4_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, Standard_A4_Activity.class)));
                }
                break;

            case Constants.STANDARD_A5:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, Standard_A5_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, Standard_A5_Activity.class)));
                }
                break;

            case Constants.SINGLE_TOP_B1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTop_B1_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTop_B1_Activity.class)));
                }
                break;

            case Constants.SINGLE_TOP_B2:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTop_B2_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTop_B2_Activity.class)));
                }
                break;

            case Constants.SINGLE_TOP_B3:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTop_B3_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTop_B3_Activity.class)));
                }
                break;

            case Constants.SINGLE_TOP_B4:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTop_B4_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTop_B4_Activity.class)));
                }
                break;

            case Constants.SINGLE_TOP_B5:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTop_B5_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTop_B5_Activity.class)));
                }
                break;

            case Constants.SINGLE_TASK_C1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTask_C1_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTask_C1_Activity.class)));
                }
                break;

            case Constants.SINGLE_TASK_C2:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTask_C2_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTask_C2_Activity.class)));
                }
                break;

            case Constants.SINGLE_TASK_C3:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTask_C3_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTask_C3_Activity.class)));
                }
                break;

            case Constants.SINGLE_TASK_C4:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTask_C4_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTask_C4_Activity.class)));
                }
                break;

            case Constants.SINGLE_TASK_C5:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTask_C5_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleTask_C5_Activity.class)));
                }
                break;

            case Constants.SINGLE_INSTANCE_D1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleInstance_D1_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleInstance_D1_Activity.class)));
                }
                break;

            case Constants.SINGLE_INSTANCE_D2:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleInstance_D2_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleInstance_D2_Activity.class)));
                }
                break;

            case Constants.SINGLE_INSTANCE_D3:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleInstance_D3_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleInstance_D3_Activity.class)));
                }
                break;

            case Constants.SINGLE_INSTANCE_D4:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleInstance_D4_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleInstance_D4_Activity.class)));
                }
                break;

            case Constants.SINGLE_INSTANCE_D5:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleInstance_D5_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent(activity, SingleInstance_D5_Activity.class)));
                }
                break;

            case Constants.ASSIS_STANDARD_A1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.STANDARD_A1").addCategory(Intent.CATEGORY_DEFAULT)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.STANDARD_A1").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case Constants.ASSIS_SINGLE_TOP_B1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.SINGLE_TOP_B1").addCategory(Intent.CATEGORY_DEFAULT)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.SINGLE_TOP_B1").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case Constants.ASSIS_SINGLE_TASK_C1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.SINGLE_TASK_C1").addCategory(Intent.CATEGORY_DEFAULT)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.SINGLE_TASK_C1").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            case Constants.ASSIS_SINGLE_INSTANCE_D1:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.SINGLE_INSTANCE_D1").addCategory(Intent.CATEGORY_DEFAULT)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.SINGLE_INSTANCE_D1").addCategory(Intent.CATEGORY_DEFAULT)));
                }
                break;

            default:
                break;
        }
    }
}
