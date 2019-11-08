package com.example.multiplication;

import java.util.Random;

public class Question {
    private int nbr1, nbr2, correctAnswer;

    public Question(Random rand){
        nbr1 = rand.nextInt();
        nbr2 = rand.nextInt();
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
}



