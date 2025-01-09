package org.example.laborator11.service;

import org.example.laborator11.model.Address;
import org.example.laborator11.respository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }
}
