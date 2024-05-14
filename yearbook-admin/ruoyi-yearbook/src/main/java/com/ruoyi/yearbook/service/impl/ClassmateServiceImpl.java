package com.ruoyi.yearbook.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.yearbook.mapper.ClassmateMapper;
import com.ruoyi.yearbook.domain.Classmate;
import com.ruoyi.yearbook.service.IClassmateService;

/**
 * 同学Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-30
 */
@Service
public class ClassmateServiceImpl implements IClassmateService 
{
    @Autowired
    private ClassmateMapper classmateMapper;

    /**
     * 查询同学
     * 
     * @param id 同学主键
     * @return 同学
     */
    @Override
    public Classmate selectClassmateById(Integer id)
    {
        return classmateMapper.selectClassmateById(id);
    }

    /**
     * 查询同学列表
     * 
     * @param classmate 同学
     * @return 同学
     */
    @Override
    public List<Classmate> selectClassmateList(Classmate classmate)
    {
        return classmateMapper.selectClassmateList(classmate);
    }

    /**
     * 新增同学
     * 
     * @param classmate 同学
     * @return 结果
     */
    @Override
    public int insertClassmate(Classmate classmate)
    {
        int lastId=classmateMapper.selectClassmateMaxIDFromClass(classmate.getClassId());
        classmate.setId(lastId+1);
        return classmateMapper.insertClassmate(classmate);
    }

    /**
     * 修改同学
     * 
     * @param classmate 同学
     * @return 结果
     */
    @Override
    public int updateClassmate(Classmate classmate)
    {
        return classmateMapper.updateClassmate(classmate);
    }

    /**
     * 批量删除同学
     * 
     * @param ids 需要删除的同学主键
     * @return 结果
     */
    @Override
    public int deleteClassmateByIds(Integer[] ids)
    {
        return classmateMapper.deleteClassmateByIds(ids);
    }

    /**
     * 删除同学信息
     * 
     * @param id 同学主键
     * @return 结果
     */
    @Override
    public int deleteClassmateById(Integer id)
    {
        return classmateMapper.deleteClassmateById(id);
    }
}
