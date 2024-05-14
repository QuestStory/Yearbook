package cn.moon.controller;

import cn.moon.entity.Classmate;
import cn.moon.service.ClassmateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private ClassmateService classmateService;

    @GetMapping("toIndex")
    public String toIndex(Model model, HttpSession session){
        Classmate classmate=classmateService.randomFindSigns();
        model.addAttribute("randomName",classmate.getName());
        model.addAttribute("randomSign",classmate.getSign());
        model.addAttribute("user",classmateService.findOne((Integer) session.getAttribute("id")));
        return "index";
    }
}
