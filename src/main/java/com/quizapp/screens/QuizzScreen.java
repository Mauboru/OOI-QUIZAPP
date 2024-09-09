package com.quizapp.screens;

import java.util.List;
import com.quizapp.App;
import com.quizapp.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class QuizzScreen {
    private ControlQuizz controlQuizz;

    @FXML
    private Text txtStatement, txtResult, txtErrors, txtCorrect;

    @FXML
    private Button btCorrectAnswer, btWrongAnswer1, btWrongAnswer2, btWrongAnswer3, btBack, btNext, btRestart;

    public QuizzScreen() {
        controlQuizz = new ControlQuizz(null);
    }

    @FXML
    private void initialize() {
        updateComponents();
    }

    @FXML
    private void backMenu(ActionEvent event) {
        App.popScreen();
    }

    @FXML
    private void verifyAnswer(javafx.event.ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String alternative = clickedButton.getText();
        boolean isCorrect = controlQuizz.questionResponse(alternative);

        if (isCorrect) {
            txtResult.setText("Acertou!");
        } else {
            txtResult.setText("Errou!");
        }

        disableAlternatives();
        btNext.setVisible(true);
    }

    @FXML
    private void nextQuestion(ActionEvent event) {
        if (controlQuizz.hasNextQuestion()) {
            controlQuizz.nextQuestion();
            updateComponents();
        } else {
            updateComponents();
            int hits = controlQuizz.getHits();
            int errors = controlQuizz.getErrors();
            int totalQuestions = controlQuizz.getTotalQuestions();

            if (hits == errors) {
                txtResult.setText("EMPATOU!");
            } else if (hits > totalQuestions / 2) {
                txtResult.setText("VITÓRIA!");
            } else {
                txtResult.setText("DERROTA!");
            }

            endGame();
        }
    }

    @FXML
    private void reiniciar(ActionEvent event) {
        controlQuizz.restart();
        updateComponents();
    }

    public void updateComponents() {
        Question objQuestion = controlQuizz.getQuestions();
        List<String> questions = objQuestion.getAllsAlternatives();

        txtStatement.setText(objQuestion.getStatement());
        btCorrectAnswer.setText(questions.get(0));
        btWrongAnswer1.setText(questions.get(1));
        btWrongAnswer2.setText(questions.get(2));
        btWrongAnswer3.setText(questions.get(3));
        txtResult.setText("---------");

        btCorrectAnswer.setDisable(false);
        btWrongAnswer1.setDisable(false);
        btWrongAnswer2.setDisable(false);
        btWrongAnswer3.setDisable(false);

        txtCorrect.setText("Acertos: " + controlQuizz.getHits());
        txtErrors.setText("Erros: " + controlQuizz.getErrors());

        btRestart.setVisible(false);
    }

    public void disableAlternatives() {
        btCorrectAnswer.setDisable(true);
        btWrongAnswer1.setDisable(true);
        btWrongAnswer2.setDisable(true);
        btWrongAnswer3.setDisable(true);
    }

    private void endGame() {
        txtStatement.setVisible(false);
        btCorrectAnswer.setVisible(false);
        btWrongAnswer1.setVisible(false);
        btWrongAnswer2.setVisible(false);
        btWrongAnswer3.setVisible(false);
        btNext.setVisible(false);
        btRestart.setVisible(true);
    }
}