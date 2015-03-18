package com.example.ulugbek.myapplication.activities;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.ulugbek.myapplication.R;


/**
 * A login screen that offers login via email/password and via Google+ sign in.
 * <p/>
 * ************ IMPORTANT SETUP NOTES: ************
 * In order for Google+ sign in to work with your app, you must first go to:
 * https://developers.google.com/+/mobile/android/getting-started#step_1_enable_the_google_api
 * and follow the steps in "Step 1" to create an OAuth 2.0 client for your package.
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final AutoCompleteTextView emailView = (AutoCompleteTextView) findViewById(R.id.email);
        final EditText passwordEditText = (EditText) findViewById(R.id.password);


        Button signInBtn = (Button) findViewById(R.id.email_sign_in_button);
        signInBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailView.getText().toString();
                String password = passwordEditText.getText().toString();
                Log.i("email" , email);
                Log.i( "password" , password);

                showDialog();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class );
                startActivity(intent);

            }
        });

        Button signUpBtn = (Button) findViewById(R.id.sign_up_button);
        signUpBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class );
                startActivity(intent);

            }
        });


    }


}



