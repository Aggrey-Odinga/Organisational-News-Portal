package models;

public class Department {
    private String name;
    private String description;
    private int id;
    private String employees;

    public Department(String name, String description, String employees) {
        this.name = name;
        this.description = description;
        this.employees = employees;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmployees() { return employees; }

    public void setEmployees(String employees) { this.employees = employees; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
