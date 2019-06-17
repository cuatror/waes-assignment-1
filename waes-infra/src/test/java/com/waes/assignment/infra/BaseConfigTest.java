package com.waes.assignment.infra;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

@DataJpaTest
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.waes.assignment.infra.repository")
@EntityScan(basePackages = "com.waes.assigment.domain.model")
public class BaseConfigTest {
}
