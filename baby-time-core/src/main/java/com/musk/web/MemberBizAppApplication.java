package com.musk.web;

import org.example.musk.framework.tenant.config.TenantConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.musk","org.example.musk"})
@EnableScheduling
@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = {"com.musk","org.example.musk"})
public class MemberBizAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberBizAppApplication.class, args);
    }

}
