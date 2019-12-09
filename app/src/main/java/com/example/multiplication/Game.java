
package com.example.multiplication;

import java.util.Random;


/**
 * @author Gustav and Markus
 */
public class Game {
    private QuestionList questionList;
    private static int[] answerList;
    private int questionNbr = 0;
    private final int nbrOfQuestions = 20;

    /**
     * Constructor method for the class Game.
     *
     * @param mode The mode you want to use the app in.
     * @param specificNbr The multiplication table you want to practise on.
     */
    Game(int mode, int specificNbr){
        Random rand = new Random();
        questionList = new QuestionList(rand, mode, specificNbr, nbrOfQuestions);
        answerList = new int[nbrOfQuestions];
    }


    /**
     * Sets the answer to a specific question and saves it to an array.
     * @param pos The position of the current question in the array.
     * @param answer The answer provided by the user.
     */
    void setAnswer(int pos, int answer){
        answerList[pos] = answer;
    }

    /**
     * Returns a new question if there are new questions.
     * @return A new question
     */
    String nextQuestion(){
        if(questionNbr < nbrOfQuestions){
            return questionList.getQuestion(questionNbr++).getQuestion();
        }
        return "";
    }

    /**
     * Counter that determines the number of correctly answered questions and returns that value.
     * @return The number of correctly answered questions.
     */
    private int getNbrOfCorrectlyAnsweredQuestions(){
        int correct = 0;
        for(int i = 0; i < nbrOfQuestions; i++){
            if(questionList.getQuestion(i).correctAnswer(answerList[i])){
                correct++;
            }
        }
        return correct;
    }

    int getCurrentQuestionPosition(){
        return questionNbr;
    }

    int getNbrOfQuestions(){
        return nbrOfQuestions;
    }

    /* TODO: Markus should comment this ;) */
    String[] getEverythingList() {
        String[] temp = new String[(nbrOfQuestions * 3) + 1];
        for(int i = 0; i < nbrOfQuestions * 3; i++){
            if(i < nbrOfQuestions) {
                temp[i] = "  " + answerList[i];
            }else if (i < nbrOfQuestions * 2){
                temp[i] = "  " + questionList.getQuestion(i - nbrOfQuestions).getQuestionsAndAnswer() + " : " + answerList[i - nbrOfQuestions];
            }else {
                temp[i] = "  " + questionList.getQuestion(i - (2 * nbrOfQuestions)).getCorrectAnswer();
            }
            temp[nbrOfQuestions * 3] =  "  " + getNbrOfCorrectlyAnsweredQuestions() + "/" + nbrOfQuestions + " correct";
        }
        return temp;
    }



}


