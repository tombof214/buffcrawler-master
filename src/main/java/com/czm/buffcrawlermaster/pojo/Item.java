package com.czm.buffcrawlermaster.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Item {
    public String goods_id;
    public String name;
    public String category;
}
