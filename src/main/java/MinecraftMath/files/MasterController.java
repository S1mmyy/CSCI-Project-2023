package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.sql.*;

// Controller for methods that all/multiple scenes will have access to
public class MasterController implements Initializable {
    public UserHolder userHolder = UserHolder.getInstance();
    public ArrayList<Image> avatarList = new ArrayList<>() {};

    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();
    Statement statement;

    @FXML
    protected ImageView avatarLoc;
    @FXML
    protected Label nameLabel;

    public MasterController() {
        String urlStub = "/MinecraftMath/assets/avatars/";
        avatarList.add(new Image(getClass().getResource(urlStub + "Steve.png").toString()));
        avatarList.add(new Image(getClass().getResource(urlStub + "Alex.png").toString()));
        avatarList.add(new Image(getClass().getResource(urlStub + "Pig.png").toString()));
        avatarList.add(new Image(getClass().getResource(urlStub + "Zombie.png").toString()));
        avatarList.add(new Image(getClass().getResource(urlStub + "Creeper.png").toString()));
        avatarList.add(new Image(getClass().getResource(urlStub + "Enderman.png").toString()));
    }

    @FXML
    public void loadUserDataOntoScene() {
        User currUser = userHolder.getUser();
        avatarLoc.setImage(avatarList.get(currUser.getAvatarNum()));
        nameLabel.setText(currUser.getName());
    }

    @FXML
    private void exitAction() {
        System.exit(1);
    }

    // empty initialize method so all controllers can implement their own
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
