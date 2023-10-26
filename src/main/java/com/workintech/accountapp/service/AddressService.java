package com.workintech.accountapp.service;

import com.workintech.accountapp.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address find(long id);
    Address save(Address address);
    Address delete(long id);
}
