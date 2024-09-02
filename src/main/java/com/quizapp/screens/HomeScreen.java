package com.quizapp.screens;

import com.quizapp.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HomeScreen {
    @FXML
    void goToQuizz(ActionEvent event) {
        System.out.println("do anything quizz");
    }

    @FXML
    void goToRegister(ActionEvent event) {
        App.pushScreen("REGISTER");
    }
}