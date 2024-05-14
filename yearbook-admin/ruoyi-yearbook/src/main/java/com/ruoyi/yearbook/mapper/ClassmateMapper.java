package com.ruoyi.yearbook.mapper;

import java.util.List;
import com.ruoyi.yearbook.domain.Classmate;

/**
 * 同学Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-30
 */
public interface ClassmateMapper 
{
    /**
     * 查询同学
     * 
     * @param id 同学主键
     * @return 同学
     */
    public Classmate selectClassmateById(Integer id);

    /**
     * 查询同学列表
     * 
     * @param classmate 同学
     * @return 同学集合
     */
    public List<Classmate> selectClassmateList(Classmate classmate);

    /**
     * 查询一个班级中最末尾的同学ID
     *
     * @param classId 班级id
     * @return 同学id
     */
    public int selectClassmateMaxIDFromClass(int classId);

    /**
     * 新增同学
     * 
     * @param classmate 同学
     * @return 结果
     */
    public int insertClassmate(Classmate classmate);

    /**
     * 修改同学
     * 
     * @param classmate 同学
     * @return 结果
     */
    public int updateClassmate(Classmate classmate);

    /**
     * 删除同学
     * 
     * @param id 同学主键
     * @return 结果
     */
    public int deleteClassmateById(Integer id);

    /**
     * 批量删除同学
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassmateByIds(Integer[] ids);
}
