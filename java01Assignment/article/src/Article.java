import java.time.LocalDate;

class Article {
    private String code;
    private String title;
    private String description;
    private String avatar;
    private String content;
    private String author;
    private LocalDate dateWritten;

    public Article(String code, String title, String description, String avatar, String content, String author, LocalDate dateWritten) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.avatar = avatar;
        this.content = content;
        this.author = author;
        this.dateWritten = dateWritten;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getavatar() {
        return avatar;
    }

    public void setavatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDateWritten() {
        return dateWritten;
    }

    public void setDateWritten(LocalDate dateWritten) {
        this.dateWritten = dateWritten;
    }
}