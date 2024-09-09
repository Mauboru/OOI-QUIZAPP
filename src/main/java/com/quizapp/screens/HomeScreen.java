package com.quizapp.screens;

import com.quizapp.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class HomeScreen {
    @FXML
    void goToQuizz(ActionEvent event) {
        try {
            App.pushScreen("QUIZ");
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Nenhuma pergunta cadastrada");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void goToRegister(ActionEvent event) {
        App.pushScreen("REGISTER");
    }
}