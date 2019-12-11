package com.example.multiplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

/**
 * This activity displays the result of the previous game activity.
 *
 * @author Gustav and Markus
 */
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
        newGame = findViewById(R.id.newGameButton);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

    }

    /**
     * Method to jump to start screen.
     */
    private void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    /**
     *This method takes the String[] from getEverythingList() and divides it to more manageable components.
     * These components are used to display the results in resultActivity.
     * @param info input from getEverythingList().
     */
    private void generateLists(String[] info){
        int length = info.length / 3;
        answers = new String[length];
        correctAnswers = new String[length];
        results = new String[length + 1];
        results = Arrays.copyOfRange(info, 0, length + 1); // 0 - 5
        answers = Arrays.copyOfRange(info, length + 1, (length * 2) + 1); // 6 - 10
        correctAnswers = Arrays.copyOfRange(info, (length * 2) + 1, (length * 3) + 1); // 11 - 15
    }

}
