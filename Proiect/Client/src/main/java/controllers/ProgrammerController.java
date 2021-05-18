package controllers;

import domain.Bug;
import domain.Programmer;
import domain.Severity;
import domain.User;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.Observer;
import services.Service;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ProgrammerController extends UnicastRemoteObject implements Controller, Observer, Serializable {

    private Service service;
    private Programmer loggedProgrammer;
    private transient final ObservableList<Bug> model = FXCollections.observableArrayList();

    @FXML
    transient Label labelGreeting;
    @FXML
    transient TableView<Bug> tableViewBugs;
    @FXML
    transient TableColumn<Bug, String> tableColumnName;
    @FXML
    transient TableColumn<Bug, String> tableColumnSeverity;
    @FXML
    transient TableColumn<Bug, String> tableColumnStatus;
    @FXML
    transient TextArea textAreaDescription;
    @FXML
    transient ComboBox<Severity> comboBoxSeverity;

    public ProgrammerController() throws RemoteException {
    }

    @Override
    public void close() {
        Stage stage = (Stage) labelGreeting.getScene().getWindow();
        stage.close();
        this.service.removeObserver(this);
    }

    @Override
    public void initialise(Service service, User user) {
        this.service = service;
        this.loggedProgrammer = (Programmer)user;
        labelGreeting.setText("Hello " + loggedProgrammer.getUsername());

        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnSeverity.setCellValueFactory(new PropertyValueFactory<>("severity"));
        tableColumnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tableViewBugs.setItems(model);

        tableViewBugs.getSelectionModel().selectedItemProperty().addListener((obs, old, newS) -> {
            if (newS != null) {
                textAreaDescription.setText(newS.getDescription());
            }
        });

        comboBoxSeverity.setItems(FXCollections.observableArrayList(Severity.values()));

        this.service.addObserver(this);
        displayBugs(this.service.getAllBugs());

        Stage stage = (Stage) labelGreeting.getScene().getWindow();
        stage.setOnCloseRequest(event -> this.service.removeObserver(this));
    }

    @Override
    public Service getService() {
        return this.service;
    }

    @Override
    public User getLoggedUser() {
        return this.loggedProgrammer;
    }

    public void displayBugs(List<Bug> bugs) {
        model.setAll(bugs);
    }

    @Override
    public void addedBug(Bug bug) throws RemoteException {
        this.model.add(bug);
    }

    public void buttonFilterBugsClicked(ActionEvent actionEvent) {
        Severity severity = comboBoxSeverity.getValue();
        if (severity == null) {
            MyAlert.showMessage(null, Alert.AlertType.WARNING, "Warning", "You have not selected any severity");
            return;
        }
        List<Bug> bugs = service.findBugsBySeverity(severity);
        displayBugs(bugs);
    }

    public void buttonClearClicked(ActionEvent actionEvent) {
        List<Bug> bugs = service.getAllBugs();
        displayBugs(bugs);
    }
}
