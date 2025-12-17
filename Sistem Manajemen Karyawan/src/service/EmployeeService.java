package service;

import model.Employee;
import repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void printEmployees() {
        List<Employee> employees = repository.loadEmployees();

        for (Employee e : employees) {
            System.out.println("ID: " + e.getId() + " | " + "Nama: " + e.getName() + " | Gaji: " + e.calculateSalary());
        }
    }
}