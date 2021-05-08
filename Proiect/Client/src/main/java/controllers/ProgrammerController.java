package controllers;

import domain.Programmer;
import domain.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import services.Service;

public class ProgrammerController implements Controller {

    private Service service;
    private Programmer loggedProgrammer;

    @FXML
    Label labelGreeting;

    @Override
    public void close() {
        Stage stage = (Stage) labelGreeting.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialise(Service service, User user) {
        this.service = service;
        this.loggedProgrammer = (Programmer)user;
        labelGreeting.setText("Hello " + loggedProgrammer.getUsername());
    }

    @Override
    public Service getService() {
        return this.service;
    }

    @Override
    public User getLoggedUser() {
        return this.loggedProgrammer;
    }
}
