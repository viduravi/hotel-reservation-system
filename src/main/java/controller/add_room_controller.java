package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.dto.room_info_DTO;

public class add_room_controller {

    @FXML
    public TextArea txtDescription;

    @FXML
    public TextField txtRoomID;

    @FXML
    private ComboBox<String> cmbType;

    @FXML
    private TextField txtPrice;

    @FXML
    private Button btnSave, btnCancel;

    @FXML
    public void saveRoomAction(ActionEvent event) {
        String id = txtRoomID.getText();
        String type = cmbType.getValue();
        String availability = cmbType.getValue();
        String price = txtPrice.getText();

        if (id.isEmpty() || type == null || availability == null || price.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please fill in all fields!").show();
            return;
        }

        room_info_DTO newRoom = new room_info_DTO(id, type, availability, price);
        room_info_controller.addRoomToList(newRoom);

        Stage stage = (Stage) btnSave.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void cancelAction(ActionEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
