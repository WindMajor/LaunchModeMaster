package com.company.launchmodemaster;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.company.launchmodemaster.BaseActivity;
import com.company.launchmodemaster.R;

/**
 * Created by wangmeng on 17/4/13.
 */

public class SingleTop_B3_Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setToolbarTitle() {
        toolbar.setTitle(R.string.single_top_b3_activity_title);
    }
}
