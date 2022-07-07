package services.Impl;


import models.Booking;
import models.Customer;
import services.PromotionService;

import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class PromotionServiceImpl implements PromotionService {
    static Set<Booking> bookingSet = BookingServiceImpl.sendBooking();
    static Scanner input = new Scanner(System.in);

    static {
        bookingSet.add(new Booking(4, "10/02/2021", "08/03/2021", BookingServiceImpl.chooseCustomer(106170013), BookingServiceImpl.chooseFacility("villa 4")));
        bookingSet.add(new Booking(5, "10/03/2021", "15/03/2021", BookingServiceImpl.chooseCustomer(106170011), BookingServiceImpl.chooseFacility("villa 1")));
        bookingSet.add(new Booking(6, "24/07/2021", "30/07/2021", BookingServiceImpl.chooseCustomer(106170013), BookingServiceImpl.chooseFacility("villa 2")));
        bookingSet.add(new Booking(7, "15/02/2021", "20/02/2021", BookingServiceImpl.chooseCustomer(106170011), BookingServiceImpl.chooseFacility("villa 3")));
        bookingSet.add(new Booking(8, "26/11/2021", "29/11/2021", BookingServiceImpl.chooseCustomer(106170013), BookingServiceImpl.chooseFacility("villa 1")));
    }

    static int voucher10 = 0;
    static int voucher20 = 0;
    static int voucher50 = 0;

    @Override
    public void displayListCustomersUseService() {
        System.out.println("Enter year: ");
        String year = input.nextLine();
        boolean check = true;
        for (Booking booking : bookingSet) {
            String[] strings = booking.getFirstDay().split("/");
            String[] strings1 = booking.getLastDay().split("/");
            if (strings[2].equals(year) || strings1[2].equals(year)) {
                System.out.println(booking.getCustomer());
                check = false;
            }
        }
        if (check) {
            System.out.println("Has no customer in this year");
        }
    }

    @Override
    public void displayListCustomersGetVoucher() {
        Stack<Booking> bookingStack = new Stack<>();
        int sum = 0;
        System.out.println("Number of booking " + bookingSet.size());
        while (bookingSet.size() != sum) {
            System.out.println("Enter quantity voucher 10%: ");
            try {
                voucher10 = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Import bad format, please enter back");
            }
            System.out.println("Enter quantity voucher 20%: ");
            try {
                voucher20 = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Import bad format, please enter back");
            }
            System.out.println("Enter quantity voucher 50%: ");
            try {
                voucher50 = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Import bad format, please enter back");
            }
            sum = voucher10 + voucher20 + voucher50;
        }
        bookingStack.addAll(bookingSet);
        while (!bookingStack.isEmpty() && voucher10 > 0) {
            Booking booking = bookingStack.pop();
            Customer customer = booking.getCustomer();
            System.out.println("Customer received voucher 10%:" + customer);
            voucher10--;
        }
        while (!bookingStack.isEmpty() && voucher20 > 0) {
            Booking booking = bookingStack.pop();
            Customer customer = booking.getCustomer();
            System.out.println("Customer received voucher 20%:" + customer);
            voucher20--;
        }
        while (!bookingStack.isEmpty() && voucher50 > 0) {
            Booking booking = bookingStack.pop();
            Customer customer = booking.getCustomer();
            System.out.println("Customer received voucher 50%:" + customer);
            voucher50--;
        }
    }
}

