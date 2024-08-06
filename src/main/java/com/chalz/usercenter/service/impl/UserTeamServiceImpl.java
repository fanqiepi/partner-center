package com.chalz.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chalz.usercenter.model.domain.UserTeam;
import com.chalz.usercenter.mapper.UserTeamMapper;
import com.chalz.usercenter.service.UserTeamService;
import org.springframework.stereotype.Service;

/**
* @author chalz
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2024-08-02 10:00:38
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




