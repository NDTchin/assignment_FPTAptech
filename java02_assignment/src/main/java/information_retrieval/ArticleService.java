package information_retrieval;

import java.util.ArrayList;

public interface ArticleService {
    ArrayList<String> getLinks(String url);
//    Cho phép lấy danh sách link từ một link nguồn.

    Article getArticle(String url);
//Cho phép lấy thông tin chi tiết từ một link bài viết chi tiết.

}
