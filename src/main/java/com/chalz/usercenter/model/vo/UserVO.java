package com.chalz.usercenter.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * 用户包装类
 * @author chalz
 */
@Data
public class UserVO {

    /**
     * id
     */
    private long id;

    /**
     * 昵称
     */
    private String username;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 登录账号
     */
    private String userAccount;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户状态 0 —— 正常
     */
    private Integer userStatus;

    /**
     * 创建时间
     */
    private Date creatTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 用户角色 0 - 普通用户 1- 管理员
     */
    private Integer userRole;

    /**
     * 星球编号
     */
    private String planetCode;


    /**
     * 标签列表 json
     */
    private String tags;

    private static final long serialVersionUID = -3143256102618951283L;
}
