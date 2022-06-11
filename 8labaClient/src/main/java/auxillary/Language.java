package auxillary;

import Scene.StartWindow;
import javafx.scene.control.ChoiceBox;

import java.util.Locale;
import java.util.ResourceBundle;


public class Language {
    public static void addLanguage(ChoiceBox<String> langb) {
        langb.getItems().add("Русский");
        langb.getItems().add("English");
        langb.getItems().add("Français");
        langb.getItems().add("Español");
    }

    public  void changeLanguage(String langb){
        switch (langb) {
            case "English":
                StartWindow.locale = new Locale("en", "AU");
                StartWindow.resourceBundle = ResourceBundle.getBundle("internationalization.Bundle", StartWindow.locale);
                break;
            case "Français":
                StartWindow.locale = new Locale("fr", "AU");
                StartWindow.resourceBundle = ResourceBundle.getBundle("internationalization.Bundle", StartWindow.locale);
                break;
            case "Español":
                StartWindow.locale = new Locale("es", "AU");
                StartWindow.resourceBundle = ResourceBundle.getBundle("internationalization.Bundle", StartWindow.locale);
                break;
            case "Русский":
                StartWindow.locale = new Locale("ru", "AU");
                StartWindow.resourceBundle = ResourceBundle.getBundle("internationalization.Bundle", StartWindow.locale);
                break;
        }
    }
}
