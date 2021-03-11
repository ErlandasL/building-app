package com.erlandaslisauskas.buildingback.service;

import com.erlandaslisauskas.buildingback.model.Address;
import com.erlandaslisauskas.buildingback.model.BuildingRecord;
import com.erlandaslisauskas.buildingback.model.Owner;
import com.erlandaslisauskas.buildingback.model.enums.EPropertyType;
import com.erlandaslisauskas.buildingback.payload.request.BuildingRecordRegister;
import com.erlandaslisauskas.buildingback.payload.request.BuildingRequest;
import com.erlandaslisauskas.buildingback.payload.response.MessageResponse;
import com.erlandaslisauskas.buildingback.repository.AddressRepository;
import com.erlandaslisauskas.buildingback.repository.BuildingRecordRepository;
import com.erlandaslisauskas.buildingback.repository.OwnerRepository;
import com.erlandaslisauskas.buildingback.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingRecordService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    @Autowired
    private BuildingRecordRepository buildingRecordRepository;

    @Transactional
    public ResponseEntity<?> registerBuildingRecord(BuildingRecordRegister brr) {

        Owner owner = ownerRepository.findByPersonalNumber(brr.getOwnerPersonalNumber());
        if(owner == null) {
            Owner newOwner = new Owner(brr.getOwnerPersonalNumber(), brr.getOwnerFirstName(), brr.getOwnerLastName());
            ownerRepository.save(newOwner);
        }

        Address address = new Address(brr.getAddressCity(), brr.getAddressStreet(), brr.getAddressNumber());

        BuildingRecord br = new BuildingRecord(brr.getSizeInSquareMeters(), brr.getMarketValue(), ownerRepository.findByPersonalNumber(brr.getOwnerPersonalNumber()), address);

        switch (brr.getPropertyTypeName()) {
            case "Apartment":
                br.setPropertyType(propertyTypeRepository.findByName(EPropertyType.APARTMENT).get());
                break;
            case "House":
                br.setPropertyType(propertyTypeRepository.findByName(EPropertyType.HOUSE).get());
                break;
            case "Industrial":
                br.setPropertyType(propertyTypeRepository.findByName(EPropertyType.INDUSTRIAL).get());
                break;
            default:
                new MessageResponse("Property not exists");
        }

        if(br.getPropertyType().toString().isEmpty()) {
            new MessageResponse("No property in Building record");
        } else {
            buildingRecordRepository.save(br);
        }
        address.setBuildingRecord(br);
        addressRepository.save(address);

        return ResponseEntity.ok(new MessageResponse("Building record successfully registered"));
    }

    @Transactional
    public List<BuildingRequest> getBuildingRecords() {
        return buildingRecordRepository.findAll().stream().map(isdb -> new BuildingRequest(isdb.getId(), isdb.getAddress().getCity(),
                isdb.getAddress().getStreet(), isdb.getAddress().getNumber(), isdb.getOwner().getPersonalNumber(), isdb.getOwner().getFirstName(),
                isdb.getOwner().getLastName(), isdb.getSizeInSquareMeters(), isdb.getMarketValue(), isdb.getPropertyType().toString()))
                .collect(Collectors.toList());
    }

    @Transactional
    public double calculateTaxForOwner(String ownerPersonalNumber) {
        Owner owner = ownerRepository.findByPersonalNumber(ownerPersonalNumber);


        List <Double> listOfSeperateValues = owner.getRecords().stream()
                .map(rec -> rec.getMarketValue() * rec.getPropertyType().getTaxRate())
                .collect(Collectors.toList());


        return listOfSeperateValues.stream().mapToDouble(Double::doubleValue).sum();
    }

    @Transactional
    public ResponseEntity<?> deleteBuildingRecordById(Long id) {
        buildingRecordRepository.deleteById(id);

        return ResponseEntity.ok(new MessageResponse("Building record deleted!"));
    }

    @Transactional
    public ResponseEntity<BuildingRequest> getBuildingRecordById(Long id) {

       BuildingRequest br = buildingRecordRepository.findAll().stream().filter(isdb -> isdb.getId().equals(id))
                .map(isdb -> new BuildingRequest(isdb.getId(), isdb.getAddress().getCity(),
                        isdb.getAddress().getStreet(), isdb.getAddress().getNumber(), isdb.getOwner().getPersonalNumber(), isdb.getOwner().getFirstName(),
                        isdb.getOwner().getLastName(), isdb.getSizeInSquareMeters(), isdb.getMarketValue(), isdb.getPropertyType().toString()))
                .findFirst().get();



        return ResponseEntity.ok(br);
    }

    @Transactional
    public ResponseEntity<?> updateBuildingRecord(Long id, BuildingRecordRegister brr) {

        BuildingRecord br = buildingRecordRepository.getById(id);

        br.getAddress().setCity(brr.getAddressCity());
        br.getAddress().setStreet(brr.getAddressStreet());
        br.getAddress().setNumber(brr.getAddressNumber());
        br.getOwner().setFirstName(brr.getOwnerFirstName());
        br.getOwner().setLastName(brr.getOwnerLastName());
        br.getOwner().setPersonalNumber(brr.getOwnerPersonalNumber());
        br.setSizeInSquareMeters(brr.getSizeInSquareMeters());
        br.setMarketValue(brr.getMarketValue());

        switch (brr.getPropertyTypeName()) {
            case "Apartment":
                br.setPropertyType(propertyTypeRepository.findByName(EPropertyType.APARTMENT).get());
                break;
            case "House":
                br.setPropertyType(propertyTypeRepository.findByName(EPropertyType.HOUSE).get());
                break;
            case "Industrial":
                br.setPropertyType(propertyTypeRepository.findByName(EPropertyType.INDUSTRIAL).get());
                break;
            default:
                new MessageResponse("Property not exists");
        }

        buildingRecordRepository.save(br);

        return ResponseEntity.ok(new MessageResponse("Building Record updated"));

    }
}
