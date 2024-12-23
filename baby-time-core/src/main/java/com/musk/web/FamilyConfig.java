package com.musk.web;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "business.family")
@Data
public class FamilyConfig {
    private String familyBackgroundUrl;
}
