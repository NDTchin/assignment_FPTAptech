import java.util.ArrayList;
import java.util.List;

class ArticleManagement {
    private List<Article> articles;

    public ArticleManagement() {
        articles = new ArrayList<>();
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public void displayArticles() {
        System.out.println("----- DANH SÁCH BÀI VIẾT -----");
        for (Article article : articles) {
            System.out.println("Mã bài viết: " + article.getCode());
            System.out.println("Tiêu đề: " + article.getTitle());
            System.out.println("Mô tả: " + article.getDescription());
            System.out.println("Ảnh đại diện: " + article.getavatar());
            System.out.println("Nội dung bài viết: " + article.getContent());
            System.out.println("Tác giả: " + article.getAuthor());
            System.out.println("Ngày viết: " + article.getDateWritten());
            System.out.println("--------------------");
        }
    }

    public void deleteArticle(String code) {
        Article foundArticle = null;
        for (Article article : articles) {
            if (article.getCode().equals(code)) {
                foundArticle = article;
                break;
            }
        }

        if (foundArticle != null) {
            articles.remove(foundArticle);
            System.out.println("Bài viết với mã '" + code + "' đã được xoá.");
        } else {
            System.out.println("Không tìm thấy bài viết với mã '" + code + "'.");
        }
    }
}

