package org.ajou.realcoding.assignment.assignment.controller;
// 외부에서 호출 가능한 rest api들을 제공하는 역할의 클래스들을 정의

import org.ajou.realcoding.assignment.assignment.domain.SummonerDTO;
import org.ajou.realcoding.assignment.assignment.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummonerController {
    @Autowired
    SummonerService summonerService;

    @GetMapping("/summoner-crawler/summoner-list/by-summoner-name/{summonerName}")
    public SummonerDTO getSummoner(@PathVariable String summonerName){
        return summonerService.getSummonerBySummonerName(summonerName);
    }

}
