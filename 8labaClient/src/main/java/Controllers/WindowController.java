package Controllers;

import java.net.URL;
import java.util.*;

import Scene.StartWindow;
import auxillary.Authorization;
import auxillary.City;
import auxillary.Language2;
import connection.Request;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static Controllers.LoginController.password;
import static Controllers.LoginController.username;
import static connection.connectionManager.answer;
import static connection.connectionManager.client;

public class WindowController {

    private ObservableList<City> usersData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML private ChoiceBox<String> choseUser;

    @FXML private CheckBox gayChecker;

    @FXML private Button addb;
    @FXML private Button b3137;
    @FXML private Button clearb;
    @FXML private Button exitb;
    @FXML private Button filterCarCodeb;
    @FXML public Button helpb;
    @FXML private Button historyb;
    @FXML private Button infob;
    @FXML private Button insertAtb;
    @FXML private ChoiceBox<String> langb;
    @FXML private Button removeClimateb;
    @FXML private Button removeIDb;
    @FXML private Button removeLastB;
    @FXML private Button showb;
    @FXML private Button shuffleb;
    @FXML private Button updateb;
    @FXML public Text console;
    @FXML public ScrollPane scrolleeeeer;
    @FXML private AnchorPane scroll;

    @FXML private RadioButton map;
    @FXML private RadioButton tableb;

    @FXML private Text infoShower;
    @FXML private Text nickname;

    @FXML private TableView<City> table;

    @FXML private TextField areaF;
    @FXML private TextField carCodeF;
    @FXML private ChoiceBox<String> climateF;
    @FXML private TextField governorF;
    @FXML private TextField metersSeaLevelF;
    @FXML private TextField nameF;
    @FXML private TextField populationF;
    @FXML private TextField xF;
    @FXML private TextField yF;
    @FXML private ChoiceBox<String> StandartOfLivingF;

    @FXML private Button enter;

    @FXML private Canvas graphic;

    @FXML private TableColumn<City, Long> areaC;
    @FXML private TableColumn<City, Long> carcodeC;
    @FXML private TableColumn<City, String> climateC;
    @FXML private TableColumn<City, String> dateC;
    @FXML private TableColumn<City, Float> goverC;
    @FXML private TableColumn<City, Long> idC;
    @FXML private TableColumn<City, Long> masC;
    @FXML private TableColumn<City, String> nameC;
    @FXML private TableColumn<City, Long> populationC;
    @FXML private TableColumn<City, String> standOfLivC;
    @FXML private TableColumn<City, String> userC;
    @FXML private TableColumn<City, String> xyC;





