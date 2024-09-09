package com.quizapp.models;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ControlQuizz {
    private ArrayList<Question> questions;
    private int actualQuestion, correctAnswers, wrongAnswers, hits, errors;

    public ControlQuizz(ArrayList<Question> questions) {
        this.questions = questions != null ? questions : new ArrayList<>();
        restart();
        readQuestions();
    }

    public void restart() {
        Collections.shuffle(this.questions);
        setHits(0);
        setErrors(0);
        setActualQuestion(0);
    }

    public boolean hasNextQuestion() {
        return actualQuestion < getTotalQuestions() - 1;
    }

    public int getTotalQuestions() {
        return this.questions.size();
    }

    public int nextQuestion() {
        if (hasNextQuestion()) {
            this.actualQuestion++;
        }
        return this.actualQuestion;
    }

    public void addQuestion(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
        }
    }

    public Question getQuestions() {
        if (actualQuestion >= 0 && actualQuestion < this.questions.size()) {
            return this.questions.get(actualQuestion);
        } else {
            throw new IndexOutOfBoundsException("Nenhuma questão disponível ou índice fora do alcance.");
        }
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

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public int getErrors() {
        return errors;
    }

    public void readQuestions() {
        try (BufferedReader reader = new BufferedReader(new FileReader("questions/questions.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String statement = line.substring(line.indexOf(": ") + 2);
                line = reader.readLine();

                String correct = line.substring(line.indexOf(": ") + 2);
                ArrayList<String> others = new ArrayList<>();
                reader.readLine();

                for (int i = 0; i < 4; i++) {
                    line = reader.readLine();
                    if (line != null && !line.isEmpty()) {
                        others.add(line.substring(2));
                    }
                }

                String[] othersArray = new String[others.size()];
                others.toArray(othersArray);
                Question question = new Question(statement, correct, othersArray);
                addQuestion(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean questionResponse(String alternative) {
        boolean result;

        if (getQuestions().getCorrectAnswer().equals(alternative)) {
            setHits(getHits() + 1);
            result = true;
        } else {
            setErrors(getErrors() + 1);
            result = false;
        }
        return result;
    }

    @Override
    public String toString() {
        return "ControlQuizz [questions=" + questions + ", actualQuestion=" + actualQuestion + ", correctAnswers="
                + correctAnswers + ", wrongAnswers=" + wrongAnswers + "]";
    }
}