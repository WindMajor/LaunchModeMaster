package com.company.launchmodemaster;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.company.launchmodemaster.BaseActivity;
import com.company.launchmodemaster.R;

/**
 * Created by wangmeng on 17/4/13.
 */

public class Standard_A4_Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setToolbarTitle() {
        toolbar.setTitle(R.string.standard_a4_activity_title);
    }
}
