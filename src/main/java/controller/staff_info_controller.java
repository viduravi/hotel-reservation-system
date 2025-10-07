package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.staff_info_DTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class staff_info_controller implements Initializable {

    @FXML
    private TableView<staff_info_DTO> staffTable;
    @FXML
    private TableColumn<staff_info_DTO, String> colId;
    @FXML
    private TableColumn<staff_info_DTO, String> colName;
    @FXML
    private TableColumn<staff_info_DTO, String> colRole;
    @FXML
    private TableColumn<staff_info_DTO, String> colEmail;
    @FXML
    private TableColumn<staff_info_DTO, String> colPhone;
    @FXML
    private TableColumn<staff_info_DTO, Double> colSalary;
    @FXML
    private Button btnAdd, btnEdit, btnDelete, btnHome;

    private static final ObservableList<staff_info_DTO> staffList = FXCollections.observableArrayList(
            new staff_info_DTO("S001", "Kamal", "Waiter", "kamal@hotel.com", "9876543210", 2500.0),
            new staff_info_DTO("S002", "Alice Smith", "Receptionist", "alice@example.com", "9123456789", 3000.0),
            new staff_info_DTO("S003", "John Doe", "Manager", "john.doe@hotel.com", "9345678123", 5000.0),
            new staff_info_DTO("S004", "Ravi Kumar", "Chef", "ravi.kumar@hotel.com", "9564781230", 4000.0)
    );

    public static void addStaff(staff_info_DTO newMember) {
        staffList.add(newMember);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        staffTable.setItems(staffList);
    }

    Stage stage = new Stage();

    public void addStaffAction() {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/add_staff.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    public void editStaffAction() {

    }

    public void deleteStaffAction() {
        staff_info_DTO selected = staffTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            staffList.remove(selected);
            staffTable.refresh();
        } else {
            new Alert(Alert.AlertType.WARNING, "Please select a staff member to delete.").show();
        }
    }

    public void backToHomeAction() {
        Stage currStage = (Stage) btnHome.getScene().getWindow();
        currStage.close();
    }
}
