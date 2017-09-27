package com.icook.dev.i_cook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SessionChecker session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = new SessionChecker(this);

    }

    public void onLogins (View v){
        if (session.isLoggedIn()) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(getApplicationContext(),"Please register first.", Toast.LENGTH_LONG).show();
        }

    }

    public void onRegisters (View v){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

}
