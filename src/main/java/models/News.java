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

    public String getNews_type() {
        return news_type;
    }

    public void setNews_type(String news_type) {
        this.news_type = news_type;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
}
