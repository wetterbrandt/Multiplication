package com.example.multiplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

/**
 * Activity for practising multiplication of two randomly generated numbers between 1 and 10.
 *
 * @author Gustav and Markus
 */
public class Game1Activity extends AppCompatActivity implements Serializable{
    TextView questionText;
    Game game;
    EditText answerTextEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        game = new Game(1, 0);
        questionText = findViewById(R.id.questionText);
        answerTextEdit = findViewById(R.id.answerTextEdit1);
        answerTextEdit.setOnKeyListener(new OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {

                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    // Perform action on key press
                    if(!answerTextEdit.getText().toString().matches("")) {
                        game.setAnswer(game.getCurrentQuestionPosition() - 1, Integer.parseInt(answerTextEdit.getText().toString()));

                        if (game.getCurrentQuestionPosition()  >= game.getNbrOfQuestions()) {
                            openResultActivity();
                        } else {
                            onResume();
                        }
                    } else {
                        if (game.getCurrentQuestionPosition()  >= game.getNbrOfQuestions()) {
                            onStop();
                        } else {
                            game.setAnswer(game.getCurrentQuestionPosition() - 1, 0);
                            onResume();

                        }
                    }
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
        answerTextEdit.getText().clear();
        answerTextEdit.setHint("Svar");
        questionText.setText(game.nextQuestion());
    }

    @Override
    protected void onPause(){
        super.onPause();

    }

    @Override
    protected void onStop(){
        super.onStop();
        openResultActivity();
    }


    private void openResultActivity(){
        Intent intent = new Intent(Game1Activity.this, ResultActivity.class);
        intent.putExtra("gameObj", game.getEverythingList());  // Ny
        startActivity(intent);
    }








}
