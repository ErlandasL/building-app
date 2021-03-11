package com.erlandaslisauskas.buildingback.building;

import com.erlandaslisauskas.buildingback.model.Address;
import com.erlandaslisauskas.buildingback.model.BuildingRecord;
import com.erlandaslisauskas.buildingback.model.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BuildingEntityTest {

    @Test
    public void buildingEntityTest() {
        Owner owner = new Owner("testNum", "TestFirstName", "TestLastName");
        Address address = new Address("testCity", "testStreet", "testNum");

        BuildingRecord br = new BuildingRecord(100, 100, owner, address);

        assertEquals(address, br.getAddress());
    }
}
