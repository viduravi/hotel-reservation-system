package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dto.customer_info_DTO;
import model.dto.staff_info_DTO;

public class add_staff_controller {

    public TextField txtId;
    public TextField txtName;
    public TextField txtRole;
    public TextField txtEmail;
    public TextField txtPhone;
    public TextField txtSalary;
    public Button btnSave;
    public Button btnCancel;

    public void saveStaffAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String role = txtRole.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        Double salary = Double.parseDouble(txtSalary.getText());

        if (id == null || name == null || role == null || email == null || phone == null || salary==null) {
            new Alert(Alert.AlertType.WARNING, "Please fill in all fields!").show();
            return;
        }

        staff_info_DTO newMember = new staff_info_DTO(id, name, role, email, phone, salary);
        staff_info_controller.addStaff(newMember);

        Stage stage = (Stage) btnSave.getScene().getWindow();
        stage.close();
    }

    public void cancelAction(ActionEvent actionEvent) {

    }
}
