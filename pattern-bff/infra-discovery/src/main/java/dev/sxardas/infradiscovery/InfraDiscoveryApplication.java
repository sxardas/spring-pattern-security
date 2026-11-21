package dev.sxardas.infradiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class InfraDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfraDiscoveryApplication.class, args);
    }

}
