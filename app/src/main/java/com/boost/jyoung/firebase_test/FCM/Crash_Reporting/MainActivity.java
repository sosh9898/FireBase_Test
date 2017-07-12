package com.boost.jyoung.firebase_test.FCM.Crash_Reporting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.boost.jyoung.firebase_test.Authentication.AuthenticationActivity;
import com.boost.jyoung.firebase_test.R;
import com.boost.jyoung.firebase_test.Realtime_Database.TokenActivity;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button task1 ,task2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseMessaging.getInstance().subscribeToTopic("notice");
        FirebaseCrash.report(new Exception("test error"));
        initview();
    }

    public void initview(){
        task1 = (Button)findViewById(R.id.firebasetask1_btn);
        task2 = (Button)findViewById(R.id.firebasetask2_btn);
        task1.setOnClickListener(this);
        task2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.firebasetask1_btn:
                Intent intent1 = new Intent(getApplicationContext(),TokenActivity.class);
                startActivity(intent1);
                break;
            case R.id.firebasetask2_btn:
                Intent intent2 = new Intent(getApplicationContext(),AuthenticationActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
