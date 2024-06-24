module org.example.javafx_demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;
    requires java.sql;


    opens org.example.javafx_demo to javafx.graphics, javafx.fxml;
    exports org.example.javafx_demo;
    opens org.example.javafx_demo.controller to javafx.graphics, javafx.fxml;
    exports org.example.javafx_demo.controller;
}