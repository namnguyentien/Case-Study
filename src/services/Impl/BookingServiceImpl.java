package services.Impl;


import models.Booking;
import models.Customer;
import models.Facility;
import models.Villa;
import services.BookingService;
import utils.ReadAndWrite;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Scanner input = new Scanner(System.in);
    static Set<Booking> bookings = new TreeSet<>(new Booking());
    static List<Customer> customerList = new ArrayList<>();
    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    static {
        customerList.add(new Customer("Nguyen Van A", "23/04/1994", "Nam", 186634768,
                "0976406034", "nguyenvana@gmail.com", 106170075, 2, "Quan Hai Chau, Da Nang"));
        customerList.add(new Customer("Nguyen Van B", "21/4/1999", "Nam", 184244678,
                "0972435846", "nguyenvanb@gmail.com", 1061700177, 1, "Quan Hai Chau, Da Nang"));
        facilityIntegerMap.put(new Villa("villa 1", 200, 3000000, 5,
                "ngày", "villa cao cấp", 50, 2), 0);
        facilityIntegerMap.put(new Villa("villa 2", 250, 4000000, 6,
                "ngày", "villa cao cấp", 50, 2), 0);
    }
    @Override
    public void display() {
        ReadAndWrite.read("C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\booking.csv");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
    public static Customer chooseCustomer() {
        System.out.println("Display customer: ");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        System.out.println("Enter customer code");
        boolean check = true;
        int customerCode = 0;
        try {
            customerCode = Integer.parseInt(input.nextLine());
        }catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        while (check) {
            for (Customer customer : customerList) {
                if (customerCode == customer.getCustomerCode()) {
                    check = false;
                    return customer;
                }
            }
            if (check) {
                System.out.println("Enter customer code");
                try {
                    customerCode = Integer.parseInt(input.nextLine());
                }catch (NumberFormatException e) {
                    System.out.println("Import bad format, please enter back");
                }
            }
        }
        return null;
    }
    public static Facility chooseFacility() {
        System.out.println("Display facility: ");
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println("Enter again service Name");
        boolean check = true;

        String serviceName = input.nextLine();
        while (check) {
            for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
                if (serviceName.equals(entry.getKey().getServiceName())) {
                    check = false;
                    return entry.getKey();
                }
            }
            if (check) {
                System.out.println("Enter again service Name");
                serviceName = input.nextLine();
            }
        }
        return null;
    }
    @Override
    public void addNew() {
        int id = 1;
        if (!bookings.isEmpty()) {
            id = bookings.size() + 1;
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        System.out.println("Enter start date rent :");
        String startDay = input.nextLine();
        System.out.println("Enter check-out date :");
        String endDay = input.nextLine();
        Booking booking = new Booking(id, startDay, endDay, customer, facility);
        bookings.add(booking);
        System.out.println("Add booking success");
        ReadAndWrite.write(bookings, "C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\booking.csv");
    }
    public static Facility chooseFacility(String service) {
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            if (service.equals(entry.getKey().getServiceName())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static Customer chooseCustomer(int customerCode) {
        for (Customer customer : customerList) {
            if (customerCode == customer.getCustomerCode()) {
                return customer;
            }
        }
        return null;
    }
    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
    public static Set<Booking> sendBooking() {
        return bookings;
    }
}

