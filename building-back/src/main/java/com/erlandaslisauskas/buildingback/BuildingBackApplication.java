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

    }
}
