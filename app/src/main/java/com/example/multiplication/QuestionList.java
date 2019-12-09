package com.example.multiplication;

import java.util.Random;

/**
 * Class that generates a list containing the questions for one instance of the game.
 *
 * @author Gustav and Markus
 */
public class QuestionList {
    private Question[] list;
    private int nbrOfQuestions;

    /**
     * Generates an instance of the class Questionlist.
     * @param rand The random generator.
     * @param mode The game mode.
     * @param nbr The specified number.
     * @param nbrOfQuestions The number of questions that should be asked.
     */
    public QuestionList(Random rand, int mode, int nbr, int nbrOfQuestions){
        this.nbrOfQuestions = nbrOfQuestions;
        generateListWithQuestions(rand, mode, nbr, this.nbrOfQuestions);
    }

    private void generateListWithQuestions(Random rand, int mode, int nbr, int nbrOfQuestions){
        list = new Question[nbrOfQuestions];
        for(int i = 0; i < nbrOfQuestions; i++){
            list[i] = new Question(rand, mode, nbr);
        }
        checkListForDuplicateQuestions(list, rand, mode, nbr);
    }

    private void checkListForDuplicateQuestions(Question[] list, Random rand, int mode, int nbr){
        for(int i = 1; i < nbrOfQuestions; i++){
            if (list[i].equals(list[i - 1])){
                list[i] = new Question(rand, mode, nbr);
            }
        }
    }

    Question getQuestion(int pos){
        if(pos >= nbrOfQuestions || pos < 0){
            return null;
        }
        return list[pos];
    }
}
