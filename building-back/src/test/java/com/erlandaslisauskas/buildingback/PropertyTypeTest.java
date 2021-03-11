package com.erlandaslisauskas.buildingback;

import com.erlandaslisauskas.buildingback.repository.PropertyTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PropertyTypeTest {

    @Autowired
    private PropertyTypeRepository ptr;

    @Test
    public void appCreatesThreePropertyTypesTest() {
        Assertions.assertEquals(3, ptr.findAll().size());
    }
}
