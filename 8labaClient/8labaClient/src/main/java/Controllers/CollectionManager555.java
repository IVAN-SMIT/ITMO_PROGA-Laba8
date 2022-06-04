package Controllers;
/*

вячеслав воронин спасибо за детство


import auxillary.City;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import connection.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableRow;
import javafx.scene.control.Labeled;
import javafx.scene.input.MouseEvent;

public class CollectionManager implements EventHandler<ActionEvent> {
    private Button back;
    private Button clear;
    private Button show;
    private Button filter_less_than_wingspan;
    private TextField arguments;
    private ResourceBundle lang;
    private String username;
    private String password;
    private connectionManager client;
    private Button remove_by_id;
    private Button execute_script;
    private Button remove_greater;
    private Button remove_any_by_age;
    private Button add;
    private Button update_id;
    private TextField dname;
    private TextField dcoord;
    private TextField dage;
    private TextField dwingspan;
    private ComboBox dcolor;
    private ComboBox dtype;
    private TextField dcave;
    private String scolor = "RED";
    private String stype = "AIR";
    private Label user_text;

    public CollectionManager(ResourceBundle lang, String username, String password, connectionManager client) {
        this.lang = lang;
        this.username = username;
        this.password = password;
        this.client = client;
    }

    public Parent getCollectionManager(String command) {

        back = new Button(lang.getString("back"));
        clear = new Button("clear");
        show = new Button("show");
        remove_by_id = new Button("remove_by_id");
        filter_less_than_wingspan = new Button("filter_less_than_wingspan");
        arguments = new TextField();
        arguments.setMaxWidth(150);
        arguments.setPromptText("arguments");
        execute_script = new Button("execute_script");
        remove_greater = new Button("remove_greater");
        remove_any_by_age = new Button("remove_any_by_age");
        add = new Button("add");
        update_id = new Button("update_id");
        dname = new TextField();
        dname.setMaxWidth(100);
        dname.setPromptText("name");
        dcoord = new TextField();
        dcoord.setMaxWidth(100);
        dcoord.setPromptText("x y");
        dage = new TextField();
        dage.setMaxWidth(100);
        dage.setPromptText("age");
        dwingspan = new TextField();
        dwingspan.setMaxWidth(100);
        dwingspan.setPromptText("wingspan");
        user_text = new Label("Current user: " + username);

        ObservableList<String> colors = FXCollections.observableArrayList("GREEN", "RED", "YELLOW", "WHITE");
        ComboBox<String> dcolor = new ComboBox<String>(colors);
        dcolor.setValue("RED");
        dcolor.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                scolor = t1;
            }
        });
        ObservableList<String> types = FXCollections.observableArrayList("WATER", "UNDERGROUND", "AIR", "FIRE");
        ComboBox<String> dtype = new ComboBox<String>(types);
        dtype.setValue("AIR");
        dtype.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                stype = t1;
            }
        });
        dcave = new TextField();
        dcave.setMaxWidth(100);
        dcave.setPromptText("cave");

        back.setOnAction(this);
        clear.setOnAction(this);
        show.setOnAction(this);
        remove_by_id.setOnAction(this);
        filter_less_than_wingspan.setOnAction(this);
        execute_script.setOnAction(this);
        remove_greater.setOnAction(this);
        remove_any_by_age.setOnAction(this);
        add.setOnAction(this);
        update_id.setOnAction(this);

        ObservableList<City> dragons = FXCollections.observableArrayList();

        String[] dragonsCSV = client.sendMessage(new Request(command, username, password)).gettextResponse().split("\n");
        if (dragonsCSV[0].length() > 1) {
            for (String s: dragonsCSV) {
                String[] fields = s.split(",");
               // dragons.add(new City(Long.valueOf(fields[0]), fields[1], Integer.valueOf(fields[2].split(" ")[0]), Integer.valueOf(fields[2].split(" ")[1]), fields[3], Long.valueOf(fields[4]), Double.valueOf(fields[5]), fields[6], fields[7], Long.valueOf(fields[8]), fields[9]));
            }
        }

        // определяем таблицу и устанавливаем данные
        TableView<City> table = new TableView<City>(dragons);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<City, Long> idColumn = new TableColumn<City, Long>("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<City, Long>("id"));
        table.getColumns().add(idColumn);

        // столбец для вывода имени
        TableColumn<City, String> nameColumn = new TableColumn<City, String>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<City, String>("name"));
        table.getColumns().add(nameColumn);

        TableColumn<City, Integer> xColumn = new TableColumn<City, Integer>("X");
        xColumn.setCellValueFactory(new PropertyValueFactory<City, Integer>("x"));
        table.getColumns().add(xColumn);

        TableColumn<City, Integer> yColumn = new TableColumn<City, Integer>("Y");
        yColumn.setCellValueFactory(new PropertyValueFactory<City, Integer>("y"));
        table.getColumns().add(yColumn);

        TableColumn<City, String> dateColumn = new TableColumn<City, String>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<City, String>("date"));
        table.getColumns().add(dateColumn);

        TableColumn<City, Long> ageColumn = new TableColumn<City, Long>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<City, Long>("age"));
        table.getColumns().add(ageColumn);

        TableColumn<City, Double> wingspanColumn = new TableColumn<City, Double>("Wingspan");
        wingspanColumn.setCellValueFactory(new PropertyValueFactory<City, Double>("wingspan"));
        table.getColumns().add(wingspanColumn);

        TableColumn<City, String> colorColumn = new TableColumn<City, String>("Color");
        colorColumn.setCellValueFactory(new PropertyValueFactory<City, String>("color"));
        table.getColumns().add(colorColumn);

        TableColumn<City, String> typeColumn = new TableColumn<City, String>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<City, String>("type"));
        table.getColumns().add(typeColumn);

        TableColumn<City, Long> caveColumn = new TableColumn<City, Long>("Cave");
        caveColumn.setCellValueFactory(new PropertyValueFactory<City, Long>("cave"));
        table.getColumns().add(caveColumn);

        TableColumn<City, String> usernameColumn = new TableColumn<City, String>("Username");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<City, String>("username"));
        table.getColumns().add(usernameColumn);

        table.setRowFactory(tv -> new TableRow<City>() {
            @Override
            protected void updateItem(City item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || item.getUsername() == null)
                    setStyle("");
                else
                    setStyle("-fx-background-color: #" + Login.encryptThisString(item.getUsername()).substring(0, 6) + ";");
            }
        });

        Region p = new Region();
        p.setPrefSize(Double.MAX_VALUE, 0.0);
        Region p2 = new Region();
        p2.setPrefSize(Double.MAX_VALUE, 0.0);

        table.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 0) {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    City selectedDragon = table.getSelectionModel().getSelectedItem();
                    arguments.setText(String.valueOf(selectedDragon.getId()));
                    dname.setText(selectedDragon.getName());
                    dcoord.setText(String.valueOf(selectedDragon.getX()) + " " + String.valueOf(selectedDragon.getY()));
                    dage.setText(String.valueOf(selectedDragon.getArea()));
                    dwingspan.setText(String.valueOf(selectedDragon.getWingspan()));
                    dcolor.setValue(selectedDragon.getColor());
                    dtype.setValue(selectedDragon.getType());
                    dcave.setText(String.valueOf(selectedDragon.getCave()));
                }
            }
        });

        FlowPane root = new FlowPane(10, 10, table, p2, user_text, arguments, show, execute_script, remove_by_id, clear, filter_less_than_wingspan, remove_greater, remove_any_by_age, add, update_id, back, p, dname, dcoord, dage, dwingspan, dcolor, dtype, dcave);

        return root;
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == back) {
            Login login = new Login(lang);
            back.getScene().setRoot(login.getLogin());
        } else if (event.getSource() == clear) {
            client.sendMessage(new Request("clear", username, password));
            back.getScene().setRoot(getCollectionManager("show"));
        } else if (event.getSource() == show) {
            back.getScene().setRoot(getCollectionManager("show"));
        } else if (event.getSource() == filter_less_than_wingspan) {
            back.getScene().setRoot(getCollectionManager("filter_less_than_wingspan " + arguments.getText()));
        } else if (event.getSource() == remove_by_id) {
            client.sendMessage(new Request("remove_by_id " + arguments.getText(), username, password));
            back.getScene().setRoot(getCollectionManager("show"));
        } else if (event.getSource() == execute_script) {
            client.sendMessage(new Request("execute_script " + arguments.getText(), username, password));
            back.getScene().setRoot(getCollectionManager("show"));
        } else if (event.getSource() == remove_greater) {
            client.sendMessage(new Request("remove_greater " + arguments.getText(), username, password));
            back.getScene().setRoot(getCollectionManager("show"));
        } else if (event.getSource() == remove_any_by_age) {
            client.sendMessage(new Request("remove_any_by_age " + arguments.getText(), username, password));
            back.getScene().setRoot(getCollectionManager("show"));
        } else if (event.getSource() == add) {
            client.sendMessage(new Request("add " + dname.getText() + ", " + dcoord.getText() + ", " + dage.getText() + ", " + dwingspan.getText() + ", " + scolor + ", " + stype + ", " + dcave.getText(), username, password));
            back.getScene().setRoot(getCollectionManager("show"));
        } else if (event.getSource() == update_id) {
            client.sendMessage(new Request("update " + arguments.getText() + ", " + dname.getText() + ", " + dcoord.getText() + ", " + dage.getText() + ", " + dwingspan.getText() + ", " + scolor + ", " + stype + ", " + dcave.getText(), username, password));
            back.getScene().setRoot(getCollectionManager("show"));
        }
    }
}

 */