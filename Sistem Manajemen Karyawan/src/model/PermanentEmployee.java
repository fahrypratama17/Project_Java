package model;

public class PermanentEmployee extends Employee {
    private final double monthlySalary;

    public PermanentEmployee (String id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public String toFileFormat() {
        return "PERMANENT;" + id + ";" + name + ";" + monthlySalary;
    }
}
