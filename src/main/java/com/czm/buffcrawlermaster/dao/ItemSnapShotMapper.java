package com.czm.buffcrawlermaster.dao;

import com.czm.buffcrawlermaster.pojo.ItemSnapShot;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSnapShotMapper {
    int insertToBF(ItemSnapShot itemSnapShot);
    int insertToKB(ItemSnapShot itemSnapShot);
    int insertToBN(ItemSnapShot itemSnapShot);
    int insertToFP(ItemSnapShot itemSnapShot);
    int insertToST(ItemSnapShot itemSnapShot);
}
