package Controllers;

import java.net.URL;
import java.util.*;

import Scene.StartWindow;
import auxillary.Authorization;
import auxillary.City;
import auxillary.Language;
import connection.Request;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static Controllers.LoginController.password;
import static Controllers.LoginController.username;
import static connection.connectionManager.answer;
import static connection.connectionManager.connectionMess;

public class WindowController {
    private ObservableList<City> usersData = FXCollections.observableArrayList();

    @FXML private ResourceBundle resources;
    @FXML private URL location;


    @FXML private ChoiceBox<String> choseUser;
    @FXML private CheckBox gayChecker;

    @FXML private Button addb;
    @FXML private Button b3137;
    @FXML private Button clearb;
    @FXML private Button exitb;

    @FXML private Button filterCarCodeb;
    @FXML private Button filterBackButton;
    @FXML private Button enterFilterButton;
    @FXML private Text enterFilterText;
    @FXML private Text backFilterIdText1;
    @FXML private TextField carcodeValue;

    @FXML public Button helpb;
    @FXML private Button historyb;
    @FXML private Button infob;
    @FXML private Button insertAtb;
    @FXML private ChoiceBox<String> langb;

    @FXML private Button removeClimateb;
    @FXML private ChoiceBox<String> ChoseCLimate;

    @FXML private Button removeIDb;
    @FXML private Button backRemoveIdButton;
    @FXML private Text backRemoveIdText;
    @FXML private Button enterRemoveIdButton;
    @FXML private Text enterRemoveIdText;
    @FXML private TextField removeIdField;

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
    @FXML private Text climatetext;
    @FXML private Text standOfLivText;
    @FXML private Button enterForAddButton;
    @FXML private TextField aux1;
    @FXML private TextField aux2;
    @FXML private TextField updateIdField;

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

    @FXML private TextField SearchField;
    @FXML private Button SearchButton;
    @FXML private Text serrchErr;

    @FXML private Button deleteRow;

    @FXML private ImageView cityImg;



