package com.example.multiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnKeyListener;


public class Game2Activity extends AppCompatActivity {
    TextView questionText;
    Game game;
    EditText answerTextEdit;
    Button previousBtn;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        questionText = (TextView) findViewById(R.id.questionText);
        answerTextEdit = (EditText) findViewById(R.id.answerTextEdit);
        previousBtn = (Button) findViewById(R.id.preBtn);
        nextBtn = (Button) findViewById(R.id.nextBtn);
        //previousBtn.setVisibility(View.VISIBLE);
        answerTextEdit.setOnKeyListener(new OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {

                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    if(game == null) {
                        game = new Game(2, Integer.parseInt(answerTextEdit.getText().toString()));
                    }else{
                        game.setAnswer(game.getCurrentQuestionPosition() - 1, Integer.parseInt(answerTextEdit.getText().toString()));
                    }
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
        if(game != null){
            answerTextEdit.setHint("Answer");
            previousBtn.setHint("Previous");
            answerTextEdit.getText().clear();
            questionText.setText(game.nextQuestion());
        }else{
            questionText.setText("Välj multiplikationstabell");
            answerTextEdit.setHint("Specify number");
        }

       /* if(game.getCurrentQuestionPosition() == 19){
            Intent intent = new Intent(this, ResultActivity.class);
            startActivity(intent);
        } */
    }

    @Override
    protected void onPause(){
        super.onPause();

    }





}
