package information_retrieval;

import java.util.ArrayList;

public interface ArticleRepository {
    ArrayList<Article> findAll();
    Article findByUrl(String url);
    Article save(Article article);
    Article updated(Article article);
    void deleteByUrl(String url);

}
