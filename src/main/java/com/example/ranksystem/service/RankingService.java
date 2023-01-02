package com.example.ranksystem.service;

import com.example.ranksystem.domain.QueueDTO;
import com.example.ranksystem.domain.ScoreDTO;

public interface RankingService {
    void insertScore(ScoreDTO scoreDTO);
}
