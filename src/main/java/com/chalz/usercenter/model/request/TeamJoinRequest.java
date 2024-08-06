package com.chalz.usercenter.model.request;

import lombok.Data;

/**
 * 用户加入队伍请求体
 */
@Data
public class TeamJoinRequest {
    /**
     * id
     */
    private Long teamId;

    /**
     * 密码
     */
    private String password;

}
