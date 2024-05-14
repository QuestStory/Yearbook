package com.ruoyi.yearbook.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 话题对象 yearbook_topic
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public class Topic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 话题ID */
    @Excel(name = "话题ID")
    private Integer id;

    /** 班级ID */
    private Integer classId;

    /** 创建者ID */
    private Integer classmateId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 话题描述 */
    private String subtitle;

    /** 分类 */
    @Excel(name = "分类")
    private String type;

    /** 封面 */
    private String cover;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setClassId(Integer classId) 
    {
        this.classId = classId;
    }

    public Integer getClassId() 
    {
        return classId;
    }
    public void setClassmateId(Integer classmateId) 
    {
        this.classmateId = classmateId;
    }

    public Integer getClassmateId() 
    {
        return classmateId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setSubtitle(String subtitle) 
    {
        this.subtitle = subtitle;
    }

    public String getSubtitle() 
    {
        return subtitle;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setCover(String cover) 
    {
        this.cover = cover;
    }

    public String getCover() 
    {
        return cover;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classId", getClassId())
            .append("classmateId", getClassmateId())
            .append("title", getTitle())
            .append("subtitle", getSubtitle())
            .append("type", getType())
            .append("cover", getCover())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .toString();
    }
}
