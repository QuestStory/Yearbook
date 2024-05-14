package com.ruoyi.yearbook.service;

import java.util.List;
import com.ruoyi.yearbook.domain.Topic;

/**
 * 话题Service接口
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public interface ITopicService 
{
    /**
     * 查询话题
     * 
     * @param id 话题主键
     * @return 话题
     */
    public Topic selectTopicById(Integer id);

    /**
     * 查询话题列表
     * 
     * @param topic 话题
     * @return 话题集合
     */
    public List<Topic> selectTopicList(Topic topic);

    /**
     * 新增话题
     * 
     * @param topic 话题
     * @return 结果
     */
    public int insertTopic(Topic topic);

    /**
     * 修改话题
     * 
     * @param topic 话题
     * @return 结果
     */
    public int updateTopic(Topic topic);

    /**
     * 批量删除话题
     * 
     * @param ids 需要删除的话题主键集合
     * @return 结果
     */
    public int deleteTopicByIds(Integer[] ids);

    /**
     * 删除话题信息
     * 
     * @param id 话题主键
     * @return 结果
     */
    public int deleteTopicById(Integer id);
}
