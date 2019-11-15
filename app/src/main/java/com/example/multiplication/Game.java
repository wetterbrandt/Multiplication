package com.example.multiplication;

import android.widget.TextView;

import java.util.Random;

public class Game {
    private QuestionList questionList;
    private Random rand;
    private int[] answerList;
    private int questionNbr = 0;

    public Game(int mode, int specificNbr){
        rand = new Random();
        questionList = new QuestionList(rand, mode, specificNbr);
        answerList = new int[20];
    }

    /*
    Returns an array of answers to the questions.
     */
    public int[] getAnswerList(){
        return answerList;
    }

    /*
    Sets the answer to a specific question and saves it to an array.
     */
    public void setAnswer(int pos, int answer){
        answerList[pos] = answer;
    }

    /*
    Returns a new question if there are new questions.
     */
    public String nextQuestion(){
        if(questionNbr < 20){
            return questionList.getQuestion(questionNbr++).getQuestion();
        }
        return "";
    }

    public boolean[] resultList(){
        boolean[] resultList = new boolean[20];
        for(int i = 0; i < 20; i++){
            if(questionList.getQuestion(i).correctAnswer(answerList[i])){
                resultList[i] = true;
            }else{
                resultList[i] = false;
            }
        }
        return resultList;
    }

    public int getCurrentQuestionPosition(){
        return questionNbr;
    }





}
