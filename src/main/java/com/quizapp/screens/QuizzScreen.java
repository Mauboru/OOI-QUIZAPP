package com.quizapp.screens;

import com.quizapp.App;
import com.quizapp.models.ControlQuizz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class QuizzScreen {
    private ControlQuizz controlQuizz;

    public QuizzScreen(ControlQuizz controlQuizz) {
        this.controlQuizz = controlQuizz;
    }

    @FXML
    private void backMenu(ActionEvent event) {
        App.popScreen();
    }

    @FXML
    private void respondeQuestao() {
        
    }

    @FXML
    private void reiniciar() {
        
    }
}