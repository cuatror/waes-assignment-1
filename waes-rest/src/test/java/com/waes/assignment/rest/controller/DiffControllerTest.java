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


public class DiffControllerTest extends BaseController {

    public static final String BASE_URL = "/v1/diff";

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void should_save_right_diff() {
        DiffBase64 diffBase64 = new DiffBase64("d2Flcy10ZXN0ZQ==");
        ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL + "/4/right", diffBase64, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
    }

    @Test
    public void should_save_left_diff() {
        DiffBase64 diffBase64 = new DiffBase64("c2hvdWxkIHNhdmUgcmlnaHQ=");
        ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL + "/4/left", diffBase64, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
    }

    @Test
    public void should_save_right_and_left_diff() {
        DiffBase64 diffBase64 = new DiffBase64("c2hvdWxkIHNhdmUgcmlnaHQ=");
        ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL + "/4/left", diffBase64, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));

        ResponseEntity<String> response2 = restTemplate.postForEntity(BASE_URL + "/4/right", diffBase64, String.class);
        assertThat(response2.getStatusCode(), equalTo(HttpStatus.CREATED));
    }

    @Test
    public void should_get_diff() {
        DiffBase64 diffBase64 = new DiffBase64("c2hvdWxkIHNhdmUgcmlnaHQ=");
        ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL + "/4/left", diffBase64, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));

        ResponseEntity<String> response2 = restTemplate.postForEntity(BASE_URL + "/4/right", diffBase64, String.class);
        assertThat(response2.getStatusCode(), equalTo(HttpStatus.CREATED));
    }



    @Test
    public void getDiff() throws Exception {
    }

}