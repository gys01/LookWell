package roleuser;

import base.TestBase;
import cn.bdqn.tangcco.lookwell.entity.RoleUser;
import cn.bdqn.tangcco.lookwell.entity.Tbuser;
import cn.bdqn.tangcco.lookwell.roleuser.service.RoleUserService;
import org.junit.Test;

import javax.inject.Inject;

/**
 * Created by TYY on 2017/8/4.
 */
public class RoleUserTest extends TestBase {

    @Inject
    private RoleUserService roleUserService;

    @Test
    public void testQueryUser(){
        Tbuser tbuser=new Tbuser();
        tbuser.setUsername("admin");
        tbuser.setPassword("admin");
        RoleUser roleUser=roleUserService.queryUserByUsernameAndPassword(tbuser);
        System.out.println(roleUser);
    }
}
