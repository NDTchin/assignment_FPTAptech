package information_retrieval;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MySqlArticleRepository implements ArticleRepository {

    private final String MYSQL_CONNECTION = "jdbc:mysql://localhost:3306/java02_assignment";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";

    @Override
    public ArrayList<Article> findAll() {
        ArrayList<Article> arrayList = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USERNAME, MYSQL_PASSWORD)) {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("Select * from information_retrieval");
            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getLong("id"));
                article.setBaseUrl(resultSet.getString("base_url"));
                article.setTitle(resultSet.getString("title"));
                article.setDescription(resultSet.getString("description"));
                article.setContent(resultSet.getString("content"));
                article.setThumbnail(resultSet.getString("thumbnail"));
                article.setCreatedAt(resultSet.getString("created_at"));
                article.setUpdatedAt(LocalDate.parse(resultSet.getString("updated_at")));
                article.setUpdatedAt(LocalDate.parse(resultSet.getString("deleted_at")));
                article.setStatus(resultSet.getInt("status"));
                arrayList.add(article);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public Article findByUrl(String url) {
        Article article = null;
        try (
                Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USERNAME, MYSQL_PASSWORD)) {
            PreparedStatement preparedstatement = connection.prepareStatement("Select * from information_retrieval where base_url = ?");
            preparedstatement.setString(1, url);
            ResultSet resultSet = preparedstatement.executeQuery();
            while (resultSet.next()) {
                article = new Article();
                article.setBaseUrl(resultSet.getString("base_url"));
                article.setTitle(resultSet.getString("title"));
                article.setDescription(resultSet.getString("description"));
                article.setContent(resultSet.getString("content"));
                article.setThumbnail(resultSet.getString("thumbnail"));
                article.setCreatedAt(resultSet.getString("created_at"));
                article.setUpdatedAt(LocalDate.parse(resultSet.getString("updated_at")));
                article.setDeletedAt(LocalDate.parse(resultSet.getString("deleted_at")));
                article.setStatus(resultSet.getInt("status"));
            }
            preparedstatement.execute();
            preparedstatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return article;
    }

    @Override
    public Article save(Article article) {
        try (
                Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USERNAME, MYSQL_PASSWORD)) {
            PreparedStatement preparedstatement = connection.prepareStatement(
                    "Insert into information_retrieval " +
                    "(base_url, title, description, content, thumbnail, created_at, status) " +
                    "VALUES (?, ?, ?, ?, ? , ? ,1)");
            preparedstatement.setString(1, article.getBaseUrl());
            preparedstatement.setString(2, article.getTitle());
            preparedstatement.setString(3, article.getDescription());
            preparedstatement.setString(4, article.getContent());
            preparedstatement.setString(5, article.getThumbnail());
            preparedstatement.setString(6, article.getCreatedAt());
            preparedstatement.executeUpdate();
            preparedstatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return article;
    }

    @Override
    public Article updated(Article article) {
        try (
                Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USERNAME, MYSQL_PASSWORD)) {
            PreparedStatement preparedstatement = connection.prepareStatement(
                    "Update information_retrieval set title = ?, description = ?, " +
                            "content = ?, thumbnail = ?, created_at = ?, updated_at = ? where base_url = ? ");
            preparedstatement.setString(1, article.getTitle());
            preparedstatement.setString(2, article.getDescription());
            preparedstatement.setString(3, article.getContent());
            preparedstatement.setString(4, article.getThumbnail());
            preparedstatement.setString(5, article.getCreatedAt());
            preparedstatement.setString(6, article.getUpdatedAt().toString());
            preparedstatement.setString(7, article.getBaseUrl());
            preparedstatement.executeUpdate();
            preparedstatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return article;
    }

    @Override
    public void deleteByUrl(String url) {
        try (Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USERNAME, MYSQL_PASSWORD)) {
            Article article = new Article();
            PreparedStatement preparedstatement = connection.prepareStatement("Update information_retrieval set status = -1, deleted_at = ? WHERE url = ?");
            preparedstatement.setString(1, article.getDeletedAt().toString());
            preparedstatement.setString(2, url);
            int rows = preparedstatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Article deleted successfully.");
            } else {
                System.out.println("No article found!");
            }
            preparedstatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
