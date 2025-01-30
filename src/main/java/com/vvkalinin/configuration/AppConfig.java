package com.vvkalinin.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.vvkalinin"})
@PropertySource(value = {
        "classpath:/properties/common.properties",
        "classpath:/properties/${country}/${country}.properties"
}, ignoreResourceNotFound = true)
public class AppConfig {

}
