package com.erlandaslisauskas.buildingback.payload.request;

public class BuildingRequest {

    private Long id;
    private String addressCity;
    private String addressStreet;
    private String addressNumber;
    private String ownerPersonalNumber;
    private String ownerFirstName;
    private String ownerLastName;
    private double sizeInSquareMeters;
    private int marketValue;
    private String propertyTypeName;

    public BuildingRequest(Long id, String addressCity, String addressStreet, String addressNumber, String ownerPersonalNumber, String ownerFirstName, String ownerLastName, double sizeInSquareMeters, int marketValue, String propertyTypeName) {
        this.id = id;
        this.addressCity = addressCity;
        this.addressStreet = addressStreet;
        this.addressNumber = addressNumber;
        this.ownerPersonalNumber = ownerPersonalNumber;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.sizeInSquareMeters = sizeInSquareMeters;
        this.marketValue = marketValue;
        this.propertyTypeName = propertyTypeName;
    }

    public BuildingRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getOwnerPersonalNumber() {
        return ownerPersonalNumber;
    }

    public void setOwnerPersonalNumber(String ownerPersonalNumber) {
        this.ownerPersonalNumber = ownerPersonalNumber;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public double getSizeInSquareMeters() {
        return sizeInSquareMeters;
    }

    public void setSizeInSquareMeters(int sizeInSquareMeters) {
        this.sizeInSquareMeters = sizeInSquareMeters;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

    public String getPropertyTypeName() {
        return propertyTypeName;
    }

    public void setPropertyTypeName(String propertyTypeName) {
        this.propertyTypeName = propertyTypeName;
    }
}
