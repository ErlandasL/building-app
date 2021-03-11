package com.erlandaslisauskas.buildingback.controller;

import com.erlandaslisauskas.buildingback.payload.request.BuildingRecordRegister;
import com.erlandaslisauskas.buildingback.payload.request.BuildingRequest;
import com.erlandaslisauskas.buildingback.service.BuildingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/record")
public class BuildingRecordController {

    @Autowired
    private BuildingRecordService buildingRecordService;

    @PostMapping("/create")
    public ResponseEntity<?> registerBuildingRecord(@RequestBody BuildingRecordRegister brr) {
        return buildingRecordService.registerBuildingRecord(brr);
    }

    @GetMapping("/getrecords")
    public List<BuildingRequest> getBuildingRecords() {
        return buildingRecordService.getBuildingRecords();
    }

    @PostMapping("/getownerstax/{personalNumber}")
    public double getOwnersTax(@PathVariable final String personalNumber) {
        return buildingRecordService.calculateTaxForOwner(personalNumber);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBuildingRecordById(@PathVariable Long id) {
        return buildingRecordService.deleteBuildingRecordById(id);
    }

    @GetMapping("/building/{id}")
    public ResponseEntity<BuildingRequest> getBuildingRecordById(@PathVariable Long id) {
        return buildingRecordService.getBuildingRecordById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBuildingRecord(@PathVariable Long id, @RequestBody BuildingRecordRegister brr) {
        return buildingRecordService.updateBuildingRecord(id, brr);
    }

}
