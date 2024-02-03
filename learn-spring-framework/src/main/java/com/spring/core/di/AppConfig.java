package com.spring.core.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // -- This will tell SIOCC that this class has IOC configurations.
@ComponentScan(basePackages = "com.spring.core.di") // -- Specify which package to Scan for beans. It will create beans for all classes annotated with @Component
public class AppConfig {
}
