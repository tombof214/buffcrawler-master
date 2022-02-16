package com.czm.buffcrawlermaster.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageHelper<T> {
    public int count;
    public int pageCount;
    public List<T> list;
}
