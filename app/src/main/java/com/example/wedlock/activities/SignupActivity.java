package com.example.wedlock.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wedlock.R;
import com.example.wedlock.activities.SigninActivity;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    Button signUpText;
    EditText inputEmail, inputUsername, inputPassword, reenterPassword;

    //authentication
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        findViewById(R.id.signInDirect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SigninActivity.class));
            }
        });

        auth = FirebaseAuth.getInstance();

        signUpText = findViewById(R.id.signUpText);
        inputEmail = findViewById(R.id.inputEmail);
        inputUsername = findViewById(R.id.inputUsername);
        inputPassword = findViewById(R.id.inputPassword);
        reenterPassword = findViewById(R.id.reenterPassword);

        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
    }

    private void createUser() {
        String userName = inputUsername.getText().toString();
        String userEmail = inputEmail.getText().toString();
        String userPass = inputPassword.getText().toString();
        String userCPass = reenterPassword.getText().toString();

        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(userEmail)) {
            Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(userPass)) {
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(userCPass)) {
            Toast.makeText(this, "Re Enter your password to confirm", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!userPass.equals(userCPass)) {
            Toast.makeText(this, "Password not matched!", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}