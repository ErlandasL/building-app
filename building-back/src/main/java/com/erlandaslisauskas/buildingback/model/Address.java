package com.erlandaslisauskas.buildingback.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String city;

    @NotEmpty
    private String street;

    @NotEmpty
    private String number;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buildingRecord")
    private BuildingRecord buildingRecord;

    public Address(String city, String street, String number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public Address() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BuildingRecord getBuildingRecord() {
        return buildingRecord;
    }

    public void setBuildingRecord(BuildingRecord buildingRecord) {
        this.buildingRecord = buildingRecord;
    }
}
