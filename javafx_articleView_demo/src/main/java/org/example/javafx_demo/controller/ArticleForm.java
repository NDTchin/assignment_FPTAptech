package org.example.javafx_demo.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.javafx_demo.entity.Article;
import org.example.javafx_demo.repository.ArticleRepository;
import javafx.stage.Stage;


public class ArticleForm  {
    ArticleRepository articleRepository = new ArticleRepository();
    ObservableList<Article> articles = FXCollections.observableArrayList();

    TableView<Article> tableView;

    public TableView<Article> showAllArticles() {

        //tao cac cot

        TableColumn<Article, Integer> idColumn = new TableColumn<>("Id");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Article, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Article, Integer> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setMinWidth(100);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Article, String> contentColumn = new TableColumn<>("Content");
        contentColumn.setMinWidth(200);
        contentColumn.setCellValueFactory(new PropertyValueFactory<>("content"));

        articles.addAll(articleRepository.findAll());

        tableView = new TableView<>();
        tableView.setItems(articles);
        tableView.getColumns().addAll(idColumn, titleColumn, descriptionColumn, contentColumn);
        return tableView;
    }

}
