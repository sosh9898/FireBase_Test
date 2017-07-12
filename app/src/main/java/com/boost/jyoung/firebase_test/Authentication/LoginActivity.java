package com.boost.jyoung.firebase_test.Authentication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.boost.jyoung.firebase_test.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    private EditText email_text, pwd_text;
    private Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();

        email_text = (EditText) findViewById(R.id.login_email_edit);
        pwd_text = (EditText) findViewById(R.id.login_pwd_edit);
        login_btn = (Button) findViewById(R.id.login_btn);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email_text.getText().toString();
                String password = pwd_text.getText().toString();

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    if (user != null) {
                                        String getemail = user.getEmail();
                                        String uid = user.getUid();
                                        Toast.makeText(LoginActivity.this, "    로그인 성공!!   \n로그인 정보 : \n" + "email : " + getemail + "\nuid : " + uid,
                                                Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Log.w("failure", "LogInWithEmail:failed", task.getException());
                                    Toast.makeText(LoginActivity.this, "로그인 실패",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        });


    }
}
