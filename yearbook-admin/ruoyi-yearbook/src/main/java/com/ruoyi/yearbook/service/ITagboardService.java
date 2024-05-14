package com.ruoyi.yearbook.service;

import java.util.List;
import com.ruoyi.yearbook.domain.Tagboard;

/**
 * 留言条Service接口
 * 
 * @author ruoyi
 * @date 2024-03-30
 */
public interface ITagboardService 
{
    /**
     * 查询留言条
     * 
     * @param id 留言条主键
     * @return 留言条
     */
    public Tagboard selectTagboardById(Integer id);

    /**
     * 查询留言条列表
     * 
     * @param tagboard 留言条
     * @return 留言条集合
     */
    public List<Tagboard> selectTagboardList(Tagboard tagboard);

    /**
     * 新增留言条
     * 
     * @param tagboard 留言条
     * @return 结果
     */
    public int insertTagboard(Tagboard tagboard);

    /**
     * 修改留言条
     * 
     * @param tagboard 留言条
     * @return 结果
     */
    public int updateTagboard(Tagboard tagboard);

    /**
     * 批量删除留言条
     * 
     * @param ids 需要删除的留言条主键集合
     * @return 结果
     */
    public int deleteTagboardByIds(Integer[] ids);

    /**
     * 删除留言条信息
     * 
     * @param id 留言条主键
     * @return 结果
     */
    public int deleteTagboardById(Integer id);
}
