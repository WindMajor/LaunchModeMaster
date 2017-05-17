package com.company.launchmodemaster;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.company.launchmodemaster.BaseActivity;
import com.company.launchmodemaster.R;

/**
 * Created by wangmeng on 17/4/13.
 */

public class SingleInstance_D2_Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setToolbarTitle() {
        toolbar.setTitle(R.string.single_instance_d2_activity_title);
    }
}
