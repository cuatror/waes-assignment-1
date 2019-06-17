package com.waes.assignment.rest.controller;

import com.waes.assigment.domain.dto.DiffBase64;
import org.apache.commons.lang3.builder.DiffResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import org.apache.commons.codec.binary.Base64;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DiffControllerTest {

    public static final String BASE_URL = "/v1/diff";

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void saveRightData() throws Exception {
        DiffBase64 diffBase64 = new DiffBase64("d2Flcy10ZXN0ZQ==");
        ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL + "/4/left", diffBase64, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
    }

    @Test
    public void saveLeftData() throws Exception {
    }

    @Test
    public void getDiff() throws Exception {
    }

}