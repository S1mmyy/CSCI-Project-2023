package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class TitlePageController extends MasterController {
    @FXML
    public Button testLoginButton;

    @FXML
    private void loginWithTestUser() {
        setTestUserData();
        loadUserDataOntoScene();
        landingButton.setDisable(false);
    }

    public void setTestUserData() {
        InputStream inStream = getClass().getResourceAsStream("/MinecraftMath/assets/testuser.json");
        JSONTokener tokener = new JSONTokener(inStream);
        JSONObject userJSON = new JSONObject(tokener);

        userHolder.setUser(new User(userJSON.getString("name"), userJSON.getInt("grade"), userJSON.getInt("avatarNum")));
    }

    @FXML
    private Button landingButton;

    @FXML
    private void landingAction() throws Exception {
        Stage stage;
        Parent root;

        stage = (Stage) landingButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
