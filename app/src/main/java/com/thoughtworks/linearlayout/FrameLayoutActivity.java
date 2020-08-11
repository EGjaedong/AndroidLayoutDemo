package com.thoughtworks.linearlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class FrameLayoutActivity extends Activity {
    private static final int FRAMEBTNIDBASE = 2000;
    private static final int FRAMEJUMPTOMAINBTNIDOFFSET = 1;

    private View.OnClickListener jumpToMainActivity = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == (FRAMEBTNIDBASE + FRAMEJUMPTOMAINBTNIDOFFSET)) {
                Intent intent = new Intent(FrameLayoutActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        }
    };

    private void createButtons() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frameLinearLayoutChild);
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60,
                getResources().getDisplayMetrics());
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 320,
                getResources().getDisplayMetrics());
        LinearLayout.LayoutParams btn_param = new LinearLayout.LayoutParams(width, height);
        btn_param.topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40,
                getResources().getDisplayMetrics());
        btn_param.gravity = Gravity.CENTER_HORIZONTAL;

        Button[] buttons = new Button[10];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button(this);
            buttons[i].setId(FRAMEBTNIDBASE + FRAMEJUMPTOMAINBTNIDOFFSET);
            buttons[i].setLayoutParams(btn_param);
            buttons[i].setText(getString(R.string.frame_btn_name) + (i + 1));
            linearLayout.addView(buttons[i]);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout_activity);

        createButtons();

        Button mainActivity = (Button) findViewById(FRAMEBTNIDBASE + FRAMEJUMPTOMAINBTNIDOFFSET);
        Button goBack =  (Button) findViewById(R.id.goBackToMainActivity);
        mainActivity.setOnClickListener(jumpToMainActivity);
        goBack.setOnClickListener(jumpToMainActivity);
    }
}
