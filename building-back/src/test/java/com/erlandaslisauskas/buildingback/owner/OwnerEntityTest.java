package com.erlandaslisauskas.buildingback.owner;

import com.erlandaslisauskas.buildingback.model.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OwnerEntityTest {

    @Test
    public void ownerEntityTest() {
        Owner owner = new Owner("ID123", "FirstName", "LastName");
        assertEquals(owner.getPersonalNumber(), "ID123");
    }

}
