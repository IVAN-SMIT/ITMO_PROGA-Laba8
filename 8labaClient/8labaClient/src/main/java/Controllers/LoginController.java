package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Scene.StartWindow;
import auxillary.Authorization;
import auxillary.Language2;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField PassField;

    @FXML
    private Button backB;

    @FXML
    private Text visibleButton;

    @FXML
    private Text errLog;

    @FXML
    private Text errPass;

    @FXML
    private Text errEnter;

    @FXML
    private Button enter;

    @FXML
    private ChoiceBox<String> langb;

    @FXML
    private TextField logField;

    public static String username;
    public static String password;

    @FXML
    void initialize() {


        enter.setOnAction(actionEvent -> {
            if (!PassField.getText().equals("") && !logField.getText().equals("")) {
                errPass.setVisible(false);
                errLog.setVisible(false);
                    try {
                        String login = Authorization.login(logField.getText(), PassField.getText());
                        if (login.equals("вход")) {
                            try {
                                errPass.setVisible(false);
                                errLog.setVisible(false);
                                System.out.println("Вошел " + logField.getText() + " " + PassField.getText());

                                setUsername(logField.getText());
                                setPassword(Authorization.getPassword());

                                Stage stage = (Stage) enter.getScene().getWindow();
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
                        } else if (login.equals("не пароль")) {

                            show(errEnter,"Неверный пароль");
                            System.out.println("неверный пароль");

                        } else if (login.equals("не существует")) {

                            show(errEnter, "Такого пользователя не существует");
                            System.out.println("Такого пользователя не существует");

                        }else if (login.equals("Cервер не найден") | login.equals("потеря соединения")){

                            show(errEnter, "Cервер не найден");
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
        assert enter != null : "fx:id=\"enter\" was not injected: check your FXML file 'loginWindow.fxml'.";
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
     public String getUsername(){return username;}
     public void setUsername(String username){this.username = username;}

    public String getPassword(){return password;}
    public void setPassword(String pass){this.password = pass;}
}

