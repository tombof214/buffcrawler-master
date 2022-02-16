package com.czm.buffcrawlermaster.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Comparator;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GapVO implements Comparable<GapVO> {
    public String pid;
    public String name;
    public String gap;//涨跌百分比
    public int cur_price;
    public int price;//具体差值
    @Override
    public int compareTo(GapVO o1) {
        String gap1 = o1.getGap();
        int i = gap1.indexOf("%");
        String tmp1 = gap1.substring(0, i);
        String gap2 = this.getGap();
        int i2 = gap2.indexOf("%");
        String tmp2 = gap2.substring(0, i2);
        return (int) (Double.valueOf(tmp1) - Double.valueOf(tmp2));
    }
}
