package com.chalz.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 *  用户登录请求体
 *
 * @author chalz
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -386060964124752869L;

    private String userAccount;

    private String userPassword;


}
