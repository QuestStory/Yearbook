package com.ruoyi.yearbook.mapper;

import java.util.List;
import com.ruoyi.yearbook.domain.Topic;

/**
 * 话题Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public interface TopicMapper 
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
     * 删除话题
     * 
     * @param id 话题主键
     * @return 结果
     */
    public int deleteTopicById(Integer id);

    /**
     * 批量删除话题
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTopicByIds(Integer[] ids);
}
