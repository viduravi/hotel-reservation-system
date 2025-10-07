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
import model.dto.customer_info_DTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class customer_info_controller implements Initializable {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnHome;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCusId;

    @FXML
    private TableColumn<?, ?> colCusName;

    @FXML
    private TableColumn<?, ?> colPhoneNo;

    @FXML
    private TableView<customer_info_DTO> customerTabel;

    Stage stage = new Stage();

    public static void addCustomerList(customer_info_DTO newCustomer) {
        customerInfoDtos.add(newCustomer);
    }

    @FXML
    void addCustomerAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/add_customer.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    private static final ObservableList<customer_info_DTO> customerInfoDtos = FXCollections.observableArrayList(
            new customer_info_DTO("C001", "kamal", "0752364785", "kandy", "cvbnyui"),
            new customer_info_DTO("C0020", "nimal", "0725896478", "panadura", "sdfghjhgf"),
            new customer_info_DTO("C003", "Bimal", "0757896541", "Galle", "dfghhgrewd")
    );

    @FXML
    void backToHomeAction(ActionEvent event) {
        Stage currStage = (Stage) btnAdd.getScene().getWindow();
        currStage.close();
    }

    @FXML
    void deleteCustomerAction(ActionEvent event) {
        customer_info_DTO selectCustomerInfoDto = customerTabel.getSelectionModel().getSelectedItem();
        customerInfoDtos.remove(selectCustomerInfoDto);
        customerTabel.setItems(customerInfoDtos);
        customerTabel.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCusId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCusName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        customerTabel.setItems(customerInfoDtos);
    }
}
