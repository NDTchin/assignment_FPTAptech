package information_retrieval;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    Scanner scanner = new Scanner(System.in);

    public void findByUrl() {
        System.out.println("Enter the URL you want to view.");
        String url = scanner.nextLine();
        MySqlArticleRepository mySqlArticleRepository = new MySqlArticleRepository();
        Article article = mySqlArticleRepository.findByUrl(url);
        if (article != null) {
            System.out.println("Article information retrieval");
            System.out.println("Url: " + article.getBaseUrl());
            System.out.println("Title: " + article.getTitle());
            System.out.println("Description: " + article.getDescription());
            System.out.println("Content: " + article.getContent());
            System.out.println("Thumbnail: " + article.getThumbnail());
            System.out.println("CreateAt: " + article.getCreatedAt());
            System.out.println("UpdateAt: " + article.getUpdatedAt());
            System.out.println("DeleteAt: " + article.getDeletedAt());
            System.out.println("Status: " + article.getStatus());
            System.out.println("---------------------------------------");
        }else{
            System.out.println("Article not found!");
        }
    }

    public void findAll() {
        MySqlArticleRepository mySqlArticleRepository = new MySqlArticleRepository();
        ArrayList<Article> articles = mySqlArticleRepository.findAll();
        for (Article article : articles) {
            System.out.println("Title: " + article.getTitle());
        }
    }

    public void link(ArticleService articleService, String url) {
        MySqlArticleRepository mySqlArticleRepository = new MySqlArticleRepository();
        ArrayList<String> getLink = articleService.getLinks(url);
        for (int i = 0; i < getLink.size(); i++) {
            Article article = articleService.getArticle(getLink.get(i));
            System.out.printf("%d - %s\n", i + 1, article.getTitle());
            mySqlArticleRepository.save(article);
        }
    }
}
