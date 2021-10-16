package com.example.wedlock.activities;

import androidx.annotation.NonNull;
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
import com.example.wedlock.models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    Button signUpText;
    EditText inputEmail, inputUsername, inputPassword, reenterPassword;

    //authentication
    FirebaseAuth auth;

    FirebaseDatabase database;

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
        database = FirebaseDatabase.getInstance();

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

        else {
            auth.createUserWithEmailAndPassword(userEmail, userPass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                UserModel userModel = new UserModel(userName, userEmail, userPass);
                                String id = task.getResult().getUser().getUid();
                                database.getReference().child("Users").child(id).setValue(userModel);

                                Toast.makeText(SignupActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(SignupActivity.this, "Error " + task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}