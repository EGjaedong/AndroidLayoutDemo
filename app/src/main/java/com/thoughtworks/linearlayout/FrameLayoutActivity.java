package com.thoughtworks.linearlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class FrameLayoutActivity extends Activity {

    private View.OnClickListener jumpToMainActivity = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btnFrameToMain) {
                Intent intent = new Intent(FrameLayoutActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout_activity);

        Button mainActivity = (Button) findViewById(R.id.btnFrameToMain);
        mainActivity.setOnClickListener(jumpToMainActivity);
    }
}
