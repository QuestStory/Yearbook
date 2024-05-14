package cn.moon.controller;

import cn.moon.entity.Tagboard;
import cn.moon.service.TagboardService;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private TagboardService tagboardService;

    @GetMapping("/toBoard")
    public String getAllTag(Model model, HttpSession session){
        List<Tagboard> list=tagboardService.findAll();
        model.addAttribute("tags",list);
        model.addAttribute("session",session);
        return "board";
    }

    @RequestMapping("/insertTag")
    public String insert(@RequestParam int id,@RequestParam String message,@RequestParam String tagStyle,@RequestParam String createBy,HttpSession session){
        Tagboard tagboard=new Tagboard();

        tagboard.setClassmateId(id);
        tagboard.setClassId((Integer) session.getAttribute("classId"));
        tagboard.setMessage(message);
        tagboard.setTagStyle(tagStyle);
        tagboard.setCreateBy(createBy);
        tagboard.setCreateTime(new Date());

        tagboardService.insertTag(tagboard);
        return "redirect:toBoard";
    }

    @GetMapping("/deleteTag")
    @ResponseBody
    public void delete(@RequestParam int id){
        if(tagboardService.deleteTag(id)==1){
            System.out.println("tag删除成功");
        }else{
            System.out.println("tag删除失败");
        }
    }
}
