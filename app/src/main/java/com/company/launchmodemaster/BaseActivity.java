package com.company.launchmodemaster;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.company.launchmodemaster.data.ActivityStartManager;
import com.company.launchmodemaster.data.LaunchFlagManager;
import com.company.launchmodemaster.domain.SelectActivityAdapter;
import com.company.launchmodemaster.domain.SelectFlagAdapter;
import com.company.launchmodemaster.domain.TaskInfoRecyclerAdapter;

import java.util.Collections;
import java.util.Comparator;

public class BaseActivity extends AppCompatActivity {

    protected SelectFlagAdapter selectFlagAdapter;
    protected SelectActivityAdapter selectActivityAdapter;

    protected AlertDialog selectFlagDialog;
    protected AlertDialog selectActivityDialog;

    protected TaskInfoRecyclerAdapter recyclerAdapter;
    protected Toolbar toolbar;
    protected TextView createTypeText;
    protected TextView selectFlagText;
    protected TextView selectActivityText;
    protected TextView selectActivityDescText;

    private int refreshCount;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (refreshCount < 3) {
                recyclerAdapter.setTaskInfos(Utils.getTaskInfos(BaseActivity.this));
                recyclerAdapter.notifyDataSetChanged();

                refreshCount++;
                handler.sendMessageDelayed(Message.obtain(), 300);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setToolbarTitle();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.info_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerAdapter = new TaskInfoRecyclerAdapter(this);
        recyclerView.setAdapter(recyclerAdapter);

        Button selectActivityButton = (Button) findViewById(R.id.select_activity_button);
        selectActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectActivityAdapter.setSelectedActivity(ActivityStartManager.getInstance().getCurrentActivityName());
                selectActivityAdapter.notifyDataSetChanged();
                selectActivityDialog.show();

            }
        });
        Button startActivityButton = (Button) findViewById(R.id.start_activity_button);
        startActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityStartManager.getInstance().startActivity(BaseActivity.this);
            }
        });
        startActivityButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ActivityStartManager.getInstance().startActivityForResult(BaseActivity.this);
                return true;
            }
        });

        selectFlagText = (TextView) findViewById(R.id.launch_flag_text);
        refreshFlagChoiceText();

        initLaunchFlagChoiceDialog();

        selectActivityText = (TextView) findViewById(R.id.choice_activity_result_text);
        selectActivityDescText = (TextView) findViewById(R.id.choice_activity_result_desc_text);
        refreshActivitySelectedText();

        initActivityChoiceDialog();

        Button choiceFlagButton = (Button) findViewById(R.id.launch_flag_choice_button);
        choiceFlagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFlagAdapter.setCheckedFlagList(LaunchFlagManager.getInstance().getCheckedFlagList());
                selectFlagAdapter.notifyDataSetChanged();
                selectFlagDialog.show();
            }
        });

        createTypeText = (TextView) findViewById(R.id.create_type_text);
        assert createTypeText != null;
        createTypeText.setText(R.string.create_type_from_on_create);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        createTypeText.setText(R.string.create_type_from_on_new_intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        recyclerAdapter.setTaskInfos(Utils.getTaskInfos(this));
        recyclerAdapter.notifyDataSetChanged();

        refreshCount = 0;
        handler.sendMessageDelayed(Message.obtain(), 300);

        refreshFlagChoiceText();
        refreshActivitySelectedText();
    }

    private void initActivityChoiceDialog() {

        selectActivityAdapter = new SelectActivityAdapter(this);
        selectActivityAdapter.setDisplayActivityList(ActivityStartManager.getInstance().getAllActivityContent());

        View dialogView = View.inflate(this, R.layout.layout_activity_choice_dialog, null);
        ListView listView = (ListView) dialogView.findViewById(R.id.activity_choice_list_view);
        listView.setAdapter(selectActivityAdapter);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);

        builder.setPositiveButton(R.string.string_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String selectedActivityName = selectActivityAdapter.getSelectedActivity();

                if (TextUtils.isEmpty(selectedActivityName)) {
                    return;
                }

                ActivityStartManager.getInstance().setCurrentActivityName(selectedActivityName);

                refreshActivitySelectedText();
            }
        });

        builder.setNegativeButton(R.string.string_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        selectActivityDialog = builder.create();

    }

    private void initLaunchFlagChoiceDialog() {

        selectFlagAdapter = new SelectFlagAdapter(this);

        View dialogView = View.inflate(this, R.layout.layout_launch_flag_dialog, null);
        ListView listView = (ListView) dialogView.findViewById(R.id.dialog_list_view);
        listView.setAdapter(selectFlagAdapter);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);

        builder.setPositiveButton(R.string.string_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Collections.sort(selectFlagAdapter.getCheckedFlagList(), new Comparator<String>() {
                    @Override
                    public int compare(String lhs, String rhs) {
                        return lhs.compareToIgnoreCase(rhs);
                    }
                });

                LaunchFlagManager.getInstance().setCheckedFlagList(selectFlagAdapter.getCheckedFlagList());

                refreshFlagChoiceText();
            }
        });

        builder.setNegativeButton(R.string.string_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        selectFlagDialog = builder.create();
    }

    private void refreshFlagChoiceText() {
        String flagResult = "";
        for (String flag : LaunchFlagManager.getInstance().getCheckedFlagList()) {
            flagResult += flag + "\n";
        }
        selectFlagText.setText(flagResult);
    }

    private void refreshActivitySelectedText() {
        selectActivityText.setText(ActivityStartManager.getInstance().getCurrentActivityName());
    }

    protected void setToolbarTitle() {
    }
}