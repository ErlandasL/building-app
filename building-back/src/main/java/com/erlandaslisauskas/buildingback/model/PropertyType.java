package com.erlandaslisauskas.buildingback.model;

import com.erlandaslisauskas.buildingback.model.enums.EPropertyType;

import javax.persistence.*;

@Entity
@Table(name = "properties")
public class PropertyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EPropertyType name;

    public PropertyType() {

    }

    public PropertyType(EPropertyType name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EPropertyType getName() {
        return name;
    }

    public void setName(EPropertyType name) {
        this.name = name;
    }

    public double getTaxRate() {
      if(name == EPropertyType.HOUSE) {
          return 0.01;
      }
      if(name == EPropertyType.APARTMENT) {
          return 0.008;
      }
      else {
          return 0.02;
      }
    }

    @Override
    public String toString() {
        if(name == EPropertyType.INDUSTRIAL) {
            return "Industrial";
        }
        else if(name == EPropertyType.HOUSE) {
            return "House";
        }
        else return "Apartment";
    }
}
