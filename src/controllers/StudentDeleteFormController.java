package controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDeleteFormController {

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

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            if(CrudUtil.execute("DELETE FROM Student WHERE student_id=?",txtId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION,"Student Deleted...").show();
            } else {
                new Alert(Alert.AlertType.WARNING,"Try Again...").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        cleaFields();
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

    private void cleaFields(){
        txtId.setText(null);
        txtName.setText(null);
        txtEmail.setText(null);
        txtContactNo.setText(null);
        txtAddress.setText(null);
        txtNic.setText(null);
    }
}
