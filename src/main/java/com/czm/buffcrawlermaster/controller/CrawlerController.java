package com.czm.buffcrawlermaster.controller;


import com.czm.buffcrawlermaster.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@ResponseBody
@RequestMapping("crawler")
public class CrawlerController {

    @Autowired
    public ItemCrawlerService itemCrawlerService;
    @Autowired
    public ItemCrawlerService1 itemCrawlerService1;
    @Autowired
    public ItemCrawlerService2 itemCrawlerService2;
    @Autowired
    public ItemCrawlerService3 itemCrawlerService3;
    @Autowired
    public ItemCrawlerService4 itemCrawlerService4;
    @RequestMapping("fetch")
    public void fetch() throws Exception {
        itemCrawlerService.start(100);

    }
    @RequestMapping("fetch1")
    public void fetch1() throws Exception {
        itemCrawlerService1.start(100);
    } @RequestMapping("fetch2")
    public void fetch2() throws Exception {
        itemCrawlerService2.start(100);
    }
    @RequestMapping("fetch3")
    public void fetch3() throws Exception {
        itemCrawlerService3.start(100);
    }
    @RequestMapping("fetch4")
    public void fetch4() throws Exception {
        itemCrawlerService4.start(100);
    }

}
