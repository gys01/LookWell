package cn.bdqn.tangcco.lookwell.rolemenu.service;

import cn.bdqn.tangcco.lookwell.entity.Menu;

import java.util.List;

/**
 * Created by TYY on 2017/8/4.
 */
public interface RoleMenuService {
    //树形一级菜单
    List<Menu> queryMenuByRoleId(Integer roleId);

    //树形二级菜单
    List<Menu> queryMenuByParentId(Integer parentId, Integer roleId);

}
