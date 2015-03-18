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
import com.example.ulugbek.myapplication.entities.Consts;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final AutoCompleteTextView emailView = (AutoCompleteTextView) findViewById(R.id.email);
        final EditText passwordEditText = (EditText) findViewById(R.id.password);


        Button signInBtn = (Button) findViewById(R.id.email_sign_in_button);
        signInBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // show progressbar
                showDialog();
                // get data from ui
                String email = emailView.getText().toString();
                String password = passwordEditText.getText().toString();
                Log.i("email", email);
                Log.i("password", password);

                //make request to server
                String response = "";
                try {
                    response = getLoginResponse(email, password);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                Log.i("response", response);

                // open new activity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class );
                startActivity(intent);
                dismissDialog();

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

    private String getLoginResponse(String email, String password)
            throws UnsupportedEncodingException {

        String langCode = "2";

        String data = URLEncoder.encode("X_ASCCPE_USERNAME", "UTF-8")
                + "=" + URLEncoder.encode(email, "UTF-8");

        data += "&" + URLEncoder.encode("X_ASCCPE_PASSWORD", "UTF-8")
                + "=" + URLEncoder.encode(password, "UTF-8");

        data += "&" + URLEncoder.encode("ACCEPT_LANGUAGE", "UTF-8")
                + "=" + URLEncoder.encode(langCode, "UTF-8");

        String response = "";
        BufferedReader reader = null;

        // Send data
        try
        {

            // Defined URL  where to send data
            URL url = new URL(Consts.loginURL);
            // Send POST data request

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write( data );
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "\n");
            }


            response = sb.toString();
        }
        catch(Exception ex)
        {

        }
        finally
        {
            try
            {

                reader.close();
            }

            catch(Exception ex) {}
        }

        return response;

    }


}



