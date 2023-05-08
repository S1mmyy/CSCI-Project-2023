package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterPageController extends MasterController {
    @FXML
    private TextField firstNameField, lastNameField, passwordField, passwordConfirmField;
    @FXML
    private Button landingButton, registerButton;
    @FXML
    private Label loginMessageLabel;

    @FXML
    private void attemptRegister() throws Exception {
        if (checkRegisterInfo()) {
            validateRegister();
        }
        else {
            loginMessageLabel.setText("Fill in all text boxes with valid info.");
        }
    }

    private boolean checkRegisterInfo() {
        boolean isInfoValid = false;
        if (!firstNameField.getText().isBlank() && !passwordField.getText().isBlank()) {
            //isInfoValid = true;
        }
        return isInfoValid;
    }

    private void validateRegister() throws SQLException {
        String doesUserExistQuery = "SELECT count(1) FROM user_account WHERE name = '" + firstNameField.getText() + lastNameField.getText() + "'";
        Statement statement = connectDB.createStatement();
        ResultSet results = statement.executeQuery(doesUserExistQuery);

        while (results.next()) {
            if (results.getInt(1) == 0) {
                successfulRegister();
            }
            else {
                loginMessageLabel.setText("User already exists");
            }
        }
    }

    private void successfulRegister() throws SQLException {
        String newUserName = firstNameField.getText() + lastNameField.getText();
        String addUserQuery = "SELECT name, grade, avatar_num FROM user_account WHERE name = '" + newUserName + "' AND password = '" + passwordField.getText() + "'";
        Statement statement = connectDB.createStatement();
        ResultSet results = statement.executeQuery(addUserQuery);
        results.next();

        userHolder.setUser(new User(results.getString(1), results.getInt(2), results.getInt(3)));
        loadUserDataOntoScene();
        loginMessageLabel.setText("Welcome " + userHolder.getUser().getName() + "!");
        landingButton.setVisible(true);
    }

    @FXML
    private void goLogin() throws Exception {
        Stage stage;
        Parent root;

        stage = (Stage) registerButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
