package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Scene.StartWindow;
import auxillary.Authorization;
import auxillary.Language2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField PassField;

    @FXML
    private Button backB;

    @FXML
    private Text errLog;

    @FXML
    private Text errPass;

    @FXML
    private Text errUser;

    @FXML
    private ChoiceBox<String> langb;

    @FXML
    private TextField logField;

    @FXML
    private Button registr;

    @FXML
    void initialize() {

        registr.setOnAction(actionEvent -> {
            if (!PassField.getText().equals("") && !logField.getText().equals("")) {
                errPass.setVisible(false);
                errLog.setVisible(false);
                System.out.println(logField.getText() + PassField.getText());
                try {
                    String login = Authorization.authorization(logField.getText(), PassField.getText());
                    if (login.equals("успех")) {
                        try {
                            errPass.setVisible(false);
                            errLog.setVisible(false);
                            System.out.println("Зарегался " + logField.getText() + " " + PassField.getText());
                            Stage stage = (Stage) registr.getScene().getWindow();
                            stage.close();
                            FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("window.fxml"));
                            Scene scene = new Scene(fxmlLoader.load(), 640, 452);
                            stage.setTitle("I1 collection");
                            stage.setResizable(false);
                            stage.setScene(scene);
                            stage.show();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else if (login.equals("ошибка")) {

                        show(errUser,"Ошибка");
                        System.out.println("Ошибка");

                    } else if (login.equals("занято")) {

                        show(errUser, "Такой пользователь уже существует");
                        System.out.println("Такой пользователь уже существует");

                    }else if (login.equals("Cервер не найден") | login.equals("потеря соединения")){

                        show(errUser, "Cервер не найден");
                        System.out.println("Cервер не найден");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (logField.getText().equals("")) {
                errPass.setVisible(false);
                errLog.setVisible(true);
            } else if (PassField.getText().equals("")) {
                errLog.setVisible(false);
                errPass.setVisible(true);
            } else if (PassField.getText().equals("") && logField.getText().equals("")) {
                errPass.setVisible(true);
                errLog.setVisible(true);
            }
        });

        backB.setOnAction(actionEvent -> {
            Stage stage = (Stage) backB.getScene().getWindow();
            stage.close();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("StartWindow.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 640, 460);
                stage.setTitle("I1 collection");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            }catch (Exception e){
                System.out.println(e);}
        });

        Language2.addLanguage(langb);

        assert PassField != null : "fx:id=\"PassField\" was not injected: check your FXML file 'loginWindow.fxml'.";
        assert backB != null : "fx:id=\"backB\" was not injected: check your FXML file 'loginWindow.fxml'.";
        assert registr != null : "fx:id=\"enter\" was not injected: check your FXML file 'loginWindow.fxml'.";
        assert langb != null : "fx:id=\"langb\" was not injected: check your FXML file 'loginWindow.fxml'.";
        assert logField != null : "fx:id=\"logField\" was not injected: check your FXML file 'loginWindow.fxml'.";
        assert errLog != null : "fx:id=\"errLog\" was not injected: check your FXML file 'loginWindow.fxml'.";
        assert errPass != null : "fx:id=\"errPass\" was not injected: check your FXML file 'loginWindow.fxml'.";

    }
    void show(Text button, String mess){
        button.setVisible(false);
        button.setText(mess);
        button.setVisible(true);

        if(mess == null){
            button.setVisible(false);
            button.setVisible(true);
        }
    }
























































        /*
        registr.setOnAction(actionEvent -> {
            if (!PassField.getText().equals("") && !logField.getText().equals("")) {
                errPass.setVisible(false);
                errLog.setVisible(false);
                System.out.println("Зарегался " + logField.getText() + " " + PassField.getText());
                Stage stage = (Stage) registr.getScene().getWindow();
                stage.close();
                try {
                    Authorization.authorization(logField.getText(), PassField.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("window.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 640, 460);
                    stage.setTitle("I1 collection");
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.show();
                }catch (Exception e){
                    e.printStackTrace();}
            } else if (logField.getText().equals("")) {
                errPass.setVisible(false);
                errLog.setVisible(true);
            } else if (PassField.getText().equals("")) {
                errLog.setVisible(false);
                errPass.setVisible(true);
            } else if (PassField.getText().equals("") && logField.getText().equals("")) {
                errPass.setVisible(true);
                errLog.setVisible(true);
            }
            errUser.setVisible(true);
        });
        backB.setOnAction(actionEvent -> {
            Stage stage = (Stage) backB.getScene().getWindow();
            stage.close();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("StartWindow.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 640, 460);
                stage.setTitle("I1 collection");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            }catch (Exception e){
                System.out.println(e);}
        });
        Language2.addLanguage(langb);
        assert PassField != null : "fx:id=\"PassField\" was not injected: check your FXML file 'RegWindow.fxml'.";
        assert backB != null : "fx:id=\"backB\" was not injected: check your FXML file 'RegWindow.fxml'.";
        assert errLog != null : "fx:id=\"errLog\" was not injected: check your FXML file 'RegWindow.fxml'.";
        assert errPass != null : "fx:id=\"errPass\" was not injected: check your FXML file 'RegWindow.fxml'.";
        assert errUser != null : "fx:id=\"errUser\" was not injected: check your FXML file 'RegWindow.fxml'.";
        assert langb != null : "fx:id=\"langb\" was not injected: check your FXML file 'RegWindow.fxml'.";
        assert logField != null : "fx:id=\"logField\" was not injected: check your FXML file 'RegWindow.fxml'.";
        assert registr != null : "fx:id=\"registr\" was not injected: check your FXML file 'RegWindow.fxml'.";


         */
    }


