package com.example.multiplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity for practising multiplication of one specific table of the users choosing.
 *
 * @author Gustav and Markus
 */
public class Game2Activity extends AppCompatActivity {
    TextView questionText;
    Game game;
    EditText answerTextEdit;
    TextView chooseTableText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        questionText = findViewById(R.id.questionText);
        answerTextEdit = findViewById(R.id.answerTextEdit2);
        chooseTableText = findViewById(R.id.chooseTable);
    }

    @Override
    protected void onStart(){
        super.onStart();
        answerTextEdit.setOnKeyListener(new OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {

                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    if (game == null) {
                        game = new Game(2, Integer.parseInt(answerTextEdit.getText().toString()));
                        getNextQuestion();

                    } else {

                        if(!answerTextEdit.getText().toString().matches("")) {
                            game.setAnswer(game.getCurrentQuestionPosition() - 1, Integer.parseInt(answerTextEdit.getText().toString()));

                            if (game.getCurrentQuestionPosition()  >= game.getNbrOfQuestions()) {
                                openResultActivity();
                            } else {
                                getNextQuestion();
                            }
                        } else {

                            if (game.getCurrentQuestionPosition()  >= game.getNbrOfQuestions()) {
                                openResultActivity();
                            } else {
                                game.setAnswer(game.getCurrentQuestionPosition() - 1, 0);
                                getNextQuestion();

                            }
                        }
                    }



                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();

    }

    @Override
    protected void onStop(){
        super.onStop();
    }


    private void openResultActivity(){
        Intent intent = new Intent(Game2Activity.this, ResultActivity.class);
        intent.putExtra("gameObj", game.getEverythingList());  // Ny
        startActivity(intent);
    }

    private void getNextQuestion(){
        if(game != null){
            chooseTableText.setVisibility(View.INVISIBLE);

            answerTextEdit.getText().clear();
            answerTextEdit.setHint("Svar");
            questionText.setText(game.nextQuestion());
        } else {
            chooseTableText.setVisibility(View.VISIBLE);
            chooseTableText.setText(R.string.v_lj_multiplikationstabell);

        }
    }

}
