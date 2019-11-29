package com.example.multiplication;

import java.util.Random;

public class Question {
    private int nbr1, nbr2, correctAnswer;
    private Random rand;

    public Question(Random rand, int mode, int nbr){
        this.rand = rand;
        if(mode == 1) {
            nbr1 = 1 + rand.nextInt(10);
            nbr2 = 1 + rand.nextInt(10);
        }else if(mode == 2){
            if(nbr >= 10) {
                nbr1 = 1 + rand.nextInt(nbr);
                nbr2 = 1 + rand.nextInt(nbr);
            }else {
                nbr1 = nbr;
                nbr2 = 1 + rand.nextInt(10);
            }
        }
        correctAnswer = nbr1 * nbr2;
    }

    public int getNbr1(){
        return nbr1;
    }

    public int getNbr2(){
        return nbr2;
    }

    public String getQuestion(){
            return nbr1 + " * " + nbr2 + " = ?";
    }

    public boolean correctAnswer(int answer){
        if(answer == correctAnswer){
            return true;
        }
        return false;
    }

    public String getQuestionsAndAnswer(){
        int product = nbr1 * nbr2;
        return (nbr1 + " * " + nbr2 + " = " + product);
    }

}



