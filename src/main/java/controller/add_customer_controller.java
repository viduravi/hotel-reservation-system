package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dto.customer_info_DTO;
import model.dto.room_info_DTO;

public class add_customer_controller {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private TextArea txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    void cancelAction(ActionEvent event) {

    }

    @FXML
    void saveCustomerAction(ActionEvent event) {
        String id = txtCustomerId.getText();
        String name = txtName.getText();
        String phone = txtPhone.getText();
        String city = txtCity.getText();
        String address = txtAddress.getText();

        if (id==null || name == null || phone == null || city==null || address==null) {
            new Alert(Alert.AlertType.WARNING, "Please fill in all fields!").show();
            return;
        }

        customer_info_DTO newCustomer = new customer_info_DTO(id, name, phone, city, address);
        customer_info_controller.addCustomerList(newCustomer);

        Stage stage = (Stage) btnSave.getScene().getWindow();
        stage.close();
    }

}
