package models;

public class departments {
    private String name;
    private String description;
    private int id;
    private int size;

    public departments(String name, String description) {
        this.name = name;
        this.description = description;
        this.size = 0;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getSize() { return size; }

    public void setSize(int size) { this.size = size; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
