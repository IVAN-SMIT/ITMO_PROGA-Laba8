package Scene;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class StartWindow extends Application {
    public static Locale locale;
    public static ResourceBundle resourceBundle;

    @Override
    public void start (Stage stage) throws IOException {

        try {
            locale = new Locale("ru","AU");
            resourceBundle = ResourceBundle.getBundle("internationalization.Bundle", locale);
            FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("StartWindow.fxml"), resourceBundle);
            Scene scene = new Scene(fxmlLoader.load(), 640, 460);
            stage.setTitle("I1 collection");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e);
            System.exit(101);
            }
    }

    public static void main(String[] args) {
        launch();
    }
}