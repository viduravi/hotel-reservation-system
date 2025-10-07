package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class home_page_controller {

    public Button btnRoomInfo;

    public void roomAction(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/room_info.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Room Information");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logOutAction(ActionEvent actionEvent) {

        try {
            Stage currentStage = (Stage) ((Node) actionEvent .getSource()).getScene().getWindow();
            currentStage.close();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("/view/Login_page.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Login Page");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
