package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterPageController extends MasterController {
    @FXML
    private TextField firstNameField, lastNameField, passwordField, passwordConfirmField;
    @FXML
    private Button landingButton, registerButton, backToLoginButton;
    @FXML
    private ComboBox gradeSelect, avatarSelect;
    @FXML
    private Label loginMessageLabel;

    @FXML
    private void attemptRegister() throws Exception {
        // Is any field blank
        if (firstNameField.getText().isBlank() || lastNameField.getText().isBlank() || passwordField.getText().isBlank() || passwordConfirmField.getText().isBlank() || gradeSelect.getSelectionModel().isEmpty() || avatarSelect.getSelectionModel().isEmpty()) {
            loginMessageLabel.setText("Please fill in all text boxes.");
        }
        // Are the name entries valid
        else if (!firstNameField.getText().matches("^[a-zA-Z]+$") || !lastNameField.getText().matches("^[a-zA-Z]+$")) {
            loginMessageLabel.setText("Names can only contain letters.");
        }
        // Is the password valid
        else if (!passwordField.getText().matches("^[a-zA-Z0-9]+$")) {
            loginMessageLabel.setText("Passwords can only contain letters and numbers.");
        }
        // Do password field entries match
        else if (!passwordField.getText().equals(passwordConfirmField.getText())) {
            loginMessageLabel.setText("Passwords do not match.");
        }
        // Does an account with that name exist
        else if (doesUserAlreadyExist()) {
            loginMessageLabel.setText("A user with that name already exists.");
        }
        else {
            successfulRegister();
        }
    }

    private boolean doesUserAlreadyExist() throws SQLException {
        String doesUserExistQuery = "SELECT count(1) FROM user_account WHERE name = '" + firstNameField.getText() + lastNameField.getText() + "'";
        statement = connectDB.createStatement();
        ResultSet results = statement.executeQuery(doesUserExistQuery);
        results.next();
        // query results in a 1-cell table that is either a 0 or a 1
        return results.getInt(1) == 1;
    }

    private void successfulRegister() throws SQLException {
        User newUser = generateNewUser();
        String userFields = "'" + newUser.getName() + "'," + newUser.getGrade() + "," + newUser.getAvatarNum() + ",'" + passwordField.getText() + "'";
        String addUserUpdate = "INSERT INTO user_account(name, grade, avatar_num, password) VALUES (" + userFields + ")";
        statement = connectDB.createStatement();
        statement.executeUpdate(addUserUpdate);

        userHolder.setUser(newUser);
        loadUserDataOntoScene();
        loginMessageLabel.setText("Created account for " + userHolder.getUser().getName() + "!");
        backToLoginButton.setDisable(true);
        registerButton.setDisable(true);
        landingButton.setVisible(true);
    }

    private User generateNewUser()
    {
        String firstName = firstNameField.getText().substring(0,1).toUpperCase() + firstNameField.getText().substring(1);
        String lastName = lastNameField.getText().substring(0,1).toUpperCase() + lastNameField.getText().substring(1);
        int grade = gradeSelect.getSelectionModel().getSelectedIndex();
        int avatarNum = avatarSelect.getSelectionModel().getSelectedIndex();
        return new User(firstName+lastName, grade, avatarNum, 1, 0.0);
    }

    @FXML
    private void goLogin() throws Exception {
        Stage stage = (Stage) registerButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void goLanding() throws Exception {
        Stage stage = (Stage) landingButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
