package com.chalz.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;
import java.security.SecureRandom;

/**
 *  用户注册请求体
 *
 * @author chalz
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String planetCode;

}
