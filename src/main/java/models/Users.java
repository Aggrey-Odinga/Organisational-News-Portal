package models;

public class Users {
    private int id;
    private String name;
    private String department;
    private String role;

    public Users(String name, String department, String role) {
        this.name = name;
        this.department = department;
        this.role = role;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPosition() { return department; }

    public void setPosition(String position) { this.department = department; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

}
