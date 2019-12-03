package com.example.multiplication;

import java.util.Random;

public class Game {
    private QuestionList questionList;
    private static int[] answerList;
    private int questionNbr = 0;
    private final int nbrOfQuestions = 20;

    Game(int mode, int specificNbr){
        Random rand = new Random();
        questionList = new QuestionList(rand, mode, specificNbr, nbrOfQuestions);
        answerList = new int[nbrOfQuestions];
    }

    /*
    Returns an array of answers to the questions.
     */
    public static int[] getAnswerList(){
        return answerList;
    }

    /*
    Sets the answer to a specific question and saves it to an array.
     */
    void setAnswer(int pos, int answer){
        answerList[pos] = answer;
    }

    /*
    Returns a new question if there are new questions.
     */
    public String nextQuestion(){
        if(questionNbr < nbrOfQuestions){
            return questionList.getQuestion(questionNbr++).getQuestion();
        }
        return "";
    }


    public String[] resultList(){
        String[] resultList = new String[nbrOfQuestions + 1];
        for(int i = 0; i < nbrOfQuestions; i++){
            resultList[i] = "  " + questionList.getQuestion(i).getQuestionsAndAnswer() + " : " + answerList[i];
        }
        resultList[nbrOfQuestions] =  "  " + getNbrOfCorrectlyAnsweredQuestions();
        return resultList;
    }

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
