package cn.bdqn.tangcco.lookwell.roleuser.controller;

import cn.bdqn.tangcco.lookwell.entity.RoleUser;
import cn.bdqn.tangcco.lookwell.entity.Tbuser;
import cn.bdqn.tangcco.lookwell.roleuser.service.RoleUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 * Created by TYY on 2017/8/4.
 */
@Controller
public class LoginController {

    @Inject
    private RoleUserService roleUserService;

    /**
     * 用户名和密码登录
     * @param tbuser
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "login" ,method = RequestMethod.POST)
    public String login(Tbuser tbuser, HttpSession session, Model model){
        RoleUser ru=roleUserService.queryUserByUsernameAndPassword(tbuser);
        if(null!=ru){
            System.out.println("登录成功");
            session.setAttribute("roleUser",ru);
            return "main";
        }
        System.out.println("登录失败");
        model.addAttribute("msg","用户名或密码错误");
        return "index";
    }

}
