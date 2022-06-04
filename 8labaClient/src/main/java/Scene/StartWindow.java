package Scene;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class StartWindow extends Application {

    @Override
    public void start (Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("StartWindow.fxml"));
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