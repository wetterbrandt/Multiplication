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
    String[] results;
    String[] correctAnswers;
    String[] answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        generateLists((String[]) intent.getSerializableExtra("gameObj"));
        CustomListAdapter adapter = new CustomListAdapter(this, results, correctAnswers, answers);
        resultView = findViewById(R.id.resultView);
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

    private void generateLists(String[] info){
        int length = info.length / 3;
        answers = new String[length];
        correctAnswers = new String[length];
        results = new String[length + 1];
        int counter = 0;
        int counter2 = 0;
        int counter3 = 0;
        while(counter < info.length - 1){
            if(counter < length){
                answers[counter] = info[counter];
            }else if(counter < length * 2){
                results[counter2] = info[counter];
                counter2++;
            }else{
                correctAnswers[counter3] = info[counter];
                counter3++;
            }
            counter++;
        }
        results[length] = info[counter];
        String[] temp = new String[length + 1];
        for(int i = 0; i < temp.length; i++){
            if(i == 0){
                temp[0] = results[length];
            }else{
                temp[i] = results[i - 1];
            }
        }
        results = temp;

    }
}
