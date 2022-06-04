package auxillary;
/*

вячеслав воронин спасибо за детство

import Controllers.Login;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

import java.util.ResourceBundle;
import java.util.Locale;
import javafx.scene.Parent;

public class Language implements EventHandler<ActionEvent> {
    private Label language = new Label("Language");
    private Button ru = new Button("Русский");
    private Button nl = new Button("Nederlands");
    private Button fr = new Button("Français");
    private Button es = new Button("Español");

    public Scene getInitialScene() {
        ru.setOnAction(this);
        nl.setOnAction(this);
        fr.setOnAction(this);
        es.setOnAction(this);

        VBox placement = new VBox(10);
        placement.setAlignment(Pos.CENTER);

        placement.getChildren().add(language);
        placement.getChildren().add(ru);
        placement.getChildren().add(nl);
        placement.getChildren().add(fr);
        placement.getChildren().add(es);

        Scene initial_scene = new Scene(placement);
        return initial_scene;
    }

    public Parent getLanguageChoice() {
        ru.setOnAction(this);
        nl.setOnAction(this);
        fr.setOnAction(this);
        es.setOnAction(this);

        VBox placement = new VBox(10);
        placement.setAlignment(Pos.CENTER);

        placement.getChildren().add(language);
        placement.getChildren().add(ru);
        placement.getChildren().add(nl);
        placement.getChildren().add(fr);
        placement.getChildren().add(es);

        return placement;
    }

    @Override
    public void handle(ActionEvent event) {
        //language.getString("back")
        ResourceBundle lang = null;
        if (event.getSource() == ru) {
            Locale locale = new Locale("ru", "RU");
            lang = ResourceBundle.getBundle("internationalization.language", locale);
        } else if (event.getSource() == nl) {
            Locale locale = new Locale("nl", "NL");
            lang = ResourceBundle.getBundle("internationalization.language", locale);
        } else if (event.getSource() == fr) {
            Locale locale = new Locale("fr", "FR");
            lang = ResourceBundle.getBundle("internationalization.language", locale);
        } else if (event.getSource() == es) {
            Locale locale = new Locale("es", "ES");
            lang = ResourceBundle.getBundle("internationalization.language", locale);
        }
        Login login = new Login(lang);
        ru.getScene().setRoot(login.getLogin());
    }
}


 */