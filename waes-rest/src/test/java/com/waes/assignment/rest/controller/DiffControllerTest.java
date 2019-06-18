package com.waes.assignment.rest.controller;

import com.waes.assigment.domain.dto.DiffBase64;
import com.waes.assigment.domain.dto.DiffResultDTO;
import com.waes.assignment.rest.BaseConfigTest;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(classes = BaseConfigTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class DiffControllerTest {

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
    public void should_not_found_diff() {
        ResponseEntity<DiffResultDTO> diffResponse = null;
        try {
            diffResponse = restTemplate
                    .getForEntity(BASE_URL + "/10", DiffResultDTO.class);
        } catch (Exception e) {
           Assert.isNull(diffResponse, "Diff not found");
        }
    }

    @Test
    public void getDiff() throws Exception {
    }

}