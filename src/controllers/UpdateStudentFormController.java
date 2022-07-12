package controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import model.Student;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStudentFormController {

    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtContactNo;
    public JFXTextField txtAddress;
    public JFXTextField txtNic;

    public void searchOnAction(ActionEvent actionEvent) {
        try {
            search();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void search() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute("SELECT * FROM Student WHERE student_id=?",txtId.getText());
        if (set.next()){
            txtName.setText(set.getString(2));
            txtEmail.setText(set.getString(3));
            txtContactNo.setText(set.getString(4));
            txtAddress.setText(set.getString(5));
            txtNic.setText(set.getString(6));
        } else {
            new Alert(Alert.AlertType.WARNING,"Empty Result!...").show();
        }
    }

    public void btnupdateOnAction(ActionEvent actionEvent) {
        Student s = new Student(txtId.getText(),txtName.getText(),txtEmail.getText(),txtContactNo.getText(),txtAddress.getText(),txtNic.getText());

        try {
            if(CrudUtil.execute("UPDATE Student SET student_name=?, email=?, contact=?, address=?, nic=? WHERE student_id=?",s.getStudent_name(),s.getEmail(),s.getContact(),s.getAddress(),s.getNic(),s.getStudent_id())){
                new Alert(Alert.AlertType.CONFIRMATION,"Student Updated!..").show();
            }
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
        cleaFields();
    }

    private void cleaFields(){
        txtId.setText(null);
        txtName.setText(null);
        txtEmail.setText(null);
        txtContactNo.setText(null);
        txtAddress.setText(null);
        txtNic.setText(null);
    }
}
