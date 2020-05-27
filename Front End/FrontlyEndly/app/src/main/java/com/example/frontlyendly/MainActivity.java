package com.example.frontlyendly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//https://dzone.com/articles/crud-in-volley-using-android-studio for more Volley info
public class MainActivity extends AppCompatActivity {
    TextView editusername;
    TextView editpassword;
    String errorMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editusername = (TextView) findViewById(R.id.edit_username);
        editpassword = (TextView) findViewById(R.id.edit_password);
    }

    public void loginAction(View view)
    {
        String username = getUsername();
        String password = getPassword();
        Intent intent = new Intent(this, HomeActivity.class);
        if (login(username, password)) {
            startActivity(intent);
        } else {
            showErrorMesssage();
        }
    }

    public String getUsername(){
        return editusername.getText().toString();
    }

    public String getPassword(){
        return editpassword.getText().toString();
    }

    public boolean login(String username, String password){
        //perform login action
        return true;
    }

    public void showErrorMesssage()
    {

    }


}
