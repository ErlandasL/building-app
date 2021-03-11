package com.erlandaslisauskas.buildingback.service;

import com.erlandaslisauskas.buildingback.model.Owner;
import com.erlandaslisauskas.buildingback.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Transactional
    public double calculateTax(String ownerPersonalNumber) {
        Owner owner = ownerRepository.findByPersonalNumber(ownerPersonalNumber);


        List <Double> listOfSeperateValues = owner.getRecords().stream()
                .map(rec -> rec.getMarketValue() * rec.getPropertyType().getTaxRate())
                .collect(Collectors.toList());


        return listOfSeperateValues.stream().mapToDouble(Double::doubleValue).sum();
    }

}
