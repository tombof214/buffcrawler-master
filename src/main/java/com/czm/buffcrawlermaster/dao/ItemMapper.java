package com.czm.buffcrawlermaster.dao;

import com.czm.buffcrawlermaster.pojo.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMapper {
    Item selectAll();
    int insert(Item item);

}
