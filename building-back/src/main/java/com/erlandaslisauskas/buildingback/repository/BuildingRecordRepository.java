package com.erlandaslisauskas.buildingback.repository;

import com.erlandaslisauskas.buildingback.model.BuildingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRecordRepository extends JpaRepository<BuildingRecord, Long> {
    BuildingRecord getById(Long id);
}
