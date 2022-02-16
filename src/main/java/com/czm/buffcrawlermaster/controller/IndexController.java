package com.czm.buffcrawlermaster.controller;

import com.czm.buffcrawlermaster.service.IndexService;
import com.czm.buffcrawlermaster.util.common.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("index")
@ResponseBody
public class IndexController {
    @Autowired
    public IndexService indexService;
    @GetMapping("name")
    public ResultVO selectByName(String tablename,String name){
       return indexService.selectByName(tablename,name);
    }
    @GetMapping("up")
    public ResultVO selectUpGoods(int span,String time,@RequestParam(name = "limit",required = false,defaultValue = "20") int limit,@RequestParam
            (required = false,defaultValue = "0") int pagenum) {
        ResultVO resultVO = indexService.selectUpGoods(span, time,limit,pagenum);
        return resultVO;
    }
    @GetMapping("down")
    public ResultVO selectdownGoods(int span, String time, @RequestParam(name = "limit",required = false,defaultValue = "20") int limit,@RequestParam
            (required = false,defaultValue = "0") int pagenum) {
        ResultVO resultVO = indexService.selectdownGoods(span, time,limit,pagenum);
        return resultVO;
    }

}
