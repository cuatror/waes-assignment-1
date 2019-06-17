package com.waes.assignment.infra;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configure package scan for entity package and initialize JPA EntityManager.
 */
@Configuration
@EntityScan(basePackages = "com.waes.assigment.domain.model")
@EnableJpaRepositories(
        basePackages = "com.waes.assignment.infra.repository"
)
public class BaseConfig {

}
