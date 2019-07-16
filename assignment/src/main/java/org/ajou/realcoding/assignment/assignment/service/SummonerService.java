package org.ajou.realcoding.assignment.assignment.service;
// 핵심 비즈니스 로직을 처리하는 역할의 클래스들을 정의

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.assignment.assignment.api.RiotGamesApiClient;
import org.ajou.realcoding.assignment.assignment.domain.SummonerDTO;
import org.ajou.realcoding.assignment.assignment.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SummonerService {
    List<String> summonerList = null;

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    RiotGamesApiClient riotGamesApiClient;


    @Autowired
    SummonerRepository summonerRepository;

    public SummonerDTO getSummonerBySummonerName(String summonerName){

        SummonerDTO summonerDTO1 = riotGamesApiClient.requestSummonerBySummonerName(summonerName);
        // summonerRepository.insertSummonerDTO(summonerDTO1);
        String encryptedSummonerId = summonerDTO1.getId();
        SummonerDTO summonerDTO2 = riotGamesApiClient.requestSummonerByEncryptedSummonerId(encryptedSummonerId);
        summonerRepository.insertSummonerDTO(summonerDTO2);
        // summonerList.add(summonerName);

        return summonerRepository.findSummoner(summonerName);
    }
}
