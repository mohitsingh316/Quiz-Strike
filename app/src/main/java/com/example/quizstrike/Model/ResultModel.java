package com.example.quizstrike.Model;

import com.example.quizstrike.views.ResultFragment;

public class ResultModel {

    private int correct ,wrong, notAnswered;

    public ResultModel(){}

    public int getWrong() {
        return wrong;
    }

    public int getCorrect() {
        return correct;
    }

    public int getNotAnswered() {
        return notAnswered;
    }
}