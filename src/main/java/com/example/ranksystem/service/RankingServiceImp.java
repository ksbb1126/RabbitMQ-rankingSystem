package com.example.ranksystem.service;

import com.example.ranksystem.domain.ScoreDTO;
import com.example.ranksystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingServiceImp implements RankingService{
    @Autowired
    UserMapper userMapper;

    @Override
    public void insertScore(ScoreDTO scoreDTO) {
        userMapper.insert(scoreDTO.getName(), scoreDTO.getScore());
    }
}
