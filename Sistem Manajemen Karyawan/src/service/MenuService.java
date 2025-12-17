package service;

import model.ContractEmployee;
import model.Employee;
import model.PermanentEmployee;
import repository.EmployeeRepository;

import java.util.List;
import java.util.Scanner;

public class MenuService {
    private final Scanner input = new Scanner (System.in);
    private EmployeeRepository repository = new EmployeeRepository();

    public void start() {
        int choice;

        do {
            showMenu();
            choice = readInt("Pilih menu: ");

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> showEmployees();
                case 3 -> searchEmployee();
                case 4 -> deleteEmployee();
                case 0 -> System.out.println("Keluar program... \nTerima Kasih");
                default -> System.out.println("Pilihan tidak valid (0-4).");
            }
        } while (choice != 0);
    }

    private void addEmployee() {
        List<Employee> employees = repository.loadEmployees();

        System.out.print("ID: ");
        String id = input.nextLine();

        System.out.print("Nama: ");
        String name = input.nextLine();

        System.out.println("1. Tetap");
        System.out.println("2. Kontrak");
        int type = readInt("Jenis: ");

        if (type == 1) {
            double salary = readDouble("Gaji Bulanan: ");
            employees.add(new PermanentEmployee(id, name, salary));
        } else if (type == 2) {
            int hours = readInt("Jam Kerja: ");
            double rate = readDouble("Upah per jam: ");
            employees.add(new ContractEmployee(id, name, hours, rate));
        }

        repository.saveEmployees(employees);
        System.out.println("Karyawan berhasil ditambahkan");
    }

    private void showMenu() {
        System.out.println("\n=== MENU KARYAWAN ===");
        System.out.println("1. Tambah Karyawan");
        System.out.println("2. Tampilkan Semua");
        System.out.println("3. Cari Karyawan (ID)");
        System.out.println("4. Hapus Karyawan");
        System.out.println("0. Keluar");
    }

    private void showEmployees() {
        new EmployeeService(repository).printEmployees();
    }

    private void searchEmployee() {
        System.out.print("Masukkan ID: ");
        String id = input.nextLine();

        Employee e = repository.findById(id);
        if (e == null) {
            System.out.println("Karyawana tidak ditemukan.");
        } else {
            System.out.println(e.getId() + " | " + e.getName() + " | Gaji: " + e.calculateSalary());
        }
    }

    private void deleteEmployee() {
        System.out.print("ID yang dihapus: ");
        String id = input.nextLine();
        repository.deleteById(id);
        System.out.println("Data dihapus (jika ada).");
    }

    // ================
    // Validasi Input
    // ================

    private int readInt (String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus angka!");
            }
        }
    }

    private double readDouble (String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus angka desimal!");
            }
        }
    }
}
