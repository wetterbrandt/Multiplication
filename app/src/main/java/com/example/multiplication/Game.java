package com.example.multiplication;

import android.widget.TextView;

import java.util.Random;

public class Game {
    private QuestionList questionList;
    private Random rand;

    public Game(int mode, int specificNbr){
        // Creates the game layout.
        rand = new Random();
        questionList = new QuestionList(rand, mode, specificNbr);
        Question[] list = questionList.getQuestionList();
        int questionNbr = 1;
        String question;
      //  TextView questionText = (TextView) findViewById(R.id.questionText);
        while(questionNbr < 21){
            question = questionList.getQuestion(questionNbr).getQuestion();
     //       questionText.setText(question);
            // Wait for answer
            questionNbr++;
        }
    }
}
