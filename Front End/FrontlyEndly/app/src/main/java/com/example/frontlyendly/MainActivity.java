package com.example.frontlyendly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


//https://dzone.com/articles/crud-in-volley-using-android-studio for more Volley info
public class MainActivity extends AppCompatActivity {
    TextView editusername;
    TextView editpassword;
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
        System.out.print(username + " " + password);
        login(username, password);
    }

    public String getUsername(){
        return editusername.getText().toString();
    }

    public String getPassword(){
        return editpassword.getText().toString();
    }

    public void login(String username, String password){
        //perform login action
    }
}
