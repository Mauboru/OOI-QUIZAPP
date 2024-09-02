package com.quizapp.models;

import java.util.*;

public class ControlQuizz {
    private ArrayList<Question> questions;
    private int actualQuestion, correctAnswers, wrongAnswers;

    public ControlQuizz(ArrayList<Question> questions) {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
        }
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public int getActualQuestion() {
        return actualQuestion;
    }

    public void setActualQuestion(int actualQuestion) {
        this.actualQuestion = actualQuestion;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    @Override
    public String toString() {
        return "ControlQuizz [questions=" + questions + ", actualQuestion=" + actualQuestion + ", correctAnswers="
                + correctAnswers + ", wrongAnswers=" + wrongAnswers + "]";
    }
}