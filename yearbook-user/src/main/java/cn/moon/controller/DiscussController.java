package cn.moon.controller;

import cn.moon.entity.Classmate;
import cn.moon.entity.Remark;
import cn.moon.entity.Topic;
import cn.moon.service.ClassmateService;
import cn.moon.service.RemarkService;
import cn.moon.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class DiscussController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private ClassmateService classmateService;

    @Autowired
    private RemarkService remarkService;

    @RequestMapping("toDiscuss")
    public String getAllTag(Model model, HttpSession session){
        List<Topic> list=topicService.findAll();
        Classmate classmate=classmateService.findOne((Integer) session.getAttribute("id"));
        model.addAttribute("topics",list);
        model.addAttribute("session",session);
        return "discuss";
    }

    @GetMapping("topicFindByType")
    public String topicFindByType(@RequestParam(value = "topicType", required = false) String topicType,Model model){
        List<Topic> list;
        if(topicType.equals("全部")){
            list=topicService.findAll();
        }else{
            list=topicService.findByType(topicType);
        }
        model.addAttribute("topics",list);
        return "discuss";
    }

    @GetMapping("topicFindByQuery")
    public String topicFindByQuery(@RequestParam(value = "keyword", required = false) String keyword,Model model){
        List<Topic> list=topicService.findByQuery(keyword);
        model.addAttribute("topics",list);
        return "discuss";
    }

    @Value("${file.upload.path}")
    private String fileDir;

    @Value("${file.upload.path.relative}")
    private String fileDirRelative;


    /**
     * @Author      Moonsky
     * @Description 创建话题
     * @Date        2024/4/6 13:19
     **/
    @PostMapping("topicCreate")
    public String topicCreate(Model model,
                              HttpSession session,
                              @RequestParam("fileUpload")MultipartFile fileUpload,
                              @RequestParam("createTitle") String title,
                              @RequestParam("createSubtitle") String subtitle,
                              @RequestParam("createType") String type){
        //获取上传文件名
        String filename = fileUpload.getOriginalFilename();
        //获取文件后缀名
        String suffixName = filename.substring(filename.lastIndexOf('.'));

        //定义上传文件名(同学ID+时间戳+后缀名)
        filename = session.getAttribute("id")+ String.valueOf(System.currentTimeMillis()) +suffixName;

        //定义上传文件路径(绝对地址)
        String filepath=fileDir+session.getAttribute("classId")+"/image/topic";
        //定义上传文件路径(相对地址)
        String filepathRelative=fileDirRelative+session.getAttribute("classId")+"/image/topic/";

        //写入文件
        File file = new File(filepath, filename);
        // 判断路径是否存在，如果不存在就创建一个
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            // 写入文件
            fileUpload.transferTo(new File(filepath + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //创建话题对象
        Topic topic=new Topic();
        topic.setClassId((Integer) session.getAttribute("classId"));
        topic.setClassmateId((Integer) session.getAttribute("id"));
        topic.setTitle(title);
        topic.setSubtitle(subtitle);
        topic.setType(type);
        topic.setCover(filepathRelative+filename);
        topic.setCreateBy((String) session.getAttribute("name"));
        topic.setCreateTime(new Date());

        //保持至数据库
        try {
            topicService.insertTopic(topic);
        }catch (Exception e){
            System.out.println("数据保存出错");
        }

        return "forward:/toDiscuss";
    }

    @RequestMapping("/remarkList/{topicId}")
    public String getRemarkList(@PathVariable("topicId")int topicId, Model model){
        List<Remark> list=remarkService.findByTopicId(topicId);
        model.addAttribute("remarkCount",list.size()+"条评论");
        model.addAttribute("remarks",list);
        return "discuss::remarkList";
    }



    @RequestMapping("/submitRemark/{topicId}/{message}")
    public String createRemark(@PathVariable("topicId")int topicId,@PathVariable("message")String message,HttpSession session){
        Remark remark=new Remark();
        remark.setTopicId(topicId);
        remark.setClassId((Integer) session.getAttribute("classId"));
        remark.setClassmateId((Integer) session.getAttribute("id"));
        remark.setMessage(message);
        remark.setCreateTime(new Date());
        if(remarkService.insertRemark(remark)==1){
            System.out.println("评论成功");
        }else{
            System.out.println("评论失败");
        }
        return "discuss::remarkList";
    }
}
