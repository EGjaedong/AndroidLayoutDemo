package com.hezhiheng.linearlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ConstraintActivity extends AppCompatActivity {
    private View.OnClickListener jumpToMainActivity = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ConstraintActivity.this, MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_activity);

        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(jumpToMainActivity);
    }
}
