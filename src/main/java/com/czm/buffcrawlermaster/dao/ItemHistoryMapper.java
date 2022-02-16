package com.czm.buffcrawlermaster.dao;

import com.czm.buffcrawlermaster.pojo.ItemHistory;
import com.czm.buffcrawlermaster.pojo.ItemHistoryVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ItemHistoryMapper {
    int insertBFHistoryInfo(ItemHistory itemHistory);
    int insertBNHistoryInfo(ItemHistory itemHistory);
    int insertFPHistoryInfo(ItemHistory itemHistory);
    int insertSTHistoryInfo(ItemHistory itemHistory);
    int insertKBHistoryInfo(ItemHistory itemHistory);
    List<ItemHistory> selectByName(String tablename,String pname);
 //   List<ItemHistoryVO> selectByTimeAndPart(@Param("starttime") String starttime, @Param("span") int span
 //           ,@Param("limit")int limit,@Param("pagenum") int pagenum);
   List<ItemHistoryVO> selectByTime(@Param("starttime") String starttime,@Param("span")int span);

}
