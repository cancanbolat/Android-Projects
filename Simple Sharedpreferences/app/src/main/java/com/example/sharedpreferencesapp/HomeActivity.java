package com.example.sharedpreferencesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView welcomeText, nameText, emailText;
    Button logout_btn;

    SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        xml_define();

        sharedPreferences = getSharedPreferences(PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME,null);
        String email = sharedPreferences.getString(KEY_EMAIL,null);

        if (name != null || email != null)
        {
            nameText.setText("Name : "+name);
            emailText.setText("Email : "+email);
        }

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(getApplicationContext(),"Log out succesful",Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }

    public void xml_define() {

        welcomeText = findViewById(R.id.welcomeText);
        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);
        logout_btn = findViewById(R.id.logout_btn);

    }

}