package org.example.javafx_demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.javafx_demo.controller.ArticleForm;

public class MainArticleView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ArticleForm articleForm = new ArticleForm();

        BorderPane root = new BorderPane();
        root.setCenter(articleForm.showAllArticles());

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Article Management");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}