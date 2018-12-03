package com.demo.cloud.servicehi;

import com.demo.cloud.openapi.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication implements SchedualServiceHi {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @Override
    @PreAuthorize("hasRole('ROLE_USER')")
    public String sayHiFromClientOne(String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
