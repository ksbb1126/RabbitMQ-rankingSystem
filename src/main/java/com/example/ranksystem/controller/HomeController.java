package com.example.ranksystem.controller;


import com.example.ranksystem.domain.ExamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("")
    public String f1() {
        // app2이 bpp2에게 Person타입의 데이터를 요청
        ExamDTO examDTO = restTemplate.getForObject(
                "http://localhost:8081/{name}",
                ExamDTO.class);

        return "받은 값 : " + examDTO;
    }
}
