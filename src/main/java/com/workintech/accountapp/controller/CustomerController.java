package com.workintech.accountapp.controller;

import com.workintech.accountapp.dto.CustomerResponse;
import com.workintech.accountapp.entity.Address;
import com.workintech.accountapp.entity.Customer;
import com.workintech.accountapp.service.CustomerService;
import com.workintech.accountapp.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<CustomerResponse> findAll() {
        return EntityConverter.findResults(customerService.findAll());
    }

    @GetMapping("/{id}")
    public CustomerResponse find(@PathVariable long id) {
        return EntityConverter.findResult(customerService.find(id));
    }

    @PostMapping("/")
    public CustomerResponse save(@RequestBody Customer customer) {
        return EntityConverter.findResult(customerService.save(customer));
    }

    @PutMapping("/{id}")
    public CustomerResponse save(@RequestBody Customer customer, @PathVariable long id) {
        Customer foundCustomer = customerService.find(id);
        if (foundCustomer != null) {
            customer.setId(id);
            return EntityConverter.findResult(customerService.save(customer));
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public CustomerResponse remove(@PathVariable long id) {
        return EntityConverter.findResult(customerService.delete(id));
    }
}
