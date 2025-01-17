package com.chalz.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chalz.usercenter.model.domain.Team;
import com.chalz.usercenter.model.domain.User;
import com.chalz.usercenter.model.dto.TeamQuery;
import com.chalz.usercenter.model.request.TeamJoinRequest;
import com.chalz.usercenter.model.request.TeamQuitRequest;
import com.chalz.usercenter.model.request.TeamUpdateRequest;
import com.chalz.usercenter.model.vo.TeamUserVO;
import java.util.List;

/**
* @author chalz
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2024-08-02 10:00:14
*/
public interface TeamService extends IService<Team> {


    /**
     * 创建队伍
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 解散队伍
     * @param id
     * @param loginUser
     * @return
     */
    boolean deleteTeam(long id, User loginUser);

}
