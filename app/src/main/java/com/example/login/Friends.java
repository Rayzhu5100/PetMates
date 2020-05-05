package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class Friends extends AppCompatActivity {
    TextView back;
    ListView listView;
    String[] friendlist;
    String[] friendimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        Intent intent = getIntent();
        final String email = intent.getStringExtra("email");

        back = findViewById(R.id.btnBackF);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Friends.this,Main_menu.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
    }
}
