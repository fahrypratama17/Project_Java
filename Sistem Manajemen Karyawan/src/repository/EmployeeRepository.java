package repository;

import model.ContractEmployee;
import model.Employee;
import model.PermanentEmployee;
import util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    public List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        List<String> lines = FileUtil.readLines();

        for (String line : lines) {
            String[] data = line.split(";");

            if (data[0].equals("PERMANENT")) {
                employees.add(new PermanentEmployee(
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])
                ));
            } else if (data[0].equals("CONTRACT")) {
                employees.add(new ContractEmployee(
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        Double.parseDouble(data[4])
                ));
            }
        }
        return employees;
    }

    public void saveEmployees(List<Employee> employees) {
        List<String> lines = new ArrayList<>();

        for (Employee e : employees) {
            lines.add(e.toFileFormat());
        }

        FileUtil.writeLines(lines);
    }

    public Employee findById (String id) {
        for (Employee e : loadEmployees()) {
            if (e.getId().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }

    public void deleteById (String id) {
        List<Employee> employees = loadEmployees();
        employees.removeIf(e -> e.getId().equalsIgnoreCase(id));
        saveEmployees(employees);
    }
}
