package com.example.ass3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Vote extends AppCompatActivity {

    TextView v1, v2, v3;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);


        v1 = findViewById(R.id.v1);
        v2 = findViewById(R.id.v2);
        v3 = findViewById(R.id.v3);
        back = findViewById(R.id.button2);

        String vote1 = getIntent().getStringExtra("vote1");
        String vote2 = getIntent().getStringExtra("vote2");
        String vote3 = getIntent().getStringExtra("vote3");

        v1.setText(vote1);
        v2.setText(vote2);
        v3.setText(vote3);

        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Vote.this, MainActivity.class);

                startActivity(intent);
            }
        });


    }

}
