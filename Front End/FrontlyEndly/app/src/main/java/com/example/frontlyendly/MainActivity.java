package com.example.frontlyendly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


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
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.6:8080/users/create";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("username", editusername.getText().toString());
                params.put("password", editpassword.getText().toString());

                return params;
            }
        };
        queue.add(postRequest);
        return true;
    }

    public void showErrorMesssage()
    {

    }


}
