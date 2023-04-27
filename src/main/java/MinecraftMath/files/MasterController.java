package MinecraftMath.files;

import javafx.fxml.FXML;

// Controller for methods that all/multiple scenes will need to use
public class MasterController {
    protected User currUser;

    @FXML
    private void exitAction() {
        System.exit(1);
    }
}
