package com.czm.buffcrawlermaster.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ItemSnapShot {
    public int id;
    public String gid;
    public String gname;
    public int gprice;
    public String ctime;
}
