package com.thoughtworks.linearlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class ConstraintActivity extends Activity {
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

        Button goBack = (Button) findViewById(R.id.goBackToMainFromConstraint);
        Button login = (Button) findViewById(R.id.login);
        goBack.setOnClickListener(jumpToMainActivity);
        login.setOnClickListener(jumpToMainActivity);
    }
}
