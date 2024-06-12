package information_retrieval;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class MyArticleService implements ArticleService {

    @Override
    public ArrayList<String> getLinks(String url) {
        HashSet<String> links = new HashSet<>();
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByTag("a");
            for (Element element : elements) {
                String href = element.attr("href");
                if(href.contains("https://vietnamnet.vn/") && href.contains(".html")){
                    links.add(href);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(links);
    }

    @Override
    public Article getArticle(String url) {
        Document document = null;
        try{
            document = Jsoup.connect(url).get();
            String title = document.select("h1.title-detail").text();
            String description = document.select("p.description").text();
            String thumb = document.select("picture  img[itemprop=contentUrl]").attr("data-src");
            String content = document.select("article.fck_detail  p.Normal").text();
            String created_at = document.select("data-campaign").text();
            Article article = new Article();
            article.setBaseUrl(url);
            article.setTitle(title);
            article.setDescription(description);
            article.setContent(content);
            article.setThumbnail(thumb);
            article.setCreatedAt(created_at);
            return article;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
