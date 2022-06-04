package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import auxillary.Authorization;
import auxillary.City;
import auxillary.Language2;
import connection.Request;
import connection.Response;
import connection.connectionManager;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import static Controllers.LoginController.password;
import static Controllers.LoginController.username;
import static connection.connectionManager.answer;
import static connection.connectionManager.client;

public class WindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addb;

    @FXML
    private Button b3137;

    @FXML
    private ChoiceBox<String> choseUser;

    @FXML
    private Button clearb;

    @FXML
    private Button exitb;

    @FXML
    private Button filterCarCodeb;

    @FXML
    private CheckBox gayChecker;

    @FXML
    private Button helpb;

    @FXML
    private Button historyb;

    @FXML
    private Button infob;

    @FXML
    private Button insertAtb;

    @FXML
    private ChoiceBox<String> langb;

    @FXML
    private Button removeClimateb;

    @FXML
    private Button removeIDb;

    @FXML
    private Button removeLastB;

    @FXML
    private Button showb;

    @FXML
    private Button shuffleb;

    @FXML
    private Button updateb;

    @FXML
    private Text console;

    @FXML
    private ScrollPane scrolleeeeer;

    @FXML
    private RadioButton map;

    @FXML
    private RadioButton table;

    @FXML
    private Canvas graphic;

    @FXML
    void initialize() {

        scrolleeeeer.setVisible(false);

        exitb.setOnAction(actionEvent -> {System.exit(101);});

        helpb.setOnAction(actionEvent -> {
            scrolleeeeer.setVisible(true);
            console.setVisible(false);
            Authorization.client.sendMessage(new Request("help", username, password));
            console.setText(answer);
            console.setVisible(true);
        });
        infob.setOnAction(actionEvent -> {
            scrolleeeeer.prefHeight(100);
            scrolleeeeer.setVisible(true);
            console.setVisible(false);
            Authorization.client.sendMessage(new Request("info", username, password));
            console.setText(answer);

            console.setVisible(true);
        });
        historyb.setOnAction(actionEvent -> {
            scrolleeeeer.setVisible(true);
            Authorization.client.sendMessage(new Request("history",username, password));
            console.setText(answer);
            console.setVisible(true);
        });
        showb.setOnAction(actionEvent -> {
            try {
                scrolleeeeer.setVisible(true);
                table.fire();
                Authorization.client.sendMessage(new Request("show", username, password));
                console.setText(answer);
                console.setVisible(true);
                Stack<City> cityCollection = new CollectionManager().setCityCollection(answer);
                System.out.println("\n\n"+cityCollection);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e);
            }
        });
        shuffleb.setOnAction(actionEvent -> {
            scrolleeeeer.setVisible(true);
            Authorization.client.sendMessage(new Request("shuffle", username, password));
            console.setText(answer);
            console.setVisible(true);
        });
        filterCarCodeb.setOnAction(actionEvent -> {

        });
        removeLastB.setOnAction(actionEvent -> {
            scrolleeeeer.setVisible(true);
            Authorization.client.sendMessage(new Request("remove_last", username,password));
            console.setText(answer);
            console.setVisible(true);
        });
        b3137.setOnAction(actionEvent -> {
            Authorization.client.sendMessage(new Request("3137best", username, password));
        });

        Language2.addLanguage(langb);
        choseUser.getItems().add("Сменить пользователя");
        choseUser.getItems().add("Добавить пользователя");


        ToggleGroup group = new ToggleGroup();
        table.setToggleGroup(group);
        map.setToggleGroup(group);



        assert addb != null : "fx:id=\"addb\" was not injected: check your FXML file 'window.fxml'.";
        assert b3137 != null : "fx:id=\"b3137\" was not injected: check your FXML file 'window.fxml'.";
        assert choseUser != null : "fx:id=\"choseUser\" was not injected: check your FXML file 'window.fxml'.";
        assert clearb != null : "fx:id=\"clearb\" was not injected: check your FXML file 'window.fxml'.";
        assert exitb != null : "fx:id=\"exitb\" was not injected: check your FXML file 'window.fxml'.";
        assert filterCarCodeb != null : "fx:id=\"filterCarCodeb\" was not injected: check your FXML file 'window.fxml'.";
        assert gayChecker != null : "fx:id=\"gayChecker\" was not injected: check your FXML file 'window.fxml'.";
        assert helpb != null : "fx:id=\"helpb\" was not injected: check your FXML file 'window.fxml'.";
        assert historyb != null : "fx:id=\"historyb\" was not injected: check your FXML file 'window.fxml'.";
        assert infob != null : "fx:id=\"infob\" was not injected: check your FXML file 'window.fxml'.";
        assert insertAtb != null : "fx:id=\"insertAtb\" was not injected: check your FXML file 'window.fxml'.";
        assert langb != null : "fx:id=\"langb\" was not injected: check your FXML file 'window.fxml'.";
        assert removeClimateb != null : "fx:id=\"removeClimateb\" was not injected: check your FXML file 'window.fxml'.";
        assert removeIDb != null : "fx:id=\"removeIDb\" was not injected: check your FXML file 'window.fxml'.";
        assert removeLastB != null : "fx:id=\"removeLastB\" was not injected: check your FXML file 'window.fxml'.";
        assert showb != null : "fx:id=\"showb\" was not injected: check your FXML file 'window.fxml'.";
        assert shuffleb != null : "fx:id=\"shuffleb\" was not injected: check your FXML file 'window.fxml'.";
        assert updateb != null : "fx:id=\"updateb\" was not injected: check your FXML file 'window.fxml'.";

    }

}