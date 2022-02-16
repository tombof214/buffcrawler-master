package com.czm.buffcrawlermaster.service;

import com.czm.buffcrawlermaster.pojo.ItemHistory;
import com.czm.buffcrawlermaster.util.common.ResultVO;

public interface IndexService {
    ResultVO selectByName(String tablename,String name);
    ResultVO selectUpGoods(int span,String name,int limit,int pagenum);
    ResultVO selectdownGoods(int span,String name,int limit,int pagenum);
//    ResultVO selectBNName(String name);
//    ResultVO selectKBName(String name);
//    ResultVO selectFPName(String name);
//    ResultVO selectSTName(String name);

}
