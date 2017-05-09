package com.company.launchmodemaster.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangmeng on 17/2/17.
 */

public class LaunchFlagManager {

    private static LaunchFlagManager instance;

    public static void init() {
        instance = new LaunchFlagManager();
    }

    public static LaunchFlagManager getInstance() {
        return instance;
    }

    private List<String> checkedFlagList = new ArrayList<>();

    private LaunchFlagManager() {
    }

    public List<String> getCheckedFlagList() {
        return new ArrayList<>(checkedFlagList);
    }

    public void setCheckedFlagList(List<String> checkedFlagList) {
        Log.i("WMLog", "setCheckedFlagList() checkedFlagList = " + checkedFlagList);
        this.checkedFlagList.clear();
        this.checkedFlagList.addAll(checkedFlagList);
    }
}
