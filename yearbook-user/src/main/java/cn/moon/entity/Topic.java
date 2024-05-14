package cn.moon.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Topic {
    private int classId;
    private int classmateId;
    private int id;
    private String title;
    private String subtitle;
    private String type;
    private String cover;
    private String createBy;
    private Date createTime;
}
