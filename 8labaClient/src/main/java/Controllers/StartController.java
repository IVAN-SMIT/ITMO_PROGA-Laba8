package Controllers;


import Scene.StartWindow;
import auxillary.Language2;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;



public class StartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backB;

    @FXML
    private Button enter2;

    @FXML
    private Button exit;

    @FXML
    private ChoiceBox<String> langb;

    @FXML
    private Button registr;

    @FXML
    void initialize() {
        Language2.addLanguage(langb);
        exit.setOnAction(actionEvent -> {
            System.exit(80085);
        });

        enter2.setOnAction(actionEvent -> {
            Stage stage = (Stage) enter2.getScene().getWindow();
            stage.close();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("loginWindow.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 640, 460);
                stage.setTitle("I1 collection");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        registr.setOnAction(actionEvent -> {
            Stage stage = (Stage) registr.getScene().getWindow();
            stage.close();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("RegWindow.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 640, 460);
                stage.setTitle("I1 collection");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        });


        assert backB != null : "fx:id=\"backB\" was not injected: check your FXML file 'loginWindow.fxml'.";
        assert enter2 != null : "fx:id=\"enter2\" was not injected: check your FXML file 'loginWindow.fxml'.";
        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'loginWindow.fxml'.";
        assert langb != null : "fx:id=\"langb\" was not injected: check your FXML file 'loginWindow.fxml'.";
        assert registr != null : "fx:id=\"registr\" was not injected: check your FXML file 'loginWindow.fxml'.";

    }

}
