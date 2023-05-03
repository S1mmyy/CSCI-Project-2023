package MinecraftMath.files;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class LoginPageController extends MasterController {
    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessageLabel;

    @FXML
    private void loginWithTestUser() {
        setTestUserData();
        loadUserDataOntoScene();
        loginMessageLabel.setText("Welcome " + userHolder.getUser().getName() + "!");
        loginButton.setDisable(false);
    }

    public void setTestUserData() {
        InputStream inStream = getClass().getResourceAsStream("/MinecraftMath/assets/testuser.json");
        JSONTokener tokener = new JSONTokener(inStream);
        JSONObject userJSON = new JSONObject(tokener);

        userHolder.setUser(new User(userJSON.getString("name"), userJSON.getInt("grade"), userJSON.getInt("avatarNum")));
    }

    @FXML
    private void attemptLogin() throws Exception {
        successfulLogin();
    }

    private void successfulLogin() throws Exception {
        Stage stage;
        Parent root;

        stage = (Stage) loginButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void goRegister(ActionEvent actionEvent) {
    }
}
