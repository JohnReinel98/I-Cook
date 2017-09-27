package com.icook.dev.i_cook;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    SQLiteDataBaseAdapter mh;
    SessionChecker session;
    private ProgressDialog progressDialog;
    Button btnSubmit,btnCancel;
    EditText txtusername,txtconfpassw,txtpassw,txtemail,txtcontact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtusername = (EditText) findViewById(R.id.registerTxtUsername);
        txtconfpassw = (EditText) findViewById(R.id.registerTxtConfPassword);
        txtpassw = (EditText) findViewById(R.id.registerTxtPassword);
        txtemail = (EditText) findViewById(R.id.registerTxtEmail);
        txtcontact = (EditText) findViewById(R.id.registerTxtContact);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnSubmit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        mh = new SQLiteDataBaseAdapter(this);
        session = new SessionChecker(this);
    }

    public void clearPressed (View v){
        txtusername.setText("");
        txtpassw.setText("");
        txtemail.setText("");
        txtcontact.setText("");
    }

    @Override
    public void onClick(View view) {
        if(view == btnSubmit){
            String getUsern = txtusername.getText().toString();
            String getConfPassw = txtconfpassw.getText().toString();
            String getPassw = txtpassw.getText().toString();
            String getEmail = txtemail.getText().toString();
            String getContact = txtcontact.getText().toString();

            progressDialog.setMessage("Registering User...");
            progressDialog.show();

            if(!getPassw.equals(getConfPassw)){
                Toast.makeText(getApplicationContext(),"Passwords does not match.",Toast.LENGTH_LONG).show();
                progressDialog.hide();
            }else {
                long id = mh.helper.registerUser(getUsern, getPassw, getEmail, getContact);
                if(id<0){
                    Toast.makeText(getApplicationContext(),"Register unsuccessful, Please try again.",Toast.LENGTH_LONG).show();
                    progressDialog.hide();
                }else{
                    progressDialog.hide();
                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                    session.setLogin(true);
                }
            }
        }else if(view == btnCancel){
            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }
    }
}
