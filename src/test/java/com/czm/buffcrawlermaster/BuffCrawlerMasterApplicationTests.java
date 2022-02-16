package com.czm.buffcrawlermaster;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.czm.buffcrawlermaster.dao.ItemHistoryMapper;
import com.czm.buffcrawlermaster.dao.ItemMapper;
import com.czm.buffcrawlermaster.pojo.ItemHistory;
import com.czm.buffcrawlermaster.pojo.ItemHistoryVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BuffCrawlerMasterApplicationTests {
 @Autowired
 public ItemMapper itemMapper;
    @Test
    void T1() {
        System.out.println(itemMapper.selectAll());
    }
    @Test
    void T2(){

        System.out.println(DateUtil.now());
    }
    @Autowired
    public ItemHistoryMapper itemHistoryMapper;
    @Test
    void T3(){
        List<ItemHistory> t = itemHistoryMapper.selectByName("butterfly_history","深红");
        for(ItemHistory i : t){
            System.out.println(i);
        }
    }


}
