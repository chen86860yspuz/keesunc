package me.whiteship.ksug2019.study;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MemberServiceClient {

    private RestTemplate restTemplate;

    public MemberServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .rootUri("http://localhost:18081/member").build();
    }


    public void validate(Integer memberId) {
        ResponseEntity<String> response = restTemplate.getForEntity("/id/{memberId}", String.class, memberId);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new IllegalArgumentException("wrong member id '" + memberId + "'");
        }
    }
}