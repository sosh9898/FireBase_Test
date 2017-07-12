package com.boost.jyoung.firebase_test.Realtime_Database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.boost.jyoung.firebase_test.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class TokenActivity extends AppCompatActivity {

    FirebaseInstanceIdService firebaseInstanceIdService;
    FirebaseDatabase database;
    DatabaseReference myRef;

    EditText emiledit;
    EditText nameedit;
    Button postbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token);

        emiledit = (EditText) findViewById(R.id.email_edit);
        nameedit = (EditText) findViewById(R.id.name_edit);
        postbtn = (Button) findViewById(R.id.bt_update);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("users");

        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emiledit.getText().toString();
                String name = nameedit.getText().toString();
                myRef.push().setValue(new UserToken(email,name));
            }
        });


    }
}

