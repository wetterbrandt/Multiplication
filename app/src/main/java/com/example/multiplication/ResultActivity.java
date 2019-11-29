package com.example.multiplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class ResultActivity extends AppCompatActivity {
    ListView resultView;
    Button newGame;

    String[] results = {"Varför funkar det inte" , "2", "3", "4" , "5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);



        CustomListAdapter adapter = new CustomListAdapter(this, results);
        resultView = findViewById(R.id.resultView);

     //   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_result, R.id.resultView, results);

        resultView.setAdapter(adapter);

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
