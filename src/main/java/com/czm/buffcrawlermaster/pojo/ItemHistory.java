package com.czm.buffcrawlermaster.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemHistory {
    public String sell_id;
    public String pid;
    public String name;
    public String transact_time;//可以用datetime,图省事全部varchar
    public int sell_price;
    public String paint_wear;
    public String paint_seed;
    public String phase;
}
