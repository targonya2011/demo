package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;
public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "James", "password123", "email@gmai.com"),
                new Customer(2L, "Jamila", "123password", "email@gmai.com"),
                new Customer(3L, "Ahmed", "123password123", "email@gmai.com")
        );


    }
}
