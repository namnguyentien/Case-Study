package services.Impl;


import models.Employee;
import services.EmployeeService;
import utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    static {
        employeeList.add(new Employee("Nguyen Dinh Hung Anh", "24/3/1999", "Nam", 184584932, "0868338441", "nguyendinhhunganh99@gmail.com", 106170091, 2, 5, 50000000 ));
        employeeList.add(new Employee("Bui Thi Hoa", "08/5/1999", "Nu", 184584935, "0971356478", "khanhhoa8599@gmail.com", 106170092, 2, 4, 30000000 ));
    }
    @Override
    public void display() {
        employeeList = (List<Employee>) ReadAndWrite.read("C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\employees.csv");
        for(Employee employee: employeeList){
            System.out.println(employee.toString());
        }
    }

    @Override
    public void addNew() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter dateOfBirth :");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Enter sex :");
        String sex = scanner.nextLine();
        System.out.println("Enter identityCardNumber :");
        int identityCardNumber = 0;
        try {
            identityCardNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter telephoneNumber :");
        String telephoneNumber = scanner.nextLine();
        System.out.println("Enter email :");
        String email = scanner.nextLine();
        System.out.println("Enter employeeCode :");
        int employeeCode = 0;
        try {
            employeeCode = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter level :");
        int level = 0;
        try {
            level = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter position :");
        int position = 0;
        try {
            position = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter salary :");
        float salary = 0;
        try {
            salary = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        employeeList.add(new Employee(name,dateOfBirth,sex,identityCardNumber,telephoneNumber,email,employeeCode,level,position,salary));
        ReadAndWrite.write(employeeList, "C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\employees.csv");
    }

    @Override
    public void edit() {
        System.out.println("Enter employeeCode:");
        int employeeCode = 0;
        try {
            employeeCode = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        Employee employee = isEmployee(employeeCode);
        if (employee != null) {
            System.out.println("Enter choice: ");
            System.out.println("1. TelephoneNumber:  ");
            System.out.println("2. Email: ");
            System.out.println("3. Academic Level: ");
            System.out.println("4. position: ");
            System.out.println("5. salary: ");
            System.out.println("6. displayListEmployees: ");
            int choice = 1;
            String telephoneNumber;
            String email;
            int level = 0;
            int position = 0;
            float salary = 0;
            while (choice != 0) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Import bad format, please enter back");
                }
                switch (choice) {
                    case 1:
                        System.out.println("Enter new TelephoneNumber:");
                        telephoneNumber = scanner.nextLine();
                        employee.setTelephoneNumber(telephoneNumber);
                        display();
                        break;
                    case 2:
                        System.out.println("Enter new email:");
                        email = scanner.nextLine();
                        employee.setEmail(email);
                        display();
                        break;
                    case 3:
                        System.out.println("Enter new level:");
                        try {
                            level = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Import bad format, please enter back");
                        }
                        employee.setAcademicLevel(level);
                        display();
                        break;
                    case 4:
                        System.out.println("Enter new position:");
                        try {
                            position = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Import bad format, please enter back");
                        }
                        employee.setPosition(position);
                        display();
                        break;
                    case 5:
                        System.out.println("Enter new salary:");
                        try {
                            salary = Float.parseFloat(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Import bad format, please enter back");
                        }
                        employee.setSalary(salary);
                        display();
                        break;
                    case 6:
                        display();
                        break;
                }
            }
        } else {
            System.out.println("id not found");
            edit();
        }
        ReadAndWrite.write(employeeList, "C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\employees.csv");
    }

    @Override
    public Employee isEmployee(int employeeCode) {
        for (Employee employee: employeeList){
            if (employee.getEmployeeCode() == employeeCode){
                return employee;
            }
        }
        return null;
    }

    @Override
    public void delete() {

    }
}
