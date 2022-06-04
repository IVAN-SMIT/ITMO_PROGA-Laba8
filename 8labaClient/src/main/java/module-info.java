module com.example.laba8clientjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens Scene to javafx.fxml;
    exports Scene;
    exports Controllers;
    opens Controllers to javafx.fxml;
}