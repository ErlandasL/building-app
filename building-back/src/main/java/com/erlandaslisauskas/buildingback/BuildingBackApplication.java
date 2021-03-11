package com.erlandaslisauskas.buildingback;

import com.erlandaslisauskas.buildingback.model.PropertyType;
import com.erlandaslisauskas.buildingback.model.enums.EPropertyType;
import com.erlandaslisauskas.buildingback.repository.AddressRepository;
import com.erlandaslisauskas.buildingback.repository.BuildingRecordRepository;
import com.erlandaslisauskas.buildingback.repository.OwnerRepository;
import com.erlandaslisauskas.buildingback.repository.PropertyTypeRepository;
import com.erlandaslisauskas.buildingback.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class BuildingBackApplication implements CommandLineRunner {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private PropertyTypeRepository propertyTypeRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private BuildingRecordRepository buildingRecordRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Bean
    public Docket swaggerDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.erlandaslisauskas")).build();
    }
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Internship task").version("0.0.1-SNAPSHOT").build();
    }


    public static void main(String[] args) {
        SpringApplication.run(BuildingBackApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(propertyTypeRepository.findByName(EPropertyType.APARTMENT).isEmpty()) {
            PropertyType propertyTypeApartment = new PropertyType(EPropertyType.APARTMENT);
            propertyTypeRepository.save(propertyTypeApartment);
        }
        if(propertyTypeRepository.findByName(EPropertyType.HOUSE).isEmpty()) {
            PropertyType propertyTypeHouse = new PropertyType(EPropertyType.HOUSE);
            propertyTypeRepository.save(propertyTypeHouse);
        }
        if(propertyTypeRepository.findByName(EPropertyType.INDUSTRIAL).isEmpty()) {
            PropertyType propertyTypeIndustrial = new PropertyType(EPropertyType.INDUSTRIAL);
            propertyTypeRepository.save(propertyTypeIndustrial);
        }

//        Owner owner = new Owner("AK321", "John", "Doe");
//        ownerRepository.save(owner);
//        BuildingRecord buildingRecord = new BuildingRecord(30, 60000);
//        buildingRecord.setPropertyType(propertyTypeRepository.findByName(EPropertyType.APARTMENT).get());
//        Address ozo1 = new Address("Vilnius", "Ozo", "1");
//        addressRepository.save(ozo1);
//        ozo1.setBuildingRecord(buildingRecordRepository.getById(buildingRecord.getId()));
//        buildingRecord.setAddress(addressRepository.findByCity("Vilnius"));
//        addressRepository.save(ozo1);
//        buildingRecordRepository.save(buildingRecord);
//        buildingRecord.setOwner(ownerRepository.findByPersonalNumber("AK321"));
//        buildingRecordRepository.save(buildingRecord);
//        owner.getRecords().add(buildingRecord);

//        ownerRepository.save(owner);
//        double value = ownerService.calculateTax("AK321");
//        System.out.println(ownerService.calculateTax("AK321"));
    }
}
