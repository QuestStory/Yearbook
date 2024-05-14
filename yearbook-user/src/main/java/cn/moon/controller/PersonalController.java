package cn.moon.controller;

import cn.moon.entity.Classmate;
import cn.moon.service.ClassesService;
import cn.moon.service.ClassmateService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
public class PersonalController {

    @Autowired
    private ClassesService classesService;

    @Autowired
    private ClassmateService classmateService;

    @GetMapping("toPersonal")
    public String toPersonal(Model model, HttpSession session){
        //班级信息
        model.addAttribute("classes",classesService.queryClasses());

        //登录用户信息
        Classmate user= classmateService.findOne((Integer) session.getAttribute("id"));
        model.addAttribute("user",user);

        //处理爱好信息
        String hobbies=user.getHobby();
        if(hobbies==null||hobbies.isEmpty()){
            model.addAttribute("hobbies","你还没有填写爱好");
        }else{
            model.addAttribute("hobbies",hobbies.split(","));
        }
        return "personal";
    }
}
