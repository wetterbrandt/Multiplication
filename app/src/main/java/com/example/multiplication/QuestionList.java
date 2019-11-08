package com.example.multiplication;

import java.util.Random;

public class QuestionList {
    private Question[] list;

    public QuestionList(int mode){
        generateListWithQuestions(mode);
    }

    private void generateListWithQuestions(int mode){
        switch(mode){
            case 1:
                list = new Question[20];
                Random rand = new Random();
                for(int i = 0; i < 20; i++){
                    list[i] = new Question(rand);
                }
                break;
        }
    }

    public boolean[] checkAnswersBetweenLists(int[] answerList){
        boolean[] answers = new boolean[20];
        int i = 0;
        for (Question q: list) {
            if(q.correctAnswer(answerList[i])){
                answers[i] = true;
            }else{
                answers[i] = false;
            }
            i++;
        }
        return answers;
    }

    public Question[] getQuestionList(){
        return list;
    }
}
