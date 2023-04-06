package MinecraftMath.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

//From: https://stackoverflow.com/questions/71798618/cannot-resolve-symbol-webview-javafx-webview-with-maven-in-intellij-idea
//What worked for me after the code from above
//How did i get this to work?
//First: added dependency to pom.xml
//Add to ModuleInfo
//Then I clicked on the red error on line 18 or 22 (the ones that attempt to use webView) and then did the same thing again
//clicked add dependency and also add to module info
//then it worked after the import above
//Finally, I went to the youtube URL and copied the Embed String only

public class YouTubeViewer extends Application {
    public static void main(String[] args) { launch(args); }

    @Override public void start(Stage stage) throws Exception {
        WebView webview = new WebView();
        webview.getEngine().load(

                "https://www.youtube.com/embed/TMubSggUOVE" //be sure to get the YouTube embed URL
        );
        webview.setPrefSize(640, 390);
        stage.setScene(new Scene(webview));
        stage.show();
    }
}
