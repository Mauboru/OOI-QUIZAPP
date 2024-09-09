package com.quizapp;

import com.quizapp.models.*;
import com.quizapp.screens.*;
import io.github.hugoperlin.navigatorfx.*;
import java.util.ArrayList;

public class App extends BaseAppNavigator{
    private ControlQuizz controlQuizz;

    @Override
    public void init() throws Exception {
        super.init();
        ArrayList<Question> list = new ArrayList<>();
        controlQuizz = new ControlQuizz(list);
    }

    @Override
    public String getHome() {
        return "HOME";
    }

    @Override
    public String getAppTitle() {
        return "Quiz App";
    }

    @Override
    public void registrarTelas() {
        registraTela("HOME", new ScreenRegistryFXML(App.class, "home.fxml", o-> new HomeScreen()));
        registraTela("REGISTER", new ScreenRegistryFXML(App.class, "register.fxml", o-> new RegisterScreen(controlQuizz)));
        // Passar o controlQuizz para o construtor de quizzscreen
        registraTela("QUIZ", new ScreenRegistryFXML(App.class, "quiz.fxml", o-> new QuizzScreen()));
    }
}