    @FXML
    void initialize() {
        try {
            nickname.setText(username);
        } catch (Exception e) {
            ServerError("Ошибка подключения к серверу");
        }
        scrolleeeeer.setVisible(false);

        exitb.setOnAction(actionEvent -> {
            System.exit(101);
        });

        helpb.setOnAction(actionEvent -> {
            hide();
            try {
                setWindowSizeY(510, 350);
                setWindowSizeX(350, 350);
                Authorization.client.sendMessage(new Request("help", username, password));
                console.setText(answer);
                console.setVisible(true);
            } catch (Exception e) {
                ServerError("Ошибка подключения к серверу");
            }
        });

        infob.setOnAction(actionEvent -> {
            hide();
            try {
                setWindowSizeY(100, 120);
                setWindowSizeX(350, 350);
                Authorization.client.sendMessage(new Request("info", username, password));
                console.setText(answer);
                console.setVisible(true);
            } catch (Exception e) {
                ServerError("Ошибка подключения к серверу");
            }
        });

        historyb.setOnAction(actionEvent -> {
            hide();
            try {
                setWindowSizeY(90, 100);
                Authorization.client.sendMessage(new Request("history", username, password));
                console.setText(answer);
                console.setVisible(true);
            } catch (Exception e) {
                ServerError("Ошибка подключения к серверу");
            }
        });

        ToggleGroup group = new ToggleGroup();
        tableb.setToggleGroup(group);
        map.setToggleGroup(group);
        tableb.setVisible(false);
        map.setVisible(false);


        showb.setOnAction(actionEvent -> {
            hide();
            try {
                setWindowSizeY(510, 350);
                tableb.fire();
                table.setVisible(true);
                setWindowSizeX(900, 368);
                Authorization.client.sendMessage(new Request("show", username, password));
                table.getItems().clear();
                setCollums(answer);
                tableb.setVisible(true);
                map.setVisible(true);
                tableb.setOnAction(actionEvent1 -> {
                    hide();
                    if (tableb.isSelected()) {
                        try {
                            Authorization.client.sendMessage(new Request("show", username, password));
                            table.setVisible(true);
                            setWindowSizeX(900, 368);
                            table.getItems().clear();
                            setCollums(answer);
                            tableb.setVisible(true);
                            map.setVisible(true);
                        } catch (Exception e) {
                            ServerError("Ошибка подключения к серверу");
                        }
                    }
                });

                table.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        infoShower.setVisible(false);
                        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                            Node node = ((Node) event.getTarget()).getParent();
                            TableRow row;
                            if (node instanceof TableRow) {
                                row = (TableRow) node;
                            } else {
                                row = (TableRow) node.getParent();
                            }

                            try {
                                String answ = String.valueOf(table.getColumns().get(0).getCellObservableValue(row.getIndex()).getValue());
                                if (answ != null) {
                                    deleteRow.setVisible(true);
                                    deleteRow.setOnAction(actionEvent1 -> {
                                        try {
                                            Authorization.client.sendMessage(new Request("remove_by_id " + answ, username, password));
                                            if (answer.contains("не найден или к нему нет доступа")) {
                                                ServerError("У вас нет доступа");
                                                table.setVisible(true);
                                                tableb.setVisible(true);
                                                map.setVisible(true);
                                            }
                                        } catch (Exception e) {
                                            ServerError(String.valueOf(e));
                                        }
                                    });
                                }
                            } catch (Exception e) {
                                infoShower.setText("Выбрана пустая строка");
                                infoShower.setVisible(true);
                            }
                        }
                    }
                });
                map.setOnAction(actionEvent1 -> {
                    if (map.isSelected()) {
                        try {
                            hide();
                            setWindowSizeY(356, 356);
                            setWindowSizeX(356, 356);
                            tableb.setVisible(true);
                            map.setVisible(true);
                            Authorization.client.sendMessage(new Request("grpk", username, password));
                            String[] element = answer.split("/");
                            int count = 0;
                            GraphicsContext context = graphic.getGraphicsContext2D();
                            drawAxis(context);
                            while (count < element.length) {
                                String[] fields = element[count].split(" ");
                                count = count + 1;
                                int x = Integer.parseInt(fields[0]);
                                int y = Integer.parseInt(fields[1]);
                                int area = Integer.parseInt(fields[2]);
                                context.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                                context.strokeRect(100 + x, 180 - y, area / 2, 10);
                            }
                            scrolleeeeer.setVisible(true);
                            graphic.setVisible(true);
                        } catch (Exception e) {
                            ServerError(String.valueOf(e));
                        }
                    }
                });
            } catch (Exception e) {
                ServerError(String.valueOf(e));
                System.out.println(e);
            }
        });


        shuffleb.setOnAction(actionEvent -> {
            hide();
            try {
                setWindowSizeY(90, 100);
                Authorization.client.sendMessage(new Request("shuffle", username, password));
                console.setText(answer);
                console.setVisible(true);
            } catch (Exception e) {
                ServerError("Ошибка подключения к серверу");
            }
        });

        filterCarCodeb.setOnAction(actionEvent -> {
            hide();
            filterCarCodeb.setVisible(false);
            backFilterIdText1.setVisible(true);
            enterFilterButton.setVisible(true);
            carcodeValue.setVisible(true);
            enterFilterText.setVisible(true);
            filterBackButton.setVisible(true);
            carcodeValue.clear();
            carcodeValue.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            filterBackButton.setOnAction(actionEvent1 -> {
                filterCarCodeb.setVisible(true);
                backFilterIdText1.setVisible(false);
                enterFilterButton.setVisible(false);
                carcodeValue.setVisible(false);
                enterFilterText.setVisible(false);
                filterBackButton.setVisible(false);
            });
            try {
                enterFilterButton.setOnAction(actionEvent1 -> {
                    hide();
                    if (!carcodeValue.getText().equals("")) {
                        Authorization.client.sendMessage(new Request("filter_greater_than_car_code " + carcodeValue.getText(), username, password));
                        table.setVisible(true);
                        setWindowSizeX(850, 368);
                        setWindowSizeY(510, 350);
                        table.getItems().clear();
                        setCollums(answer);
                        filterCarCodeb.setVisible(true);
                        backFilterIdText1.setVisible(false);
                        enterFilterButton.setVisible(false);
                        carcodeValue.setVisible(false);
                        enterFilterText.setVisible(false);
                        filterBackButton.setVisible(false);
                    } else
                        carcodeValue.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
                });

            } catch (Exception e) {
                ServerError(String.valueOf(e));
                System.out.println(e);
            }
        });

        removeIDb.setOnAction(actionEvent -> {
            hide();
            removeIDb.setVisible(false);
            backRemoveIdButton.setVisible(true);
            backRemoveIdText.setVisible(true);
            removeIdField.setVisible(true);
            removeIdField.clear();
            backRemoveIdButton.setOnAction(actionEvent1 -> {
                enterRemoveIdButton.setVisible(false);
                enterRemoveIdText.setVisible(false);
                removeIdField.setVisible(false);
                removeIDb.setVisible(true);
                backRemoveIdButton.setVisible(false);
                backRemoveIdText.setVisible(false);
            });
            enterRemoveIdButton.setVisible(true);
            enterRemoveIdText.setVisible(true);
            try {
                enterRemoveIdButton.setOnAction(actionEvent1 -> {
                    hide();
                    Authorization.client.sendMessage(new Request("remove_by_id " + removeIdField.getText(), username, password));
                    setWindowSizeY(90, 100);

                    console.setText(answer);
                    console.setVisible(true);
                    enterRemoveIdButton.setVisible(false);
                    enterRemoveIdText.setVisible(false);
                    removeIdField.setVisible(false);
                    removeIDb.setVisible(true);
                    backRemoveIdButton.setVisible(false);
                    backRemoveIdText.setVisible(false);

                });
            } catch (Exception e) {
                ServerError(String.valueOf(e));
            }
        });


        ChoseCLimate.getItems().add("STEPPE");
        ChoseCLimate.getItems().add("MONSOON");
        ChoseCLimate.getItems().add("MEDITERRANIAN");
        ChoseCLimate.getItems().add("OCEANIC");
        ChoseCLimate.setOnAction(actionEvent -> {
            hide();
            ChoseCLimate.getValue();
            System.out.println(ChoseCLimate.getValue());
            try {
                if (ChoseCLimate.getValue() != null) {
                    Authorization.client.sendMessage(new Request("remove_any_by_climate " + ChoseCLimate.getValue(), username, password));
                    setWindowSizeY(90, 100);
                    setWindowSizeX(320, 352);
                    console.setText(answer);
                    console.setVisible(true);
                }
            } catch (Exception e) {
                ServerError(String.valueOf(e));
            }

        });

        removeLastB.setOnAction(actionEvent -> {
            hide();
            try {
                setWindowSizeY(90, 100);
                Authorization.client.sendMessage(new Request("remove_last", username, password));
                setWindowSizeY(90, 100);
                setWindowSizeX(352, 352);
                console.setText(answer);
                console.setVisible(true);
            } catch (Exception e) {
                ServerError("Ошибка подключения к серверу");
            }
        });

        clearb.setOnAction(actionEvent -> {
            hide();
            try {
                setWindowSizeY(90, 100);
                setWindowSizeX(352, 352);
                Authorization.client.sendMessage(new Request("clear", username, password));
                console.setText(answer);
                console.setVisible(true);
            } catch (Exception e) {
                ServerError("Ошибка подключения к серверу");
            }
        });

        b3137.setOnAction(actionEvent -> {
            hide();
            try {
                Authorization.client.sendMessage(new Request("3137best", username, password));
            } catch (Exception e) {
                ServerError("Ошибка подключения к серверу");
            }
        });


        climateF.getItems().add("STEPPE");
        climateF.getItems().add("MONSOON");
        climateF.getItems().add("MEDITERRANIAN");
        climateF.getItems().add("OCEANIC");

        StandartOfLivingF.getItems().add("VERY_HIGH");
        StandartOfLivingF.getItems().add("HIGH");
        StandartOfLivingF.getItems().add("NIGHTMARE");

        addb.setOnAction(actionEvent -> {
            hide();
            clearData();
            setWindowSizeY(340, 356);
            setWindowSizeX(350, 350);
            showForAdd(true);
            enterForAddButton.setOnAction(actionEvent1 -> {
                try {
                    String data = getDataFromAdd();
                    if (!data.equals("дичь")) {
                        Authorization.client.sendMessage(new Request("add " + getDataFromAdd(), username, password));
                        showForAdd(false);
                        setWindowSizeY(90, 100);
                        setWindowSizeX(352, 352);
                        console.setText(answer);
                        console.setVisible(true);
                    } else {
                        System.out.println("Введи всё");
                        ServerError("Введите все значения");
                    }
                } catch (Exception e) {
                    ServerError("Неверные форматы значений!");
                    hide();
                    setWindowSizeY(100, 120);
                    console.setText("В каком-то из полей допущена ошибка! Повторите попытку.");
                    console.setVisible(true);
                }

            });
        });

        updateb.setOnAction(actionEvent -> {
            hide();
            updateIdField.clear();
            clearData();
            setWindowSizeY(340, 356);
            setWindowSizeX(350, 350);
            showForAdd(true);
            updateIdField.setVisible(true);
            enterForAddButton.setOnAction(actionEvent1 -> {
                try {
                    String data = getDataFromAdd();
                    String upId = updateIdField.getText() + "; ";
                    if (!data.equals("дичь")) {
                        Authorization.client.sendMessage(new Request("update " + upId + getDataFromAdd(), username, password));
                        showForAdd(false);
                        updateIdField.setVisible(false);
                        setWindowSizeY(90, 100);
                        setWindowSizeX(352, 352);
                        console.setText(answer);
                        console.setVisible(true);
                    } else {
                        ServerError("Введите все значения");
                    }
                } catch (Exception e) {
                    ServerError("Неверные форматы значений!");
                    hide();
                    setWindowSizeY(100, 120);
                    console.setText("В каком-то из полей допущена ошибка! Повторите попытку.");
                    console.setVisible(true);
                }
            });
        });

        SearchButton.setOnAction(actionEvent -> {
            serrchErr.setVisible(false);
            if (Objects.equals(SearchField.getText(), "")) {
                serrchErr.setText("заполните поле");
                serrchErr.setVisible(true);
            } else {
                hide();
                try {
                    setWindowSizeY(510, 350);
                    tableb.fire();
                    table.setVisible(true);
                    setWindowSizeX(900, 368);
                    Authorization.client.sendMessage(new Request("search " + SearchField.getText(), username, password));
                    table.getItems().clear();
                    setCollums(answer);
                } catch (Exception e) {
                    ServerError(String.valueOf(e));
                }
            }
        });
        Language.addLanguage(langb);
        langb.setOnAction(actionEvent -> {
            new Language().changeLanguage(langb.getValue());
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("window.fxml"), StartWindow.resourceBundle);
                Scene scene = new Scene(fxmlLoader.load(), 640, 452);
                Stage stage = (Stage) langb.getScene().getWindow();
                stage.close();
                stage.setTitle("I1 collection");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        choseUser.getItems().add("Сменить пользователя");
        choseUser.getItems().add("Добавить пользователя");
        choseUser.getItems().add("Вернуться в главное меню");

        choseUser.setOnAction(actionEvent -> {
            if (choseUser.getValue().equals("Сменить пользователя")) {
                System.out.println("Сменить пользователя");
                try {
                    Stage stage = (Stage) choseUser.getScene().getWindow();
                    stage.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("loginWindow.fxml"), StartWindow.resourceBundle);
                    Scene scene = new Scene(fxmlLoader.load(), 640, 452);
                    stage.setTitle("I1 collection");
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (choseUser.getValue().equals("Добавить пользователя")) {
                System.out.println("Добавить пользователя");
                try {
                    Stage stage = (Stage) choseUser.getScene().getWindow();
                    stage.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("RegWindow.fxml"), StartWindow.resourceBundle);
                    Scene scene = new Scene(fxmlLoader.load(), 640, 452);
                    stage.setTitle("I1 collection");
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (choseUser.getValue().equals("Вернуться в главное меню")) {
                System.out.println("Вернуться в главное меню");
                try {
                    Stage stage = (Stage) choseUser.getScene().getWindow();
                    stage.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(StartWindow.class.getResource("StartWindow.fxml"), StartWindow.resourceBundle);
                    Scene scene = new Scene(fxmlLoader.load(), 640, 452);
                    stage.setTitle("I1 collection");
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    void ServerError(String text){
        hide();scrolleeeeer.setVisible(true);
        if(connectionMess!= null){infoShower.setText(connectionMess);}
        else {infoShower.setText(text);}infoShower.setVisible(true);
    }
    void hide(){
        deleteRow.setVisible(false);
        graphic.setVisible(false);
        updateIdField.setVisible(false);
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
        climatetext.setVisible(flag);
        standOfLivText.setVisible(flag);
        enterForAddButton.setVisible(flag);
        aux1.setVisible(flag);
        aux2.setVisible(flag);
    }
    String getDataFromAdd(){

        if(
                !Objects.equals(nameF.getText(), "") &&
                !Objects.equals(xF.getText(), "") &&
                !Objects.equals(yF.getText(), "") &&
                !Objects.equals(areaF.getText(), "") &&
                !Objects.equals(populationF.getText(), "") &&
                !Objects.equals(carCodeF.getText(), "") &&
                !Objects.equals(metersSeaLevelF.getText(), "")&&
                !Objects.equals(StandartOfLivingF.getValue(), null)&&
                !Objects.equals(climateF.getValue(), null)
        ){
            return
                    nameF.getText() + ", " +
                    Long.valueOf(xF.getText()) + " " +
                    Long.valueOf(yF.getText()) + ", " +
                    "2022-06-10T00:43:48.073, "+
                    Integer.valueOf(areaF.getText()) + ", " +
                    Long.valueOf(populationF.getText()) + ", " +
                    Long.valueOf(carCodeF.getText()) + ", " +
                    Long.valueOf(metersSeaLevelF.getText()) + ", " +
                    climateF.getValue()+", " +
                    StandartOfLivingF.getValue()+", " +
                    Float.valueOf(governorF.getText());

        }else return "дичь";
    }

    void clearData(){
        nameF.clear();xF.clear();yF.clear();areaF.clear();populationF.clear();
        carCodeF.clear();metersSeaLevelF.clear();governorF.clear();
        StandartOfLivingF.setValue(null);climateF.setValue(null);
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
    void drawAxis(GraphicsContext context){
        //context.setFill(Color.color(55,55,55));
        context.beginPath();
        context.moveTo(180, 1);
        context.lineTo(180, 2000);
        context.stroke();
        context.closePath();
        context.beginPath();
        context.moveTo(1, 180);
        context.lineTo(2000, 180);
        context.stroke();
        context.closePath();
    }
}