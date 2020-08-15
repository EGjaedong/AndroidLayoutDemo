package com.hezhiheng.linearlayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private View.OnClickListener jumpToLayout = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btnFrameLayout:
                    intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
                    break;
                case R.id.btnConstraintLayout:
                    intent = new Intent(MainActivity.this, ConstraintActivity.class);
                    break;
            }
            startActivity(intent);
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button frameButton = (Button) findViewById(R.id.btnFrameLayout);
        Button constraintButton = (Button) findViewById(R.id.btnConstraintLayout);
        frameButton.setOnClickListener(jumpToLayout);
        constraintButton.setOnClickListener(jumpToLayout);
    }
}