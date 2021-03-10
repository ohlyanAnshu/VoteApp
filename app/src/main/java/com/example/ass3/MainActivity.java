package com.example.ass3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String[] country = { "Choose Candidate", "Candidate 1", "Candidate 2", "Candidate 3"};
    Button votebtn;
    EditText name, id;
    ToggleButton t1;
    int count1 =0, count2=0, count3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = (Spinner) findViewById(R.id.spinner);


        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(aa);

        name = findViewById(R.id.editText);
        id= findViewById(R.id.editText2);
        t1 = findViewById(R.id.toggleButton);
        votebtn = findViewById(R.id.button);

        List<String> idList = new ArrayList<>();

        String userId = id.getText().toString();

        if(idList.contains(userId)){
            Toast.makeText(getApplicationContext(),"This user has already voted", Toast.LENGTH_SHORT);
        }

        else {

            t1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        idList.add(userId);

                        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                String selectedItem = String.valueOf(parent.getItemAtPosition(position));
                                switch (selectedItem) {
                                    case "Candidate 1":
                                        count1++;
                                    case "Candidate 2":
                                        count2++;
                                    case "Candidate 3":
                                        count3++;
                                    default:
                                        Toast.makeText(getApplicationContext(), "Please select a candidate", Toast.LENGTH_SHORT);
                                }

                            }

                            @Override
                            public void onNothingSelected (AdapterView < ? > adapterView){

                            }
                        });


                    } else {
                        Toast.makeText(getApplicationContext(),"Please accept terms", Toast.LENGTH_SHORT);
                    }

                    votebtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String ct1 = String.valueOf(count1);
                            String ct2 = String.valueOf(count2);
                            String ct3 = String.valueOf(count3);

                            Intent intent = new Intent(MainActivity.this, Vote.class);
                            intent.putExtra("vote1", ct1);
                            intent.putExtra("vote2", ct2);
                            intent.putExtra("vote3", ct3);
                            startActivity(intent);

                        }
                    });
                }
            });
        }

    }


}