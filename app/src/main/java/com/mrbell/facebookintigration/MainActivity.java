package com.mrbell.facebookintigration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

public class MainActivity extends AppCompatActivity {

    private Button btn_login;
    private TextView tv_status;
    private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login=findViewById(R.id.login_button);
        tv_status=findViewById(R.id.loginstatus);
        callbackManager=CallbackManager.Factory.create();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginWithfb();
            }
        });
    }

    public void loginWithfb(){
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                tv_status.setText("loginsuccess"+loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                tv_status.setText("login canceled");

            }

            @Override
            public void onError(FacebookException error) {

                tv_status.setText("error: "+ error.getMessage());
            }
        });
    }
}
