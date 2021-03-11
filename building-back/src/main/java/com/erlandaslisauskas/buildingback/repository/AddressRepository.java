package com.erlandaslisauskas.buildingback.repository;

import com.erlandaslisauskas.buildingback.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByCity(String city);
}
