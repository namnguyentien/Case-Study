package services;


import models.Customer;

public interface CustomerService extends Service {
    public Customer isCustomer(int customerCode);
}
