package models;

public class Users {
    private int id;
    private String name;
    private String position;
    private String role;

    public Users(String name, String position, String role) {
        this.name = name;
        this.position = position;
        this.role = role;
    }
}
