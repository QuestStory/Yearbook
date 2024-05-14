package com.ruoyi.yearbook.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 留言条对象 yearbook_tagboard
 * 
 * @author ruoyi
 * @date 2024-03-30
 */
public class Tagboard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 留言ID */
    @Excel(name = "留言ID")
    private Integer id;

    /** 班级ID */
    private Integer classId;

    /** 创建者ID */
    private Integer classmateId;

    /** 留言内容 */
    @Excel(name = "留言内容")
    private String message;

    /** 纸条样式 */
    @Excel(name = "纸条样式")
    private String tagStyle;

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
    public void setMessage(String message) 
    {
        this.message = message;
    }

    public String getMessage() 
    {
        return message;
    }
    public void setTagStyle(String tagStyle) 
    {
        this.tagStyle = tagStyle;
    }

    public String getTagStyle() 
    {
        return tagStyle;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classId", getClassId())
            .append("classmateId", getClassmateId())
            .append("message", getMessage())
            .append("tagStyle", getTagStyle())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .toString();
    }
}
