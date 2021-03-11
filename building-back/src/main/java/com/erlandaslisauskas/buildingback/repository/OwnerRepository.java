package com.erlandaslisauskas.buildingback.repository;

import com.erlandaslisauskas.buildingback.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByPersonalNumber(String number);
    Optional<Owner> findById(Long id);
}
