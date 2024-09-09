package com.quizapp.screens;

import com.quizapp.App;
import com.quizapp.models.ControlQuizz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HomeScreen {
    ControlQuizz controlQuizz;

    @FXML
    void goToQuizz(ActionEvent event) {
        // Inserir try catch para caso o arquivo nao exista
        App.pushScreen("QUIZ");
    }

    @FXML
    void goToRegister(ActionEvent event) {
        App.pushScreen("REGISTER");
    }
}