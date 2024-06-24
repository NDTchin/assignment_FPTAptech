package org.example.javafx_demo.repository;

import org.example.javafx_demo.entity.Article;

import java.sql.*;
import java.util.ArrayList;

public class ArticleRepository {
    private final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/student";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";

    public ArrayList<Article> findAll() {
        ArrayList<Article> arrayList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD)) {
            String sql = "Select * from articles";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setDescription(resultSet.getString("description"));
                article.setContent(resultSet.getString("content"));
                arrayList.add(article);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

//        public static void main(String[] args) {
//            ArticleRepository articleRepository = new ArticleRepository();
//            ArrayList<Article> articles = articleRepository.findAll();
//
//            for (Article article : articles) {
//                System.out.println("ID: " + article.getId());
//                System.out.println("Title: " + article.getTitle());
//                System.out.println("Description: " + article.getDescription());
//                System.out.println("Content: " + article.getContent());
//                System.out.println("-----------------------------");
//            }
//        }
}
