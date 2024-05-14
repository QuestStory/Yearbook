package cn.moon.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Tagboard {
    private int classId;
    private int classmateId;
    private int id;
    private String message;
    private String tagStyle;
    private String createBy;
    private Date createTime;
}
