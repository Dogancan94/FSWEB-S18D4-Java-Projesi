package com.workintech.accountapp.service;

import com.workintech.accountapp.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer find(long id);
    Customer save(Customer customer);
    Customer delete(long id);
}
