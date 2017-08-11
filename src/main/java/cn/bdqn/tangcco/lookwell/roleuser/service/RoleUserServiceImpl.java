package cn.bdqn.tangcco.lookwell.roleuser.service;

import cn.bdqn.tangcco.lookwell.entity.RoleUser;
import cn.bdqn.tangcco.lookwell.entity.Tbuser;
import cn.bdqn.tangcco.lookwell.roleuser.dao.RoleUserMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by TYY on 2017/8/4.
 */

@Service
public class RoleUserServiceImpl implements RoleUserService {

    @Inject
    private RoleUserMapper roleUserMapper;

    @Override
    public RoleUser queryUserByUsernameAndPassword(Tbuser tbuser) {
        return roleUserMapper.queryUserByUsernameAndPassword(tbuser);
    }
}
