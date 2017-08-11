package cn.bdqn.tangcco.lookwell.rolemenu.dao;

import cn.bdqn.tangcco.lookwell.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by TYY on 2017/8/4.
 */
public interface RoleMenuMapper {
    //树形一级菜单
    List<Menu> queryMenuByRoleId(Integer roleId);

    //树形二级菜单
    List<Menu> queryMenuByParentId(@Param("parentId") Integer parentId, @Param("roleId") Integer roleId);

}
