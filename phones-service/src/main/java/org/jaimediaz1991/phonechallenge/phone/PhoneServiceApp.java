package org.jaimediaz1991.phonechallenge.phone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EntityScan({"org.jaimediaz1991.phonechallenge.commons.model.entity"})
@SpringBootApplication
public class PhoneServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(PhoneServiceApp.class, args);
    }
}
