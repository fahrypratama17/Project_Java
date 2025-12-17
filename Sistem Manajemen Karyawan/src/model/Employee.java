package model;

public abstract class Employee {
    protected String name;
    protected String id;

    public Employee (String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract double calculateSalary();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract String toFileFormat();
}