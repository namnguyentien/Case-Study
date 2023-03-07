package services.Impl;



import models.Customer;
import services.CustomerService;
import utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer("Nguyen Van A", "23/04/1994", "Nam", 184654768, "0971367456", "nguyenvana@gmail.com", 106170011, 2, "Quan Hai Chau, Da Nang"));
        customerList.add(new Customer("Pham Thi B", "23/5/1994", "Nu", 184465876, "0971365876", "phamthib@gmail.com", 106170012, 1, "Quan thanh khe, Da Nang"));
    }

    static Scanner scanner = new Scanner(System.in);

    @Override
    public Customer isCustomer(int customerCode) {
        for (Customer customer : customerList) {
            if (customer.getCustomerCode() == customerCode) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void display() {
        customerList = (List<Customer>) ReadAndWrite.read("C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\customers.csv");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addNew() {
        System.out.println("Enter name :");
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
        System.out.println("Enter customerCode :");
        int customerCode = 0;
        System.out.println("Enter customerType :");
        try {
            customerCode = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        int customerType = 0;
        try {
            customerType = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter address :");
        String address = scanner.nextLine();
        customerList.add(new Customer(name,dateOfBirth,sex,identityCardNumber,telephoneNumber,email,customerCode,customerType,address));
        ReadAndWrite.write(customerList, "C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\customers.csv");
    }
    @Override
    public void edit() {
        System.out.println("Enter customer:");
        int customerCode = 0;
        try {
            customerCode = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        Customer customer = isCustomer(customerCode);
    if (customer != null){
        System.out.println("Enter choice: ");
        System.out.println("1. TelephoneNumber:  ");
        System.out.println("2. Email: ");
        System.out.println("3. customerType: ");
        System.out.println("4. address: ");
        System.out.println("5. displayListCustomer: ");
        int choice = 1;
        String telephoneNumber;
        String email;
        int customerType;
        String address;
        while (choice != 0) {
            choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Import bad format, please enter back");
            }
            switch (choice) {
                case 1:
                    System.out.println("Enter new TelephoneNumber:");
                    telephoneNumber = scanner.nextLine();
                    customer.setTelephoneNumber(telephoneNumber);
                    display();
                    break;
                case 2:
                    System.out.println("Enter new email:");
                    email = scanner.nextLine();
                    customer.setEmail(email);
                    display();
                    break;
                case 3:
                    System.out.println("Enter new degree:");
                    customerType = 0;
                    try {
                        customerType = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Import bad format, please enter back");
                    }
                    customer.setCustomerType(customerType);
                    display();
                    break;
                case 4:
                    System.out.println("Enter new position:");
                    address = scanner.nextLine();
                    customer.setAddress(address);
                    display();
                    break;
                case 6:
                    display();
                    break;
            }
        }
    }
        ReadAndWrite.write(customerList, "C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\customers.csv");
    }
    @Override
    public void delete() {
        System.out.println("Enter ");
    }
}
