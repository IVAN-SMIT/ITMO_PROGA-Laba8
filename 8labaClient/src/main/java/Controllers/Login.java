package Controllers;
/*

вячеслав воронин спасибо за детство


import auxillary.Language;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import connection.*;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Login implements EventHandler<ActionEvent> {
    private Label login_text;
    private Label wrong_pass;
    private Button back;
    private TextField username;
    private PasswordField password;
    private Button login;
    private ResourceBundle lang;

    public Login(ResourceBundle lang) {
        this.lang = lang;
    }

    public static String encryptThisString(String input) {
        try {
            // getInstance() method is called with algorithm SHA-384
            MessageDigest md = MessageDigest.getInstance("SHA-384");

            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public Parent getLogin() {
        back = new Button(lang.getString("back"));
        login_text = new Label(lang.getString("login"));
        username = new TextField();
        username.setMaxWidth(150);
        username.setPromptText("Login");
        password = new PasswordField();
        password.setMaxWidth(150);
        password.setPromptText("Password");
        login = new Button(lang.getString("login"));
        wrong_pass = new Label(lang.getString("wrong_pass"));
        wrong_pass.setVisible(false);

        back.setOnAction(this);
        login.setOnAction(this);

        VBox placement = new VBox(10);
        placement.setAlignment(Pos.CENTER);

        placement.getChildren().add(login_text);
        placement.getChildren().add(username);
        placement.getChildren().add(password);
        placement.getChildren().add(wrong_pass);
        placement.getChildren().add(login);
        placement.getChildren().add(back);

        return placement;
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == back) {
            Language lang_choice = new Language();
            back.getScene().setRoot(lang_choice.getLanguageChoice());
        } else if (event.getSource() == login && !username.getText().equals("")) {
            String username_s = username.getText();
            String password_s = password.getText();
            password_s = encryptThisString(password_s);

            connectionManager client = null;
            try {
                client = new connectionManager("localhost", 9890);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String result = client.sendMessage(new Request("auth", username_s, password_s)).gettextResponse();
            if (!result.equals("WRONG_PASS")) {
                CollectionManager collectionManager = new CollectionManager(lang, username_s, password_s, client);
                back.getScene().setRoot(collectionManager.getCollectionManager("show"));
            } else {
                wrong_pass.setVisible(true);
            }
        }
    }
}

 */
