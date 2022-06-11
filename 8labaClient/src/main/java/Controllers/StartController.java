package Controllers;


import Scene.StartWindow;
import auxillary.Language;
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
        Language.addLanguage(langb);

        exit.setOnAction(actionEvent -> {
            System.exit(80085);
        });

        enter2.setOnAction(actionEvent -> {
            Stage stage = (Stage) enter2.getScene().getWindow();
            stage.close();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("loginWindow.fxml"), StartWindow.resourceBundle);
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
                FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("RegWindow.fxml"),StartWindow.resourceBundle);
                Scene scene = new Scene(fxmlLoader.load(), 640, 460);
                stage.setTitle("I1 collection");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        langb.setOnAction(actionEvent -> {new Language().changeLanguage(langb.getValue());
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("StartWindow.fxml"), StartWindow.resourceBundle);
                Scene scene = new Scene(fxmlLoader.load(), 640, 460);
                Stage stage = (Stage) langb.getScene().getWindow();
                stage.close();
                stage.setTitle("I1 collection");
                stage.setResizable(false);stage.setScene(scene);stage.show();
            }catch (Exception e){System.out.println(e);}
        });

    }
}


