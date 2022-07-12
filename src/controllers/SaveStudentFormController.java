package controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import model.Student;
import util.CrudUtil;

import java.sql.SQLException;

public class SaveStudentFormController {
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtContactNo;
    public JFXTextField txtAddress;
    public JFXTextField txtNic;

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Student s = new Student(txtId.getText(),txtName.getText(),txtEmail.getText(),txtContactNo.getText(),txtAddress.getText(),txtNic.getText());

        try {
            if(CrudUtil.execute("INSERT INTO Student VALUES (?,?,?,?,?,?)",s.getStudent_id(),s.getStudent_name(),s.getEmail(),s.getContact(),s.getAddress(),s.getNic())){
                new Alert(Alert.AlertType.CONFIRMATION,"Student Saved!..").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
}
