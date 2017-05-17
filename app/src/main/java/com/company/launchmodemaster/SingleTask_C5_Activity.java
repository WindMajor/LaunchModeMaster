package com.company.launchmodemaster;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by wangmeng on 17/4/13.
 */

public class SingleTask_C5_Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setToolbarTitle() {
        toolbar.setTitle(R.string.single_task_c5_activity_title);
    }
}
