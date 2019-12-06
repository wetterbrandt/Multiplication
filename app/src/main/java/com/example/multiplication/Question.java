package com.example.multiplication;

import java.util.Random;

/**
 * Class that generates questions.
 * <p>
 * This class randomly generates two numbers for the user to multiply. Depending on the chosen mode the numbers get generated differently.
 * Mode 1 generates two evenly distributed random numbers from 1 to 10.
 * Mode 2 generates one random number between 1 and 10 if specified number is <= 10.
 * If specified number is >= 10 then two evenly distributed random numbers between 1 and nbr is generated.
 *
 * @author Gustav and Markus
 */
public class Question {
    private int nbr1, nbr2, correctAnswer;

    /**
     * Generates the Question class.
     * @param rand The random generator.
     * @param mode The mode of operation selected by the user.
     * @param nbr The multiplication table provided by the user.
     */
    public Question(Random rand, int mode, int nbr){

        if (mode != 1) {
            if(mode == 2){
                if(nbr >= 10) {
                    nbr1 = 1 + rand.nextInt(nbr);
                    nbr2 = 1 + rand.nextInt(nbr);
                }else {
                    nbr1 = nbr;
                    nbr2 = 1 + rand.nextInt(10);
                }
            }
        } else {
            nbr1 = 1 + rand.nextInt(10);
            nbr2 = 1 + rand.nextInt(10);
        }
        correctAnswer = nbr1 * nbr2;
    }


    String getQuestion(){
            return nbr1 + " * " + nbr2 + " = ?";
    }

    /**
     * Returns a boolean value.
     *     True if answer is correct answer
     *     Otherwise false.
     * @param answer The answer provided by the user
     * @return <code>true</code> if the answer is correct;
     *         <code>false</code> otherwise.
     */
    boolean correctAnswer(int answer){
        return answer == correctAnswer;
    }

    /*
    Returns the correct answer to the question.
     */
    int getCorrectAnswer(){
        return correctAnswer;
    }

    /*
    Returns a String
     */
    String getQuestionsAndAnswer(){
        int product = nbr1 * nbr2;
        return (nbr1 + " * " + nbr2 + " = " + product);
    }

}



