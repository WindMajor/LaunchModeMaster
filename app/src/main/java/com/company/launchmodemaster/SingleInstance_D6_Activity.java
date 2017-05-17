package com.company.launchmodemaster;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by wangmeng on 17/5/17.
 */

public class SingleInstance_D6_Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setToolbarTitle() {
        toolbar.setTitle(R.string.single_instance_d6_activity_title);
    }
}
