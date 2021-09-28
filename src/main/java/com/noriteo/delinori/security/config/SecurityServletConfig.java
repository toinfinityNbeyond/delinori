package com.noriteo.delinori.security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
@ComponentScan(basePackages = "com.noriteo.delinori.security.controller")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityServletConfig {
}
