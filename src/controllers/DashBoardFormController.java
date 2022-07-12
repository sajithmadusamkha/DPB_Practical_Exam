package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {
    public void btnSaveOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SaveStudentForm");
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        setUi("UpdateStudentForm");
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws IOException {
        setUi("StudentDeleteOnAction");
    }

    public void btnLoadAllStudentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoadAllStudentForm");
    }

    private void setUi(String url) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/"+ url + ".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle(url);
        stage.show();
    }
}
