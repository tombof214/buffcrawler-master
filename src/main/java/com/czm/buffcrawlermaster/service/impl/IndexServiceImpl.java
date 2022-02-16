package com.czm.buffcrawlermaster.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.PageUtil;
import com.czm.buffcrawlermaster.dao.ItemHistoryMapper;
import com.czm.buffcrawlermaster.pojo.GapVO;
import com.czm.buffcrawlermaster.pojo.ItemHistory;
import com.czm.buffcrawlermaster.pojo.ItemHistoryVO;
import com.czm.buffcrawlermaster.service.IndexService;
import com.czm.buffcrawlermaster.util.PageHelper;
import com.czm.buffcrawlermaster.util.common.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class IndexServiceImpl implements IndexService {
    @Autowired
    public ItemHistoryMapper itemHistoryMapper;
    @Override
    public ResultVO selectByName(String tablename,String pname) {
        List<ItemHistory> itemHistories = itemHistoryMapper.selectByName(tablename,pname);
        if(itemHistories.isEmpty()){
            return new ResultVO(400,"检索失败,请查看参数",null);
        }
        return new ResultVO(200,"检索成功",itemHistories);

    }

    @Override
    public ResultVO selectUpGoods(int span,String time,int limit,int pagenum) {
        //查询基础数据
        List<ItemHistoryVO> itemHistories = itemHistoryMapper.selectByTime(time, span);
        //计算数据集
        List<GapVO> gapVOS = new ArrayList<>();
        if(itemHistories.isEmpty()){
            return new ResultVO(400,"检索失败,请检查参数",null);
        }
        //计算
        for(int left = 0; left < itemHistories.size() - 1; left++){
            int right = left;
            while(right + 1 < itemHistories.size() && itemHistories.get(left).pid.equalsIgnoreCase(itemHistories.get(right + 1).pid)){
                right++;
            }
            if(right == left){
                GapVO gapVO = new GapVO(itemHistories.get(left).pid, itemHistories.get(left).name, "0%", itemHistories.get(left).sell_price, 0);
                gapVOS.add(gapVO);
            }

            else{
                String gap = (double)((itemHistories.get(right).sell_price - itemHistories.get(left).sell_price) * 100 / itemHistories.get(left).sell_price)  + "%";
                int price = itemHistories.get(right).sell_price - itemHistories.get(left).sell_price;
                int cur_price = itemHistories.get(right).sell_price;
                GapVO gapVO = new GapVO(itemHistories.get(right).pid, itemHistories.get(right).name, gap, cur_price, price);
                gapVOS.add(gapVO);
            }
            left = right;
        }
        //分页处理
        Collections.sort(gapVOS);
        int count = gapVOS.size();
        if(limit * (pagenum-1) > count || limit > count){
            return new ResultVO(500,"参数错误，超出范围",null);
        }
        int pageCount = PageUtil.totalPage(count,limit);
        int start = PageUtil.getStart(pagenum - 1, limit);
        List<GapVO> res = new ArrayList<>();
        for(int i = start; i < start + limit && i < gapVOS.size(); i++){
            res.add(gapVOS.get(i));
        }
        return new ResultVO(200,"检索成功",new PageHelper<GapVO>(count,pageCount,res));
    }

    @Override
    public ResultVO selectdownGoods(int span, String time,int limit,int pagenum) {
        //同理
        List<ItemHistoryVO> itemHistories = itemHistoryMapper.selectByTime(time, span);
        List<GapVO> gapVOS = new ArrayList<>();
        if(itemHistories.isEmpty()){
            return new ResultVO(400,"检索失败,请检查参数",null);
        }
        //计算
        for(int left = 0; left < itemHistories.size() - 1; left++){
            int right = left;
            while(right + 1 < itemHistories.size() && itemHistories.get(left).pid.equalsIgnoreCase(itemHistories.get(right + 1).pid)){
                right++;
            }
            if(right == left){
                GapVO gapVO = new GapVO(itemHistories.get(left).pid, itemHistories.get(left).name, "0%", itemHistories.get(left).sell_price, 0);
                gapVOS.add(gapVO);
            }

            else{
                String gap = (double)((itemHistories.get(right).sell_price - itemHistories.get(left).sell_price) * 100 / itemHistories.get(left).sell_price)  + "%";
                int price = itemHistories.get(right).sell_price - itemHistories.get(left).sell_price;
                int cur_price = itemHistories.get(right).sell_price;
                GapVO gapVO = new GapVO(itemHistories.get(right).pid, itemHistories.get(right).name, gap, cur_price, price);
                gapVOS.add(gapVO);
            }
            left = right;
        }
        Collections.sort(gapVOS);
        Collections.reverse(gapVOS);
        List<GapVO> res = new ArrayList<>();
        int count = gapVOS.size();
        if(limit * (pagenum-1) > count || limit > count){
            return new ResultVO(500,"参数错误，超出范围",null);
        }
        int pageCount = PageUtil.totalPage(count,limit);
        int start = PageUtil.getStart(pagenum - 1, limit);
        for(int i = start; i < start + limit && i < gapVOS.size(); i++){
            res.add(gapVOS.get(i));
        }
        return new ResultVO(200,"检索成功",new PageHelper<GapVO>(count,pageCount,res));
    }
}
