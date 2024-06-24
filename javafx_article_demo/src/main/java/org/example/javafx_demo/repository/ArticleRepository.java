package org.example.javafx_demo.repository;

import org.example.javafx_demo.entity.Article;

import java.sql.*;
import java.util.ArrayList;

public class ArticleRepository {
    private final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/student";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";

    public void save(Article article) {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String strSql = "insert into articles (title, description, content) values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(strSql);
            preparedStatement.setString(1, article.getTitle());
            preparedStatement.setString(2, article.getDescription());
            preparedStatement.setString(3, article.getContent());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    // Test
//    public static void main(String[] args){
//        ArticleRepository repo = new ArticleRepository();
//        Article article = new Article();
//        article.setTitle("chin");
//        article.setDescription("chin");
//        article.setContent("3");
//        repo.save(article);
//    }

}
