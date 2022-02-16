package com.czm.buffcrawlermaster.service.impl;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.czm.buffcrawlermaster.dao.ItemHistoryMapper;
import com.czm.buffcrawlermaster.dao.ItemMapper;
import com.czm.buffcrawlermaster.dao.ItemSnapShotMapper;
import com.czm.buffcrawlermaster.pojo.Item;
import com.czm.buffcrawlermaster.pojo.ItemHistory;
import com.czm.buffcrawlermaster.pojo.ItemSnapShot;
import com.czm.buffcrawlermaster.util.crawler.OwnRequester;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCrawlerService4 extends BreadthCrawler {
    @Autowired
    public ItemHistoryMapper itemHistoryMapper;
    @Autowired
    public ItemMapper itemMapper;
    @Autowired
    public ItemSnapShotMapper itemSnapShotMapper;
    public ItemCrawlerService4() {
        super("crawler", true);
        //折叠刀
        this.addSeed("https://buff.163.com/api/market/goods?game=csgo&page_num=1&category=weapon_knife_flip&quality=unusual&exterior=wearcategory0" +
                "&use_suggestion=0&trigger=undefined_trigger&_=1644493611274");
        this.addSeed("https://buff.163.com/api/market/goods?game=csgo&page_num=2&category=weapon_knife_flip&quality=unusual&exterior=wearcategory0" +
                "&use_suggestion=0&trigger=undefined_trigger&_=1644493611274");
        this.addSeed("https://buff.163.com/api/market/goods?game=csgo&page_num=1&category=weapon_knife_flip&" +
                "quality=unusual&exterior=wearcategory1&use_suggestion=0&trigger=undefined_trigger&_=1644493611274");
        this.addSeed("https://buff.163.com/api/market/goods?game=csgo&page_num=2&category=weapon_knife_flip&" +
                "quality=unusual&exterior=wearcategory1&use_suggestion=0&trigger=undefined_trigger&_=1644493611274");
        this.addSeed("https://buff.163.com/api/market/goods?game=csgo&page_num=3&category=weapon_knife_flip&" +
                "quality=unusual&exterior=wearcategory1&use_suggestion=0&trigger=undefined_trigger&_=1644493611274");
        this.addSeed("https://buff.163.com/api/market/goods?game=csgo&page_num=1" +
                "&category=weapon_knife_flip&quality=unusual&exterior=wearcategory2&use_suggestion=0&trigger=undefined_trigger&_=1644493611274");
        this.addSeed("https://buff.163.com/api/market/goods?game=csgo&page_num=2" +
                "&category=weapon_knife_flip&quality=unusual&exterior=wearcategory2&use_suggestion=0&trigger=undefined_trigger&_=1644493611274");
        this.setRequester(new OwnRequester.MRequester());
        this.setThreads(3);
        this.getConf().setTopN(3);
        this.getConf().setExecuteInterval(10000);

    }
    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        String url = page.url();
        //如果爬取的是二层信息
        if(url.contains("goods_id")) {
            //维护代码健壮性
            int idx = url.indexOf("goods_id");
            String str = url.substring(0, idx);
            //二级判断
            if (str.equalsIgnoreCase("https://buff.163.com/api/market/goods/bill_order?game=csgo&")) {
                String body = page.doc().select("body").text();
                int len = JsonPath.read(body, "$.data.items.length()");
                String stickers = "";
                for (int i = 0; i < len; i++) {
                    //数据封装
                    String sellid = JsonPath.read(body, "$.data.items[" + i + "].asset_info.assetid");
                    int p_id = JsonPath.read(body,"$.data.items[" + i + "].asset_info.goods_id");
                    int psd = JsonPath.read(body,"$.data.items[" + i + "].asset_info.info.paintseed");
                    String sell_id = String.valueOf(sellid);
                    String pid = String.valueOf(p_id);//pid
                    String paint_seed = String.valueOf(psd);//paintseed
                    int sell_price = (int)(double)Double.valueOf(JsonPath.read(body, "$.data.items[" + i + "].price"));//price
                    String paint_wear = JsonPath.read(body, "$.data.items[" + i + "].asset_info.paintwear");//paint_wear
                    //将时间戳转换为正常时间
                    int timeStamp = JsonPath.read(body, "$.data.items[" + i + "].transact_time");
                    String tmp = timeStamp + "000";
                    Long time = Long.valueOf(tmp);
                    DateTime date = DateUtil.date(time);
                    String transact_time = DateUtil.formatDate(date);//transact_time
                    String phase = "";
                    try{
                        //多普勒操作
                        phase = JsonPath.read(body, "$.data.items[" + i + " ].asset_info.info.phase_data.name");
                    }
                    catch (Exception e){

                    }
                    finally {
                        ItemHistory itemHistory = new ItemHistory(sell_id,pid,page.meta("name"),transact_time,sell_price,paint_wear,paint_seed,phase);
                        //数据库操作 水平分表
                        //分表的标志是什么？
                            itemHistoryMapper.insertFPHistoryInfo(itemHistory);


                    }


                }
            }
        }else {
            //如果爬取的是一层信息
            String body = page.doc().select("body").text();
            int len = JsonPath.read(body, "$.data.items.length()");
            for (int i = 0; i < len; i++) {
                String name = JsonPath.read(body, "$.data.items[" + i + "].name");
                double p = Double.valueOf(JsonPath.read(body, "$.data.items[" + i + "].sell_min_price"));
                int price = (int)p;
                int id = JsonPath.read(body, "$.data.items[" + i + "].id");
                //记录商品id
                Item item = new Item();
                item.setGoods_id(String.valueOf(id));
                item.setName(name);
                itemMapper.insert(item);
                //记录当前价格
                ItemSnapShot itemSnapShot = new ItemSnapShot();
                itemSnapShot.setGid(String.valueOf(id));
                itemSnapShot.setGname(name);
                itemSnapShot.setGprice(price);
                itemSnapShot.setCtime(DateUtil.now());
                //商品快照表 水平分表
                    crawlDatums.addAndReturn("https://buff.163.com/api/market/goods/bill_order?game=csgo&goods_id=" + id + "").meta("name",name);
                    itemSnapShotMapper.insertToFP(itemSnapShot);



            }
        }

    }
}
