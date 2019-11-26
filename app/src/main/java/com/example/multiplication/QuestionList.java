package com.example.multiplication;

import java.util.Random;

public class QuestionList {
    private Question[] list;
    private int nbrOfQuestions;

    public QuestionList(Random rand, int mode, int nbr, int nbrOfQuestions){
        this.nbrOfQuestions = nbrOfQuestions;
        generateListWithQuestions(rand, mode, nbr, this.nbrOfQuestions);
    }

    private void generateListWithQuestions(Random rand, int mode, int nbr, int nbrOfQuestions){
        list = new Question[nbrOfQuestions];
        for(int i = 0; i < nbrOfQuestions; i++){
            list[i] = new Question(rand, mode, nbr);
        }
    }

    public Question[] getQuestionList(){
        return list;
    }

    public Question getQuestion(int pos){
        if(pos >= nbrOfQuestions || pos < 0){
            return null;
        }
        return list[pos];
    }
}
