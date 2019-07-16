package org.ajou.realcoding.assignment.assignment.api;
// 외부 웹 서버와 통신하는 역할의 클래스들 정의
import org.ajou.realcoding.assignment.assignment.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiotGamesApiClient {
    private final String appid = "RGAPI-64fdef41-5cdf-4d51-80a4-66f275e19aeb";
    private final String RiotGamesSummonerNameUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={appid}";
    private final String RiotGamesSummonerEncryptedSummonerId = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/{encryptedSummonerId}?api_key={appid}";

    @Autowired
    RestTemplate restTemplate1;
    @Autowired
    RestTemplate restTemplate2;

    public SummonerDTO requestSummonerBySummonerName(String summonerName){
        return restTemplate1.exchange(RiotGamesSummonerNameUrl, HttpMethod.GET, null, SummonerDTO.class, summonerName, appid).getBody();
    }

    public SummonerDTO requestSummonerByEncryptedSummonerId(String encryptedSummonerId){
        return restTemplate2.exchange(RiotGamesSummonerEncryptedSummonerId, HttpMethod.GET, null, SummonerDTO.class, encryptedSummonerId, appid).getBody();
    }

}
