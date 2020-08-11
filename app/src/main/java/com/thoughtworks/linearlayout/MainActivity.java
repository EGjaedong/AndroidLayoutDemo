package com.thoughtworks.linearlayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button frameButton;

    private View.OnClickListener jump = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnFrameLayout:
                    Intent intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameButton = (Button) findViewById(R.id.btnFrameLayout);
        frameButton.setOnClickListener(jump);
    }
}