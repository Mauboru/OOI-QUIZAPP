package com.quizapp.screens;

import com.quizapp.App;
import com.quizapp.models.ControlQuizz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class HomeScreen {
    private ControlQuizz controlQuizz;

    public HomeScreen(ControlQuizz controlQuizz) {
        this.controlQuizz = controlQuizz;
    }

    @FXML
    void goToQuizz(ActionEvent event) {
        if (controlQuizz != null && controlQuizz.hasQuestions()) {
            App.pushScreen("QUIZ");
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText("Nenhuma Questão Disponível");
            alert.setContentText(
                    "Não há questões disponíveis para o quiz. Por favor, adicione questões e tente novamente.");
            alert.showAndWait();
        }
    }

    @FXML
    void goToRegister(ActionEvent event) {
        App.pushScreen("REGISTER");
    }
}