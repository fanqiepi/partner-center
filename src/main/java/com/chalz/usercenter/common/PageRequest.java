package com.chalz.usercenter.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chalz
 * 通用分页请求参数
 */
@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = -4424083755273258076L;

    /**
     * 页面大小
     */
    protected int pageSize = 10;

    /**
     * 当前是第几页
     */
    protected int pageNum = 1;
}
