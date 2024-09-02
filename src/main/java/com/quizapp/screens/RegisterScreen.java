package com.quizapp.screens;

import com.quizapp.App;
import com.quizapp.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class RegisterScreen {
    @FXML
    private Pane root;

    @FXML
    private TextField tfEnunciate, tfCorrect, tfWrong1, tfWrong2, tfWrong3;

    @FXML
    private Button btRegister, btCancel;

    private ControlQuizz controlQuizz;

    public RegisterScreen(ControlQuizz controlQuizz) {
        this.controlQuizz = controlQuizz;
    }

    @FXML
    private void registerQuestion(ActionEvent event) {
        Question question;
        String enunciate = tfEnunciate.getText();
        String correct = tfCorrect.getText();
        String[] others = { tfWrong1.getText(), tfWrong2.getText(), tfWrong3.getText() };

        question = new Question(enunciate, correct, others);
        controlQuizz.addQuestion(question);

        tfEnunciate.clear();
        tfCorrect.clear();
        tfWrong1.clear();
        tfWrong2.clear();
        tfWrong3.clear();
    }

    @FXML
    private void backMenu(ActionEvent event) {
        App.popScreen();
    }
}