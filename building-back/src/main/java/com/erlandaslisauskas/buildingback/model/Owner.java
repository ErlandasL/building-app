package com.erlandaslisauskas.buildingback.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {

    @Id
    @GeneratedValue
    private Long id;

    private String personalNumber;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "owner", fetch = FetchType.LAZY)
    private List<BuildingRecord> records;

    public Owner(String personalNumber, String firstName, String lastName) {
        this.personalNumber = personalNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Owner() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<BuildingRecord> getRecords() {
        return records;
    }

    public void setRecords(List<BuildingRecord> records) {
        this.records = records;
    }
}
