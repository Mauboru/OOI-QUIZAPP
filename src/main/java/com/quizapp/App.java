package tecno.maub.tec.quizapp;

import io.github.hugoperlin.navigatorfx.*;
import tecno.maub.tec.quizapp.screens.*;

public class App extends BaseAppNavigator{
    @Override
    public void init() throws Exception {
        super.init();
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
    }
}