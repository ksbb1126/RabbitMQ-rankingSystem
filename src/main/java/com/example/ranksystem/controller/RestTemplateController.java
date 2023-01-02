package com.example.ranksystem.controller;

import com.example.ranksystem.domain.ExamDTO;
import com.example.ranksystem.domain.QueueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {
    @Autowired
    RestTemplate restTemplate;

    public String request(@PathVariable String name) {
        System.out.println("RestTemplate으로 데이터 요청");
        System.out.println("name : " + name);

        ExamDTO examDTO = restTemplate.getForObject(
                "http://localhost:8081/get/{name}",
                ExamDTO.class,
                name
        );

        return "RestTemplate으로 받은 데이터 : " + examDTO;
    }
}
