import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArticleManagement articleManagement = new ArticleManagement();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addArticle(articleManagement);
                    break;
                case 2:
                    displayArticles(articleManagement);
                    break;
                case 3:
                    deleteArticle(articleManagement);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("----- MENU -----");
        System.out.println("1. Thêm mới bài viết.");
        System.out.println("2. Hiển thị danh sách bài viết.");
        System.out.println("3. Xoá bài viết theo mã.");
        System.out.println("0. Thoát chương trình.");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    private static void addArticle(ArticleManagement articleManagement) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- THÊM MỚI BÀI VIẾT -----");
        System.out.print("Nhập mã bài viết: ");
        String code = scanner.nextLine();
        System.out.print("Nhập tiêu đề bài viết: ");
        String title = scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();
        System.out.print("Nhập URL ảnh đại diện: ");
        String coverImage = scanner.nextLine();
        System.out.print("Nhập nội dung bài viết: ");
        String content = scanner.nextLine();
        System.out.print("Nhập tên tác giả: ");
        String author = scanner.nextLine();
        System.out.print("Nhập ngày viết (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        LocalDate dateWritten = LocalDate.parse(dateStr);

        Article article = new Article(code, title, description, coverImage, content, author, dateWritten);
        articleManagement.addArticle(article);

        System.out.println("Bài viết đã được thêm mới thành công.");
    }

    private static void displayArticles(ArticleManagement articleManagement) {
        articleManagement.displayArticles();
    }

    private static void deleteArticle(ArticleManagement articleManagement) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã bài viết cần xoá: ");
        String code = scanner.nextLine();
        articleManagement.deleteArticle(code);
    }
}