package com.example.ranksystem.listener;

import com.example.ranksystem.domain.QueueDTO;
import com.example.ranksystem.domain.ScoreDTO;
import com.example.ranksystem.service.RankingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ScoreListener {
    ObjectMapper objectMapper = new ObjectMapper();
    ScoreDTO scoreDTO;
    @Autowired
    RankingService rankingService;

    @RabbitListener(queues = "queue01")
    public void listen(String message) throws JsonProcessingException {
        QueueDTO queueDTO = objectMapper.readValue(message, QueueDTO.class);
        System.out.println(queueDTO.toString());
        scoreDTO = new ScoreDTO(queueDTO.getName(), queueDTO.getScore());
        rankingService.insertScore(scoreDTO);
    }
}
