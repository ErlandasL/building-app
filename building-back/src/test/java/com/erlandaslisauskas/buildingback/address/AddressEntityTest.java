package com.erlandaslisauskas.buildingback.address;

import com.erlandaslisauskas.buildingback.model.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressEntityTest {

    @Test
    public void addressEntityTest() {
        Address address = new Address("cityTest", "streetTest", "1");

        Assertions.assertEquals("cityTest", address.getCity());
    }
}
