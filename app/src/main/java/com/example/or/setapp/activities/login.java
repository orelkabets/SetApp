package com.example.or.setapp.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;

import com.example.or.setapp.R;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class login extends Activity {

    Button googleLogin;
    LoginButton facebookLogin;
    CallbackManager callbackManager;
    String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_login);

        ActionBar actionBar = getActionBar();
        actionBar.hide();

        facebookLogin = (LoginButton)findViewById(R.id.facebook_login);
        googleLogin   = (Button)findViewById(R.id.google_login);


        facebookLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                info= "User ID: " + loginResult.getAccessToken().getUserId()
                                + "\n" +
                        "Auth Token: " + loginResult.getAccessToken().getToken();

                startActivity(new Intent(login.this,loginDetails.class));
            }

            @Override
            public void onCancel() {
                info="Login attempt canceled.";
            }

            @Override
            public void onError(FacebookException e) {
                info="Login attempt failed.";
            }
        });
        googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,loginDetails.class));
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
