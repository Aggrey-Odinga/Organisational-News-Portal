package models;

public class News {

    private int id;
    private String news_type;
    private int department_id;
    private int user_id;
    private String title;
    private String description;

    public News(String news_type, int department_id, int user_id, String title, String description) {
        this.news_type = news_type;
        this.department_id = department_id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
    }
}
