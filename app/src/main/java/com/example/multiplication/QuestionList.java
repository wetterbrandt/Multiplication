package com.example.multiplication;

import java.util.Random;

public class QuestionList {
    private Question[] list;

    public QuestionList(Random rand, int mode, int nbr){
        generateListWithQuestions(rand, mode, nbr);
    }

    private void generateListWithQuestions(Random rand, int mode, int nbr){
        list = new Question[20];
        for(int i = 0; i < 20; i++){
            list[i] = new Question(rand, mode, nbr);
        }
    }

    /*public boolean[] checkAnswersBetweenLists(int[] answerList){
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
*/
    public Question[] getQuestionList(){
        return list;
    }

    public Question getQuestion(int pos){
        if(pos >= 21 || pos < 0){
            return null;
        }
        return list[pos];
    }
}
