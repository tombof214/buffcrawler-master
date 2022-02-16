package com.czm.buffcrawlermaster.util.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResultVO {
    public int code;
    public String msg;
    public Object data;
}
