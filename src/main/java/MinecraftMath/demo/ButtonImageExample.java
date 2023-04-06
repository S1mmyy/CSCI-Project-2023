package MinecraftMath.demo;

//modified from the following
// icon license: (creative commons with attribution) http://creativecommons.org/licenses/by-nc-nd/3.0/
// icon artist attribution page: (eponas-deeway) http://eponas-deeway.deviantart.com/gallery/#/d1s7uih
//replacement image from: https://dribbble.com/designbolts
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonImageExample extends Application {
    @Override public void start(final Stage stage) throws Exception {
        final Label response = new Label();
        final ImageView imageView = new ImageView(
                //new Image("http://icons.iconarchive.com/icons/eponas-deeway/colobrush/128/heart-2-icon.png")
                new Image("https://icons.iconarchive.com/icons/designbolts/free-valentine-heart/256/Hearts-icon.png")
                //replacement image from: https://dribbble.com/designbolts
        );
        final Button button = new Button("I love you", imageView);
        button.setStyle("-fx-base: pink;");
        button.setContentDisplay(ContentDisplay.TOP);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                response.setText("I love you too!");
                response.setStyle("-fx-text-fill:white; -fx-padding: 10; -fx-font-size: 20;");
            }
        });

        final VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(button, response);
        layout.setStyle("-fx-background-color: slategray; -fx-padding: 10; -fx-font-size: 20;");
        stage.setScene(new Scene(layout));
        stage.show();
    }
    public static void main(String[] args) { launch(args); }
}
