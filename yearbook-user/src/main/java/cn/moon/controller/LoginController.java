package cn.moon.controller;

import cn.moon.entity.Classmate;
import cn.moon.service.ClassmateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private ClassmateService classmateService;

    /*
    * 进入登录界面
    * */
    @RequestMapping({"/","/login","/login.html"})
    public String login(){
        return "login";
    }

    /*
    * 登录验证
    * */
    @RequestMapping("/loginSolve")
    public String loginSolve(@RequestParam("id")int id, @RequestParam("password") String password,HttpSession session, RedirectAttributes model){
        Classmate classmate=classmateService.findOne(id);
        if(classmate==null){
            //重定向至登录页，提示登录失败信息
            model.addFlashAttribute("id",id);
            model.addFlashAttribute("msg","账号不存在");
            return "redirect:login";
        }else if(classmate.getPassword().equals(password)){
            //重定向至首页，添加session信息
            session.setAttribute("id",classmate.getId());
            session.setAttribute("name",classmate.getName());
            session.setAttribute("profile",classmate.getProfile());
            session.setAttribute("classId",classmate.getClassId());
            return "redirect:toIndex";
        }else{
            //重定向至登录页，提示登录失败信息
            model.addFlashAttribute("id",id);
            model.addFlashAttribute("msg","密码错误");
            return "redirect:login";
        }
    }
}
