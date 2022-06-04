package auxillary;

import javafx.scene.control.ChoiceBox;

public class Language2 {
    public static void addLanguage(ChoiceBox<String> langb) {
        langb.getItems().add("Русский");
        langb.getItems().add("Nederlands");
        langb.getItems().add("Français");
        langb.getItems().add("Español");
    }
}
