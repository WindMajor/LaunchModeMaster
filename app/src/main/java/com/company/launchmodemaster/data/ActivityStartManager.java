package com.company.launchmodemaster.data;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.company.launchmodemaster.Constants;
import com.company.launchmodemaster.MasterApplication;
import com.company.launchmodemaster.R;
import com.company.launchmodemaster.SingleInstance_D1_Activity;
import com.company.launchmodemaster.SingleInstance_D2_Activity;
import com.company.launchmodemaster.SingleInstance_D3_Activity;
import com.company.launchmodemaster.SingleInstance_D4_Activity;
import com.company.launchmodemaster.SingleInstance_D5_Activity;
import com.company.launchmodemaster.SingleInstance_D6_Activity;
import com.company.launchmodemaster.SingleInstance_D7_Activity;
import com.company.launchmodemaster.SingleInstance_D8_Activity;
import com.company.launchmodemaster.SingleInstance_D9_Activity;
import com.company.launchmodemaster.SingleTask_C1_Activity;
import com.company.launchmodemaster.SingleTask_C2_Activity;
import com.company.launchmodemaster.SingleTask_C3_Activity;
import com.company.launchmodemaster.SingleTask_C4_Activity;
import com.company.launchmodemaster.SingleTask_C5_Activity;
import com.company.launchmodemaster.SingleTask_C6_Activity;
import com.company.launchmodemaster.SingleTask_C7_Activity;
import com.company.launchmodemaster.SingleTask_C8_Activity;
import com.company.launchmodemaster.SingleTask_C9_Activity;
import com.company.launchmodemaster.SingleTop_B1_Activity;
import com.company.launchmodemaster.SingleTop_B2_Activity;
import com.company.launchmodemaster.SingleTop_B3_Activity;
import com.company.launchmodemaster.SingleTop_B4_Activity;
import com.company.launchmodemaster.SingleTop_B5_Activity;
import com.company.launchmodemaster.SingleTop_B6_Activity;
import com.company.launchmodemaster.SingleTop_B7_Activity;
import com.company.launchmodemaster.SingleTop_B8_Activity;
import com.company.launchmodemaster.SingleTop_B9_Activity;
import com.company.launchmodemaster.Standard_A1_Activity;
import com.company.launchmodemaster.Standard_A2_Activity;
import com.company.launchmodemaster.Standard_A3_Activity;
import com.company.launchmodemaster.Standard_A4_Activity;
import com.company.launchmodemaster.Standard_A5_Activity;
import com.company.launchmodemaster.Standard_A6_Activity;
import com.company.launchmodemaster.Standard_A7_Activity;
import com.company.launchmodemaster.Standard_A8_Activity;
import com.company.launchmodemaster.Standard_A9_Activity;
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
        displayActivityList.add(new ActivityContent(Constants.STANDARD_A2, "taskAffinity = ${applicationId}"));
        displayActivityList.add(new ActivityContent(Constants.STANDARD_A3, "taskAffinity = :carry"));
        displayActivityList.add(new ActivityContent(Constants.STANDARD_A4, "taskAffinity = com.hero.support"));
        displayActivityList.add(new ActivityContent(Constants.STANDARD_A5, "process = :work"));
        displayActivityList.add(new ActivityContent(Constants.STANDARD_A6, "allowTaskReparenting = true"));
        displayActivityList.add(new ActivityContent(Constants.STANDARD_A7, "alwaysRetainTaskState = true"));
        displayActivityList.add(new ActivityContent(Constants.STANDARD_A8, "clearTaskOnLaunch = true"));
        displayActivityList.add(new ActivityContent(Constants.STANDARD_A9, "finishOnTaskLaunch = true"));

        displayActivityList.add(new ActivityContent(Constants.SINGLE_TOP_B1, "Normal"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TOP_B2, "taskAffinity = ${applicationId}"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TOP_B3, "taskAffinity = :carry"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TOP_B4, "taskAffinity = com.hero.support"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TOP_B5, "process = :work"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TOP_B6, "allowTaskReparenting = true"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TOP_B7, "alwaysRetainTaskState = true"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TOP_B8, "clearTaskOnLaunch = true"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TOP_B9, "finishOnTaskLaunch = true"));

        displayActivityList.add(new ActivityContent(Constants.SINGLE_TASK_C1, "Normal"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TASK_C2, "taskAffinity = ${applicationId}"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TASK_C3, "taskAffinity = :carry"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TASK_C4, "taskAffinity = com.hero.support"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TASK_C5, "process = :work"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TASK_C6, "allowTaskReparenting = true"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TASK_C7, "alwaysRetainTaskState = true"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TASK_C8, "clearTaskOnLaunch = true"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_TASK_C9, "finishOnTaskLaunch = true"));

        displayActivityList.add(new ActivityContent(Constants.SINGLE_INSTANCE_D1, "Normal"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_INSTANCE_D2, "taskAffinity = ${applicationId}"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_INSTANCE_D3, "taskAffinity = :carry"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_INSTANCE_D4, "taskAffinity = com.hero.support"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_INSTANCE_D5, "process = :work"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_INSTANCE_D6, "allowTaskReparenting = true"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_INSTANCE_D7, "alwaysRetainTaskState = true"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_INSTANCE_D8, "clearTaskOnLaunch = true"));
        displayActivityList.add(new ActivityContent(Constants.SINGLE_INSTANCE_D9, "finishOnTaskLaunch = true"));

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

            case Constants.STANDARD_A6:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Standard_A6_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Standard_A6_Activity.class)));
                }
                break;

            case Constants.STANDARD_A7:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Standard_A7_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Standard_A7_Activity.class)));
                }
                break;

            case Constants.STANDARD_A8:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Standard_A8_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Standard_A8_Activity.class)));
                }
                break;

            case Constants.STANDARD_A9:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Standard_A9_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, Standard_A9_Activity.class)));
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

            case Constants.SINGLE_TOP_B6:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTop_B6_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTop_B6_Activity.class)));
                }
                break;

            case Constants.SINGLE_TOP_B7:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTop_B7_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTop_B7_Activity.class)));
                }
                break;

            case Constants.SINGLE_TOP_B8:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTop_B8_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTop_B8_Activity.class)));
                }
                break;

            case Constants.SINGLE_TOP_B9:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTop_B9_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTop_B9_Activity.class)));
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

            case Constants.SINGLE_TASK_C6:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTask_C6_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTask_C6_Activity.class)));
                }
                break;

            case Constants.SINGLE_TASK_C7:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTask_C7_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTask_C7_Activity.class)));
                }
                break;

            case Constants.SINGLE_TASK_C8:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTask_C8_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTask_C8_Activity.class)));
                }
                break;

            case Constants.SINGLE_TASK_C9:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTask_C9_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleTask_C9_Activity.class)));
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

            case Constants.SINGLE_INSTANCE_D6:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleInstance_D6_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleInstance_D6_Activity.class)));
                }
                break;

            case Constants.SINGLE_INSTANCE_D7:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleInstance_D7_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleInstance_D7_Activity.class)));
                }
                break;

            case Constants.SINGLE_INSTANCE_D8:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleInstance_D8_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleInstance_D8_Activity.class)));
                }
                break;

            case Constants.SINGLE_INSTANCE_D9:
                if (isForResult) {
                    activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleInstance_D9_Activity.class)), 2);
                } else {
                    activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                        new Intent(activity, SingleInstance_D9_Activity.class)));
                }
                break;


            case Constants.ASSIS_STANDARD_A1:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.STANDARD_A1").addCategory(Intent.CATEGORY_DEFAULT)), 2);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.STANDARD_A1").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterApplication.getContext(), R.string.toast_hint_install_launch_mode_assis_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case Constants.ASSIS_SINGLE_TOP_B1:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.SINGLE_TOP_B1").addCategory(Intent.CATEGORY_DEFAULT)), 2);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.SINGLE_TOP_B1").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterApplication.getContext(), R.string.toast_hint_install_launch_mode_assis_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case Constants.ASSIS_SINGLE_TASK_C1:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.SINGLE_TASK_C1").addCategory(Intent.CATEGORY_DEFAULT)), 2);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.SINGLE_TASK_C1").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterApplication.getContext(), R.string.toast_hint_install_launch_mode_assis_app, Toast.LENGTH_SHORT).show();
                }
                break;

            case Constants.ASSIS_SINGLE_INSTANCE_D1:
                try {
                    if (isForResult) {
                        activity.startActivityForResult(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.SINGLE_INSTANCE_D1").addCategory(Intent.CATEGORY_DEFAULT)), 2);
                    } else {
                        activity.startActivity(Utils.addFlagToIntent(LaunchFlagManager.getInstance().getCheckedFlagList(),
                            new Intent("launch_mode_master_assis.SINGLE_INSTANCE_D1").addCategory(Intent.CATEGORY_DEFAULT)));
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MasterApplication.getContext(), R.string.toast_hint_install_launch_mode_assis_app, Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                break;
        }
    }
}
