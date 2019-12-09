
package com.example.multiplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


/**
 * @author Gustav and Markus
 */
public class Game {
    private QuestionList questionList;
    private static String[] answerList;
    private int questionNbr = 0;
    private final int nbrOfQuestions = 5;

    /**
     * Constructor method for the class Game.
     *
     * @param mode        The mode you want to use the app in.
     * @param specificNbr The multiplication table you want to practise on.
     */
    Game(int mode, int specificNbr) {
        Random rand = new Random();
        questionList = new QuestionList(rand, mode, specificNbr, nbrOfQuestions);
        answerList = new String[nbrOfQuestions];
    }


    /**
     * Sets the answer to a specific question and saves it to an array.
     *
     * @param pos    The position of the current question in the array.
     * @param answer The answer provided by the user.
     */
    void setAnswer(int pos, String answer) {
        answerList[pos] = answer;
    }

    /**
     * Returns a new question if there are new questions.
     *
     * @return A new question
     */
    String nextQuestion() {
        if (questionNbr < nbrOfQuestions) {
            return questionList.getQuestion(questionNbr++).getQuestion();
        }
        return "";
    }

    /**
     * Counter that determines the number of correctly answered questions and returns that value.
     *
     * @return The number of correctly answered questions.
     */
    private int getNbrOfCorrectlyAnsweredQuestions() {
        int correct = 0;
        for (int i = 0; i < nbrOfQuestions; i++) {
            if (questionList.getQuestion(i).correctAnswer(Integer.parseInt(answerList[i]))) {
                correct++;
            }
        }
        return correct;
    }

    int getCurrentQuestionPosition() {
        return questionNbr;
    }

    int getNbrOfQuestions() {
        return nbrOfQuestions;
    }


    /* TODO: Markus should comment this ;) */
    String[] getEverythingList() {
        ArrayList<String> array = new ArrayList<String>();
        array.add("  " + getNbrOfCorrectlyAnsweredQuestions() + "/" + nbrOfQuestions + " correct");
        array.addAll(1, Arrays.asList(getQuestionStringList()));
        array.addAll(1 + nbrOfQuestions, Arrays.asList(answerList));
        array.addAll(1 + (2 * nbrOfQuestions), Arrays.asList(getCorrectAnswerList()));
        return array.toArray(new String[(nbrOfQuestions * 3) + 1]);
    }

    private String[] getQuestionStringList() {
        String[] temp = new String[nbrOfQuestions];
        for (int i = 0; i < nbrOfQuestions; i++) {
            temp[i] = "" + questionList.getQuestion(i).getQuestionsAndAnswer() + " : " + answerList[i];
        }
        return temp;
    }

    private String[] getCorrectAnswerList() {
        String[] temp = new String[nbrOfQuestions];
        for (int i = 0; i < nbrOfQuestions; i++) {
            temp[i] = "" + questionList.getQuestion(i).getCorrectAnswer();
        }
        return temp;
    }
}