package com.erlandaslisauskas.buildingback.building;

import com.erlandaslisauskas.buildingback.payload.request.BuildingRecordRegister;
import com.erlandaslisauskas.buildingback.repository.BuildingRecordRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class BuildingCreateMockTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private BuildingRecordRepository brepo;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void createBuildingRecordTest() throws Exception {
        BuildingRecordRegister brr = new BuildingRecordRegister("testCity", "testStreet", "testNum", "testPN", "testFN", "testLN", 100, 100, "House");


        String jsonRequest = objectMapper.writeValueAsString(brr);

        MvcResult result = mockMvc.perform(post("/api/record/create")
                .content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();

        String resultContext = result.getResponse().getContentAsString();

        Assertions.assertEquals(1, brepo.findAll().size());

    }

}
