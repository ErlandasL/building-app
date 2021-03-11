package com.erlandaslisauskas.buildingback.building;

import com.erlandaslisauskas.buildingback.model.Address;
import com.erlandaslisauskas.buildingback.model.BuildingRecord;
import com.erlandaslisauskas.buildingback.model.Owner;
import com.erlandaslisauskas.buildingback.repository.AddressRepository;
import com.erlandaslisauskas.buildingback.repository.BuildingRecordRepository;
import com.erlandaslisauskas.buildingback.repository.OwnerRepository;
import com.erlandaslisauskas.buildingback.service.BuildingRecordService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BuildingServiceTests {

    @Autowired
    private BuildingRecordService brs;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private BuildingRecordRepository brr;

    @BeforeEach
    public void setUp() {
        brr.deleteAll();
    }

    @Test
    public void deleteBuildingRecordByIdTest() {
        Owner owner = new Owner("testNum", "TestFirstName", "TestLastName");
        ownerRepository.save(owner);
        Address address = new Address("testCity", "testStreet", "testNum");
        addressRepository.save(address);
        BuildingRecord br = new BuildingRecord(100, 100, owner, address);
        brr.save(br);
        brs.deleteBuildingRecordById(br.getId());

        Assertions.assertEquals(0, brr.findAll().size());
    }

}
