package dev.sxardas.infraconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class InfraConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfraConfigApplication.class, args);
    }

}
