package com.workintech.accountapp.controller;

import com.workintech.accountapp.entity.Address;
import com.workintech.accountapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address find(@PathVariable long id) {
        return addressService.find(id);
    }

    @PostMapping("/")
    public Address save(@RequestBody Address address) {
        return addressService.save(address);
    }

    @PutMapping("/{id}")
    public Address save(@RequestBody Address address, @PathVariable long id) {
        Address foundAdress = addressService.find(id);
        if (foundAdress != null) {
            address.setId(id);
            return addressService.save(address);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Address remove(@PathVariable long id) {
        return addressService.delete(id);
    }

}
