package com.erlandaslisauskas.buildingback.repository;

import com.erlandaslisauskas.buildingback.model.PropertyType;
import com.erlandaslisauskas.buildingback.model.enums.EPropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {
    Optional<PropertyType> findByName(EPropertyType name);
}
