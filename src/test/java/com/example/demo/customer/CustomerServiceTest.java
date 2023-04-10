package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;
    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
         customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer jamila = new Customer(1L, "jamila", "123qwer", "jamila@mail.ru");
        Customer jack = new Customer(2L, "jack", "123qwer", "jack@mail.ru");
        customerRepository.saveAll(Arrays.asList(jamila, jack));
        List<Customer> customers = underTest.getCustomers();
        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        Customer jamila = new Customer(1L, "jamila", "123qwer", "jamila@mail.ru");
        Customer save = customerRepository.save(jamila);

        underTest.getCustomer(1L);
        assertEquals(1L, save.getId());
        assertEquals("jamila", save.getName());
        assertEquals("123qwer", save.getPassword());
        assertEquals("jamila@mail.ru", save.getEmail());



    }
}