package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main_menu extends AppCompatActivity {
    Button _Profile,Friends,_Pairing,_Forum,_Support;
    DatabaseHelper db;
    TextView logout;
    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        db = new DatabaseHelper(this);

        //get email value from last activity
        Intent intent = getIntent();
        email = intent.getStringExtra("email");

        _Profile = (Button)findViewById(R.id.btnProfile);
        Friends = (Button)findViewById(R.id.btnFriends);
        _Pairing = (Button)findViewById(R.id.btnPairing);
        _Forum = (Button)findViewById(R.id.btnForum);
        _Support = (Button)findViewById(R.id.btnApplication_support);
        logout = findViewById(R.id.menulogout);

        _Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.chkprofile_exist(email)){
                    Intent intent = new Intent(Main_menu.this, Create_Profile.class);
                    Toast.makeText(getApplicationContext(), "Please create your user profile", Toast.LENGTH_SHORT).show();
                    intent.putExtra("email", email);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(Main_menu.this,View_prefile.class);
                    //save email value to next activity
                    intent.putExtra("email", email);
                    startActivity(intent);
                }
            }
        });

        Friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (db.chkprofile_exist(email)) {
                    Toast.makeText(getApplicationContext(), "Please create user profile before access Friends feature", Toast.LENGTH_SHORT).show();
                } else{
                    Intent intent = new Intent(Main_menu.this, Friends.class);
                    intent.putExtra("email",email);
                    startActivity(intent);
                }
            }
        });
        _Pairing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.chkprofile_exist(email)){
                    Toast.makeText(getApplicationContext(),"Please create user profile before access Pairing feature",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(Main_menu.this, Pairing.class);
                    intent.putExtra("email",email);
                    startActivity(intent);
                }
            }
        });
        _Forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_menu.this,Forum.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
        _Support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_menu.this,Application_Support.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_menu.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
