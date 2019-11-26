package com.example.multiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Collections;


public class ResultActivity extends AppCompatActivity {
    ListView resultList;
    Button newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] results = {"Varför funkar det inte" , "2", "3", "4" , "5"};
        setContentView(R.layout.activity_result);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_result, results);
        resultList = (ListView) findViewById(R.id.resultList);
        resultList.setAdapter(adapter);
        newGame = (Button) findViewById(R.id.newGameButton);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

    }

    private void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
