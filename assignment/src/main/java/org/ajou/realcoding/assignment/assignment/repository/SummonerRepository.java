package org.ajou.realcoding.assignment.assignment.repository;

import org.ajou.realcoding.assignment.assignment.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SummonerRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public void insertSummonerDTO(SummonerDTO summonerDTO){
        mongoTemplate.insert(summonerDTO);
    }

    public SummonerDTO findSummoner(String summonerName){
        Query query = Query.query(Criteria.where("name").is(summonerName));
        return mongoTemplate.findOne(query, SummonerDTO.class);
    }
}
