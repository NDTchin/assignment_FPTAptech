package information_retrieval;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        createMenu();
    }

    public static void createMenu() {
        VnexpressArticleService vnexpressArticleService = new VnexpressArticleService();
        MyArticleService myArticleService = new MyArticleService();
        ArticleController articleController = new ArticleController();
        Scanner scanner = new Scanner(System.in);
        int loop = 0;
        do {
            System.out.println("Danh sách Menu!");
            System.out.println("_____________________________________");
            System.out.println("1.Crawl thông tin từ vnexpress.");
            System.out.println("2.Crawl thông tin từ nguồn của tôi.");
            System.out.println("3.Hiển thị danh sách tin hiện có");
            System.out.println("4.Exit.");
            System.out.println("Vui lòng nhập lựa chọn (1-4):  ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    articleController.link(vnexpressArticleService, "https://vnexpress.net/du-lich");
                    break;
                case 2:
                    articleController.link(myArticleService, "https://vietnamnet.vn/oto-xe-may");
                    break;
                case 3:
                    break;
                case 4:
                    loop = 1;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (loop == 0);
    }
}