    @FXML
    void initialize() {
        String dude="dude";
        try {nickname.setText(Authorization.getUsername());
        }catch (Exception e){ServerError("Ошибка подключения к серверу");}
        if(Authorization.getUsername()==null){dude = "dude";nickname.setText(dude);}
        scrolleeeeer.setVisible(false);

        exitb.setOnAction(actionEvent -> {System.exit(101);});

        helpb.setOnAction(actionEvent -> {hide();
            try {
            setWindowSizeY(510,350);
            Authorization.client.sendMessage(new Request("help", username, password));
            console.setText(answer);console.setVisible(true);}
            catch (Exception e){ServerError("Ошибка подключения к серверу");}
        });

        infob.setOnAction(actionEvent -> {hide();
            try{
            setWindowSizeY(100,120);
            Authorization.client.sendMessage(new Request("info", username, password));
            console.setText(answer);console.setVisible(true);}
            catch (Exception e){ServerError("Ошибка подключения к серверу");}
        });

        historyb.setOnAction(actionEvent -> {hide();
            try{
            setWindowSizeY(90,100);
            Authorization.client.sendMessage(new Request("history",username, password));
            console.setText(answer);console.setVisible(true);}
            catch (Exception e){ServerError("Ошибка подключения к серверу");}
        });

        ToggleGroup group = new ToggleGroup();
        tableb.setToggleGroup(group);
        map.setToggleGroup(group);
        tableb.setVisible(false);
        map.setVisible(false);

        showb.setOnAction(actionEvent -> {hide();
            try {
                setWindowSizeY(510,350);tableb.fire();
                try{Authorization.client.sendMessage(new Request("show", username, password));
                    table.setVisible(true);
                    setWindowSizeX(850, 368);
                    table.getItems().clear();
                    setCollums(answer);
                    tableb.setVisible(true);
                    map.setVisible(true);}
                catch (Exception e){ServerError("Ошибка подключения к серверу");}
            }catch (Exception e){ServerError(String.valueOf(e));System.out.println(e);}
        });

        shuffleb.setOnAction(actionEvent -> {hide();
            try{
            setWindowSizeY(90,100);
            Authorization.client.sendMessage(new Request("shuffle", username, password));
            console.setText(answer);console.setVisible(true);}
            catch (Exception e){ServerError("Ошибка подключения к серверу");}
        });

        filterCarCodeb.setOnAction(actionEvent -> {hide();
            try {Authorization.client.sendMessage(new Request("filter_greater_than_car_code 100", username, password));
                System.out.println(answer);
                table.setVisible(true);
                setWindowSizeX(850, 368);
                setCollums(answer);
                tableb.setVisible(true);
                map.setVisible(true);
            }catch (Exception e){ServerError(String.valueOf(e));System.out.println(e);}
        });

        removeLastB.setOnAction(actionEvent -> {hide();
            try{
            setWindowSizeY(90,100);
            Authorization.client.sendMessage(new Request("remove_last", username,password));
            console.setText(answer);console.setVisible(true);}
            catch (Exception e){ServerError("Ошибка подключения к серверу");}
        });

        clearb.setOnAction(actionEvent -> {hide();
            try{
            setWindowSizeY(90, 100);
            Authorization.client.sendMessage(new Request("clear", username,password));
            console.setText(answer);console.setVisible(true);}
            catch (Exception e){ServerError("Ошибка подключения к серверу");}
        });

        b3137.setOnAction(actionEvent -> {hide();
            try{Authorization.client.sendMessage(new Request("3137best", username, password));}
            catch (Exception e){ServerError("Ошибка подключения к серверу");}
        });

        addb.setOnAction(actionEvent -> {hide();
            clearData();
            setWindowSizeY(340, 356);
            showForAdd(true);

            enter.setOnAction(actionEvent1 -> {
                String data = getDataFromAdd();
                if (!data.equals("дичь")) {
                    System.out.println(getDataFromAdd());
                }else System.out.println("Введи всё");
            });

        });


        Language2.addLanguage(langb);
        choseUser.getItems().add("Сменить пользователя");
        choseUser.getItems().add("Добавить пользователя");
        choseUser.getItems().add("Вернуться в главное меню");

        choseUser.setOnAction(actionEvent -> {
            if(choseUser.getValue().equals("Сменить пользователя")) {
                System.out.println("Сменить пользователя");
                try {
                    Stage stage = (Stage) choseUser.getScene().getWindow();
                    stage.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("loginWindow.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 640, 452);stage.setTitle("I1 collection");
                    stage.setResizable(false);stage.setScene(scene);stage.show();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
            if (choseUser.getValue().equals("Добавить пользователя")){
                System.out.println("Добавить пользователя");
                try {
                    Stage stage = (Stage) choseUser.getScene().getWindow();
                    stage.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("RegWindow.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 640, 452);stage.setTitle("I1 collection");
                    stage.setResizable(false);stage.setScene(scene);stage.show();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
            if(choseUser.getValue().equals("Вернуться в главное меню")){
                System.out.println("Вернуться в главное меню");
                try {
                    Stage stage = (Stage) choseUser.getScene().getWindow();
                    stage.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("StartWindow.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 640, 452);stage.setTitle("I1 collection");
                    stage.setResizable(false);stage.setScene(scene);stage.show();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        });





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

    void ServerError(String text){
        hide();scrolleeeeer.setVisible(true);
        infoShower.setText(text); infoShower.setVisible(true);
    }
    void hide(){
        table.setVisible(false);
        tableb.setVisible(false);
        map.setVisible(false);
        showForAdd(false);
        infoShower.setVisible(false);
        console.setVisible(false);
        scrolleeeeer.setVisible(false);
    }
    void showForAdd(boolean flag){
        nameF.setVisible(flag);
        xF.setVisible(flag);
        yF.setVisible(flag);
        areaF.setVisible(flag);
        populationF.setVisible(flag);
        carCodeF.setVisible(flag);
        metersSeaLevelF.setVisible(flag);
        climateF.setVisible(flag);
        StandartOfLivingF.setVisible(flag);
        governorF.setVisible(flag);
    }
    String getDataFromAdd(){

        if(
                !Objects.equals(nameF.getText(), "") &&
                !Objects.equals(xF.getText(), "") &&
                !Objects.equals(yF.getText(), "") &&
                !Objects.equals(areaF.getText(), "") &&
                !Objects.equals(populationF.getText(), "") &&
                !Objects.equals(carCodeF.getText(), "") &&
                !Objects.equals(metersSeaLevelF.getText(), "")
        ){
            return
                    nameF.getText() + " " +
                    xF.getText() + " " +
                    yF.getText() + " " +
                    areaF.getText() + " " +
                    populationF.getText() + " " +
                    carCodeF.getText() + " " +
                    metersSeaLevelF.getText() + " " +
                    // climateF.setVisible(true);
                    //StandartOfLivingF.setVisible(true);
                    governorF.getText();
        }else return "дичь";
    }

    void clearData(){
        nameF.clear();xF.clear();yF.clear();areaF.clear();populationF.clear();carCodeF.clear();metersSeaLevelF.clear();governorF.clear();
    }

    void setWindowSizeY(int plane, int scrol){
        scroll.setPrefHeight(plane);
        scrolleeeeer.setPrefHeight(scrol);
        scrolleeeeer.setVisible(true);
    }
    void setWindowSizeX(int plane, int scrol){
        scroll.setPrefWidth(plane);
        scrolleeeeer.setPrefWidth(scrol);
        scrolleeeeer.setVisible(true);
    }

    void setCollums(String answer){
        Stack<City> cityCollection = new CollectionManager().setCityCollection(answer);
        usersData.addAll(cityCollection);

        idC.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nameC.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        xyC.setCellValueFactory(cellData -> cellData.getValue().coordProperty());
        dateC.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        areaC.setCellValueFactory(cellData -> cellData.getValue().areaProperty().asObject());
        populationC.setCellValueFactory(cellData -> cellData.getValue().populationProperty().asObject());
        masC.setCellValueFactory(cellData -> cellData.getValue().MetersAboveSeaLevelProperty().asObject());
        carcodeC.setCellValueFactory(cellData -> cellData.getValue().carCodeProperty().asObject());
        climateC.setCellValueFactory(cellData -> cellData.getValue().climateProperty());
        standOfLivC.setCellValueFactory(cellData -> cellData.getValue().standartOfLivingProperty());
        goverC.setCellValueFactory(cellData -> cellData.getValue().governorProperty().asObject());
        userC.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());

        idC.setSortType(TableColumn.SortType.DESCENDING);
        nameC.setSortType(TableColumn.SortType.DESCENDING);
        areaC.setSortType(TableColumn.SortType.DESCENDING);
        populationC.setSortType(TableColumn.SortType.DESCENDING);
        masC.setSortType(TableColumn.SortType.DESCENDING);
        carcodeC.setSortType(TableColumn.SortType.DESCENDING);
        climateC.setSortType(TableColumn.SortType.DESCENDING);
        standOfLivC.setSortType(TableColumn.SortType.DESCENDING);
        goverC.setSortType(TableColumn.SortType.DESCENDING);
        userC.setSortType(TableColumn.SortType.DESCENDING);

        table.setItems(usersData);

    }
}