package com.example.multiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnKeyListener;


public class Game1Activity extends AppCompatActivity {
    TextView questionText;
    Game game;
    EditText answerTextEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        game = new Game(1, 0);
        questionText = (TextView) findViewById(R.id.questionText);
        answerTextEdit = (EditText) findViewById(R.id.answerTextEdit);
        answerTextEdit.setOnKeyListener(new OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    game.setAnswer(game.getCurrentQuestionPosition() - 1, Integer.parseInt(answerTextEdit.getText().toString()));
                    onResume();
                    return true;
                }
                return false;
            }
        });


    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
        // Lägg in en if om fråga 20.
        answerTextEdit.getText().clear();
        questionText.setText(game.nextQuestion());
    }

    @Override
    protected void onPause(){
        super.onPause();

    }





}
