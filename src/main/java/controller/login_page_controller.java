package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class login_page_controller {

    public PasswordField txtPassword;
    public TextField txtUserName;
    public javafx.scene.control.Button txtLogin;

    private static final String Name = "admin";
    private static final String pw = "1234";

    public void loginAction(ActionEvent actionEvent) {
        Stage stage = (Stage) txtLogin.getScene().getWindow();
        String username = txtUserName.getText();
        String password = txtPassword.getText();

        if (isCorrect(username, password)) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/Home_page.fxml"));
                stage.setScene(new Scene(root));
                stage.setTitle("Dashboard");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("succesfull");
                alert.setContentText("login Succesfull");
                alert.showAndWait();

                txtUserName.clear();
                txtPassword.clear();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("error");
            alert.setContentText("user name password incorrect");
            alert.setHeaderText(null);
            alert.showAndWait();
            txtUserName.clear();
            txtPassword.clear();
        }
    }

    private boolean isCorrect(String username, String password) {
        return username.equals(Name) && password.equals(pw);
    }

    public void passwordEnterAction(ActionEvent actionEvent) {
        loginAction(actionEvent);
    }
}
