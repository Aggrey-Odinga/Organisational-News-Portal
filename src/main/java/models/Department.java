package models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return getId() == that.getId() && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getEmployees(), that.getEmployees());
    }

    @Override
    public int hashCode() { return Objects.hash(getName(), getDescription(), getId(), getEmployees()); }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmployees() { return employees; }

    public void setEmployees(String employees) { this.employees = employees; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
