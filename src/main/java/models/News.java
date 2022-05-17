package models;


import java.util.Objects;

public class News{


    private int id;
    private int articleId;
    private String name;
    private String author;
    private  String description;

    public News(String name, String author, String description) {
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public News() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return getId() == news.getId() &&
                getArticleId() == news.getArticleId() &&
                Objects.equals(getName(), news.getName()) &&
                Objects.equals(getAuthor(), news.getAuthor()) &&
                Objects.equals(getDescription(), news.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getArticleId(), getName(), getAuthor(), getDescription());
    }
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getArticleId() { return articleId; }

    public void setArticleId(int articleId) { this.articleId = articleId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}