package com.chalz.usercenter.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chalz
 * 通用删除请求参数
 */
@Data
public class DeleteRequest implements Serializable {

    private static final long serialVersionUID = -4424083755273258076L;

    private long id;
}
