package cn.moon.controller;

import cn.moon.entity.Classmate;
import cn.moon.service.ClassmateService;
import cn.moon.util.BirthUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private ClassmateService classmateService;

    @GetMapping("toBook")
    public String toBook(){
        return "forward:/getPage";
    }

    /**
     * @Author      Moonsky
     * @Description 分页查询所有同学信息
     * @Date        2023/10/31 20:15
     * @Param       pageIndex:页码; pageSize:展示数据条数;
     * @return      页面请求路径
     **/
    @RequestMapping("/getPage")
    public String getAll(Model model,
                         @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        PageInfo<Classmate> allPageInfo = classmateService.findAll(pageIndex, pageSize);
        model.addAttribute("page", allPageInfo);
        model.addAttribute("path", "/getPage?pageIndex=");
        return "book";
    }

    /**
     * @Author      Moonsky
     * @Description 条件分页查询同学录
     * @Date        2023/10/31 20:20
     * @Param       searchText:查询条件;pageIndex:页码; pageSize:展示数据条数;
     * @return      页面请求路径
     **/
    @RequestMapping("/getPageBy")
    public String getPageBy(Model model,
                            @RequestParam(value = "searchText", required = false) String searchText,
                            @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        PageInfo<Classmate> queryPageInfo = classmateService.findByQuery(pageIndex, pageSize, searchText);
        model.addAttribute("page", queryPageInfo);
        if(searchText==""||searchText==null){
            model.addAttribute("path","/getPageBy?pageIndex=");
        }else{
            model.addAttribute("path", "/getPageBy?searchText="+searchText+"&pageIndex=");
            model.addAttribute("searchText",searchText);
        }

        return "book";
    }

    /**
     * @Author      Moonsky
     * @Description 展示同学录卡片即详情信息页
     * @Date        2023/10/31 20:21
     * @Param       id:需展示详情信息的同学id
     * @return      页面请求路径
     **/
    @RequestMapping("/detail")
    public String toDetail(Model model,@RequestParam int id){
        Classmate classmate=classmateService.findOne(id);
        //将查找到的同学信息载入model中
        model.addAttribute(classmate);
        //调用工具类,根据生日判断星座信息
        model.addAttribute("starSign", BirthUtils.getConstellation(classmate.getBirthday()));

        //处理爱好信息
        String hobbies=classmate.getHobby();
        if(hobbies==null||hobbies.isEmpty()){
            model.addAttribute("hobbies","Ta没有填写爱好");
        }else{
            model.addAttribute("hobbies",hobbies.split(","));
        }
        return "detail";
    }
}
