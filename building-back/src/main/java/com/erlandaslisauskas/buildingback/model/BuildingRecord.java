package com.erlandaslisauskas.buildingback.model;

import javax.persistence.*;

@Entity
public class BuildingRecord {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "address")
    private Address address;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "owner")
    private Owner owner;

    private double sizeInSquareMeters;
    private int marketValue;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinTable(name = "building_property", joinColumns = @JoinColumn(name = "building_id"), inverseJoinColumns = @JoinColumn(name = "property_id"))
    private PropertyType propertyType;

    public BuildingRecord(double sizeInSquareMeters, int marketValue, Owner owner, Address address) {
        this.sizeInSquareMeters = sizeInSquareMeters;
        this.marketValue = marketValue;
        this.owner = owner;
        this.address = address;
    }

    public BuildingRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public double getSizeInSquareMeters() {
        return sizeInSquareMeters;
    }

    public void setSizeInSquareMeters(double sizeInSquareMeters) {
        this.sizeInSquareMeters = sizeInSquareMeters;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }
}
