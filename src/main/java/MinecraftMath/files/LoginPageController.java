package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginPageController extends MasterController {
    @FXML
    private TextField nameField, passwordField;
    @FXML
    private Button loginButton, landingButton, registerButton;
    @FXML
    private Label loginMessageLabel;

    @FXML
    private void attemptLogin() throws Exception {
        if (!nameField.getText().isBlank() && !passwordField.getText().isBlank()) {
            validateLogin();
        }
        else {
            loginMessageLabel.setText("Enter a username and password");
        }
    }

    private void validateLogin() throws SQLException {
        String loginQuery = "SELECT count(1) FROM user_account WHERE name = '" + nameField.getText() + "' AND password = '" + passwordField.getText() + "'";
        statement = connectDB.createStatement();
        ResultSet results = statement.executeQuery(loginQuery);

        while (results.next()) {
            if (results.getInt(1) == 1) {
                successfulLogin();
            }
            else {
                loginMessageLabel.setText("Invalid login");
            }
        }
    }

    private void successfulLogin() throws SQLException {
        String userDataQuery = "SELECT name, grade, avatar_num FROM user_account WHERE name = '" + nameField.getText() + "' AND password = '" + passwordField.getText() + "'";
        statement = connectDB.createStatement();
        ResultSet results = statement.executeQuery(userDataQuery);
        results.next();

        userHolder.setUser(new User(results.getString(1), results.getInt(2), results.getInt(3)));
        loadUserDataOntoScene();
        loginMessageLabel.setText("Welcome " + userHolder.getUser().getName() + "!");
        landingButton.setVisible(true);
    }

    @FXML
    private void goLanding() throws Exception {
        Stage stage;
        Parent root;

        stage = (Stage) loginButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void goRegister() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) registerButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("RegisterPage.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
