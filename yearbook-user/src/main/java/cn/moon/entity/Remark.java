package cn.moon.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Remark {
    private int id;
    private int topicId;
    private int classId;
    private int classmateId;
    private String message;
    private Date createTime;
    //联表
    private String createBy;
    private String createProfile;
}
