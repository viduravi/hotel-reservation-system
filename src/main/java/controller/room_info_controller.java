package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.room_info_DTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class room_info_controller implements Initializable {

    @FXML
    private TableView<room_info_DTO> roomTable;

    @FXML
    private TableColumn<room_info_DTO, String> colRoomNumber;

    @FXML
    private TableColumn<room_info_DTO, String> colType;

    @FXML
    private TableColumn<room_info_DTO, String> colAvailability;

    @FXML
    private TableColumn<room_info_DTO, String> colPrice;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    private static final ObservableList<room_info_DTO> roomInfoDtos = FXCollections.observableArrayList(
            new room_info_DTO("R001", "Single", "Available", "200$"),
            new room_info_DTO("R002", "Double", "Occupied", "50$"),
            new room_info_DTO("R003", "Suite", "Available", "100$"),
            new room_info_DTO("R004", "Deluxe", "Maintenance", "250$")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colRoomNumber.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("price"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("description"));

        roomTable.setItems(roomInfoDtos);
    }

    public static void addRoomToList(room_info_DTO newRoom) {
        roomInfoDtos.add(newRoom);
    }

    public void bacToHomeAction(ActionEvent actionEvent) {
        Stage currStage = (Stage) btnAdd.getScene().getWindow();
        currStage.close();
    }

    public void addRoomAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/add_room.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Add Room");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void roomDeleteAction(ActionEvent actionEvent) {
        room_info_DTO selectRoomInfoDto = roomTable.getSelectionModel().getSelectedItem();
        roomInfoDtos.remove(selectRoomInfoDto);
        roomTable.setItems(roomInfoDtos);
        roomTable.refresh();
    }
}
