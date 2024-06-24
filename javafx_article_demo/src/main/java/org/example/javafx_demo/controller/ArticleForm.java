package org.example.javafx_demo.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.javafx_demo.entity.Article;
import org.example.javafx_demo.repository.ArticleRepository;

public class ArticleForm {
    public TextField article_title;
    public TextArea article_description;
    public TextArea article_content;
    public TableColumn title;
    public TableColumn description;
    public TableColumn content;
    public TableColumn id;


    ArticleRepository articleRepository = new ArticleRepository();

    public void save(ActionEvent actionEvent) {
        Article article = new Article();
        article.setTitle(article_title.getText());
        article.setDescription(article_description.getText());
        article.setContent(article_content.getText());
        articleRepository.save(article);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Action success");
        alert.setHeaderText("Article saved:");
        alert.show();
        reset();
    }

    public void resert(ActionEvent actionEvent) {
        reset();
    }

    private void reset(){
        article_title.clear();
        article_description.clear();
        article_content.clear();
    }


}
