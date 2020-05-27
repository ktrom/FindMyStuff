package com.example.frontlyendly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

//useful buttons: https://www.geeksforgeeks.org/handling-click-events-button-android/
//useful requests reference: https://developer.android.com/training/volley/request
//GREAT volley examples: https://www.itsalif.info/content/android-volley-tutorial-http-get-post-put
public class HomeActivity extends AppCompatActivity {
    TextView textView;
    Button firstButton, secondButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView = (TextView)findViewById(R.id.test_text);
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
                params.put("username", "kyle");
                params.put("password", "yavitch");

                return params;
            }
        };
        queue.add(postRequest);
//        StringRequest stringRequest;
//        firstButton = findViewById(R.id.first_button);
//        firstButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//               stringRequest = new StringRequest(Request.Method.GET,"http://192.168.1.6:8080/test2" ,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                // Display the first 500 characters of the response string.
//                                textView.setText(response);
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        textView.setText(error.getMessage());
//                    }
//                });
//            }
//        });
//        secondButton = findViewById(R.id.second_button);
//        firstButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                stringRequest = new StringRequest(Request.Method.GET, "http://192.168.1.6:8080/test3",
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                // Display the first 500 characters of the response string.
//                                textView.setText(response);
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        textView.setText(error.getMessage());
//                    }
//                });
//
//            }
//        });

    }

    public void setText(String text)
    {
        textView.setText(text);
    }
}
