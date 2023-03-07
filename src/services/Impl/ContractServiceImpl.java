package services.Impl;



import models.Booking;
import models.Contract;
import models.Customer;
import services.ContractService;
import utils.ReadAndWrite;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    static List<Contract> contractList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    @Override
    public void display() {
        contractList = (List<Contract>) ReadAndWrite.read("C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\contracts.csv");
        for (Contract contract : contractList) {
            System.out.println(contract);
        }
    }

    @Override
    public void addNew() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = BookingServiceImpl.sendBooking();
        bookingQueue.addAll(bookingSet);
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            Customer customer = booking.getCustomer();
            System.out.println("creating a contract for " + booking);
            System.out.println("Enter contract code");
            int contractCode = 0;
            while (contractCode != 0) {
                try {
                    contractCode = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Import bad format, please enter back");
                }
            }
            System.out.println("Enter money paid");
            int deposit = 0;
            while (deposit != 0) {
                try {
                    deposit = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Import bad format, please enter back");
                }
            }
            System.out.println("Enter total money");
            int totalMoney = 0;
            while (totalMoney != 0) {
                try {
                    totalMoney = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Import bad format, please enter back");
                }
            }
            Contract contract = new Contract(booking, contractCode, deposit, totalMoney);
            contractList.add(contract);
            System.out.println("create a successful contract");
            ReadAndWrite.write(contractList, "C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\contracts.csv");
        }
    }

    public Contract isContract(int contractCode) {
        for (Contract contract : contractList) {
            if (contract.getContractCode() == contractCode) {
                return contract;
            }
        }
        return null;
    }

    @Override
    public void edit() {
        System.out.println("Enter contract code:");
        int contractCode = Integer.parseInt(input.nextLine());
        Contract contract = isContract(contractCode);
        if (contract != null) {
            System.out.println("1. edit  deposit: ");
            System.out.println("2. edit total money: ");
            System.out.println("3. display list contracts: ");
            System.out.println("Enter choice: ");
            int choice = 1;
            Booking booking;
            int deposit;
            int totalMoney;
            while (choice != 0) {
                try {
                    choice = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Import bad format, please enter back");
                }
                switch (choice) {
                    case 1:
                        System.out.println("Enter new deposit:");
                        deposit = Integer.parseInt(input.nextLine());
                        contract.setDeposit(deposit);
                        display();
                        break;
                    case 2:
                        System.out.println("Enter new total money:");
                        totalMoney = Integer.parseInt(input.nextLine());
                        input.nextLine();
                        contract.setTotalMoney(totalMoney);
                        display();
                        break;

                    case 3:
                        display();
                        break;
                }
            }
        } else {
            System.out.println("Id not found");
            edit();
        }
        ReadAndWrite.write(contractList, "C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\contracts.csv");
    }

    @Override
    public void delete() {

    }
}
