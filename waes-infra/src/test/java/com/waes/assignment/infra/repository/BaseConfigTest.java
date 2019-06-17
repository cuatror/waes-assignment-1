package com.waes.assignment.infra.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

/**
 * Configure package scan for entity package and initialize JPA EntityManager on test scope.
 */
@DataJpaTest
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.waes.assignment.infra.repository")
public class BaseConfigTest {
}
