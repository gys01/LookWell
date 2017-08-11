package cn.bdqn.tangcco.lookwell.roleuser.service;

import cn.bdqn.tangcco.lookwell.entity.RoleUser;
import cn.bdqn.tangcco.lookwell.entity.Tbuser;

/**
 * Created by TYY on 2017/8/4.
 */
public interface RoleUserService {

    RoleUser queryUserByUsernameAndPassword(Tbuser tbuser);
}
