package org.ajou.realcoding.assignment.assignment.domain;
// controller 에서 resource로 사용될 클래스들 정의 (그릇 정도로 이해..)
import lombok.Data;

@Data
public class SummonerDTO {
    private int profileIconId;  // ID of the summoner icon associated with the summoner
    private String name;    // Summoner name
    private String puuid;   // Encrypted PUUID. Exact length of 78 characters
    private long summonerlevel; // Summoner level associated with the summoner
    private long revisionDate;  // Date summoner was last modified specified as epoch milliseconds.
    // The following events will update this timestamp: profile icon change, playing the tutorial or advanced tutorial, finishing a game, summoner name change
    private String id;  // Encrypted summoner ID. Max length 63 characters
    private String accountId;   // Encrypted account ID. Max length 56 characters
}
