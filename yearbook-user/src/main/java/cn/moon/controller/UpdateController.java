package cn.moon.controller;

import cn.moon.entity.Classmate;
import cn.moon.service.ClassmateService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
public class UpdateController {

    @Autowired
    private ClassmateService classmateService;

    /*
    * 回显表单信息
    * */
    @RequestMapping("/update")
    public String toUpdate(Model model, HttpSession session){
        Classmate classmate=classmateService.findOne((Integer) session.getAttribute("id"));
        model.addAttribute("user",classmate);
        model.addAttribute("session",session);

        //处理爱好信息
        String hobbies=classmate.getHobby();
        if(hobbies==null||hobbies.isEmpty()){
            model.addAttribute("hobbies","你还没有填写爱好");
        }else{
            String[] hobby=hobbies.split(",");
            int length=hobby.length;

            for(int i=0;i<length;i++){
                model.addAttribute("hobby"+i,hobby[i]);
            }

            for(int j=length;j<4;j++){
                model.addAttribute("hobby"+j,"");
            }

        }
        return "update";
    }

    @Value("${file.upload.path}")
    private String fileDir;

    @Value("${file.upload.path.relative}")
    private String fileDirRelative;



    /*
    * 更新头像
    * */
    @PostMapping("/updateProfile")
    public String updateProfile(HttpSession session,MultipartFile fileUpload){
        //获取上传文件名
        String filename = fileUpload.getOriginalFilename();
        //获取文件后缀名
        String suffixName = filename.substring(filename.lastIndexOf('.'));

        //定义上传文件名(同学ID+时间戳+后缀名)
        filename = session.getAttribute("id")+suffixName;
        System.out.println(session.getAttribute("id"));
        System.out.println(session.getAttribute("classId"));
        //定义上传文件路径(绝对地址)
        String filepath=fileDir+session.getAttribute("classId")+"/image/profile";
        //定义上传文件路径(相对地址)
        String filepathRelative=fileDirRelative+session.getAttribute("classId")+"/image/profile/";

        //写入文件
        File file = new File(filepath, filename);
        // 判断路径是否存在，如果不存在就创建一个
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if(!file.exists()||file.isDirectory()){
            System.out.println("文件或路径不存在");
        }else{
            try {
                // 写入文件
                fileUpload.transferTo(new File(filepath + File.separator + filename));
                String profile=filepathRelative+filename;
                //保持至数据库
                try {
                    classmateService.updateProfile((Integer) session.getAttribute("id"),profile);
                    session.setAttribute("profile",profile);
                }catch (Exception e){
                    System.out.println("数据保存出错");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "personal::updateProfile";
    }

    /*
     * 更新密码
     * */
    @PostMapping("/updatePassword")
    public String updatePassword(HttpServletRequest request,HttpSession session){
        try {
            classmateService.updatePassword((Integer) session.getAttribute("id"),request.getParameter("password"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "update::updatePassword";
    }

    /*
     * 更新基本信息
     * */
    @PostMapping("/updateBasic")
    public String updateBasic(Classmate classmate,HttpSession session,Model model){
        try {
            classmate.setId((Integer) session.getAttribute("id"));
            classmateService.updateBasic(classmate);
            model.addAttribute("user", classmate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "update::updateBasic";
    }

    /*
     * 更新联系方式
     * */
    @PostMapping("/updateContact")
    public String updateContact(Classmate classmate,HttpSession session,Model model){
        try {
            classmate.setId((Integer) session.getAttribute("id"));
            classmateService.updateContact(classmate);
            model.addAttribute("user", classmate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "update::updateContact";
    }

    /*
     * 更新个人介绍
     * */
    @PostMapping("/updateIntro")
    public String updateIntro(Classmate classmate,HttpServletRequest request,HttpSession session,Model model){
        String hobby1=request.getParameter("hobby1");
        String hobby2=request.getParameter("hobby2");
        String hobby3=request.getParameter("hobby3");
        String hobby4=request.getParameter("hobby4");
        String hobbies=hobby1+','+hobby2+','+hobby3+','+hobby4;
        try {
            classmate.setId((Integer) session.getAttribute("id"));
            classmate.setHobby(hobbies);
            classmateService.updateIntro(classmate);
            model.addAttribute("user",classmate);
            model.addAttribute("hobby1", hobby1);
            model.addAttribute("hobby2", hobby2);
            model.addAttribute("hobby3", hobby3);
            model.addAttribute("hobby4", hobby4);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "update::updateIntro";
    }
}
