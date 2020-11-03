package com.xzy.dto;

import lombok.Data;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 19:24
 * @description:
 */
@Data
public class Page {

    private int pageNum;
    private int pageSize;
    private int pages;
    private boolean hasNext;
    private boolean hasPre;

    private Object obj;
}
