package com.quizapp.screens;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

        saveQuestionToFile(question);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registro de Questão");
        alert.setHeaderText(null);
        alert.setContentText("Questão registrada com sucesso!");
        alert.showAndWait();
    }

    @FXML
    private void backMenu(ActionEvent event) {
        App.popScreen();
    }

    private void saveQuestionToFile(Question question) {
        String folderPath = "questions";
        String filePath = folderPath + "/questions.txt";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("Enunciado: " + question.getStatement() + "\n");
            writer.write("Correta: " + question.getCorrectAnswer() + "\n");
            writer.write("Outras Alternativas:\n");
            for (String alternative : question.getOthersAlternatives()) {
                writer.write("- " + alternative + "\n");
            }
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}