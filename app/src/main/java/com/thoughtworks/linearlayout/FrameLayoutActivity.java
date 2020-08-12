package com.thoughtworks.linearlayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FrameLayoutActivity extends AppCompatActivity {
    private static final int FRAME_BTN_ID_BASE = 2000;
    private static final int FRAME_JUMP_TO_MAIN_BTN_ID_OFFSET = 1;

    private View.OnClickListener jumpToMainActivity = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(FrameLayoutActivity.this, MainActivity.class);
            startActivity(intent);
        }
    };

    private void createButtons() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frame_linear_layout_child);
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60,
                getResources().getDisplayMetrics());
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 320,
                getResources().getDisplayMetrics());
        LinearLayout.LayoutParams btnParam = new LinearLayout.LayoutParams(width, height);
        btnParam.topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40,
                getResources().getDisplayMetrics());
        btnParam.gravity = Gravity.CENTER_HORIZONTAL;

        Button[] buttons = new Button[10];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button(this);
            buttons[i].setId(FRAME_BTN_ID_BASE + (FRAME_JUMP_TO_MAIN_BTN_ID_OFFSET * (i + 1)));
            buttons[i].setLayoutParams(btnParam);
            buttons[i].setText(getString(R.string.frame_btn_name, i + 1));
            linearLayout.addView(buttons[i]);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout_activity);

        createButtons();

        Button mainActivity = (Button) findViewById(FRAME_BTN_ID_BASE + FRAME_JUMP_TO_MAIN_BTN_ID_OFFSET);
        mainActivity.setOnClickListener(jumpToMainActivity);
    }
}
