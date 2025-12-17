package model;

public class ContractEmployee extends Employee{
    private final int hoursWorked;
    private final double hourlyRate;

    public ContractEmployee (String name, String id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String toFileFormat() {
        return "CONTRACT" + id + ";" + name + ";" + hoursWorked + ";" + hourlyRate;
    }
}
