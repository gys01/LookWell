package cn.bdqn.tangcco.lookwell.rolemenu.service;

import cn.bdqn.tangcco.lookwell.entity.Menu;
import cn.bdqn.tangcco.lookwell.rolemenu.dao.RoleMenuMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by TYY on 2017/8/4.
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Inject
    private RoleMenuMapper roleMenuMapper;

    //树形一级菜单
    @Override
    public List<Menu> queryMenuByRoleId(Integer roleId) {
        return roleMenuMapper.queryMenuByRoleId(roleId);
    }

    //树形二级菜单
    @Override
    public List<Menu> queryMenuByParentId(Integer parentId, Integer roleId) {
        return roleMenuMapper.queryMenuByParentId(parentId,roleId);
    }

}
