package com.ruoyi.yearbook.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.yearbook.mapper.TopicMapper;
import com.ruoyi.yearbook.domain.Topic;
import com.ruoyi.yearbook.service.ITopicService;

/**
 * 话题Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
@Service
public class TopicServiceImpl implements ITopicService 
{
    @Autowired
    private TopicMapper topicMapper;

    /**
     * 查询话题
     * 
     * @param id 话题主键
     * @return 话题
     */
    @Override
    public Topic selectTopicById(Integer id)
    {
        return topicMapper.selectTopicById(id);
    }

    /**
     * 查询话题列表
     * 
     * @param topic 话题
     * @return 话题
     */
    @Override
    public List<Topic> selectTopicList(Topic topic)
    {
        return topicMapper.selectTopicList(topic);
    }

    /**
     * 新增话题
     * 
     * @param topic 话题
     * @return 结果
     */
    @Override
    public int insertTopic(Topic topic)
    {
        topic.setCreateTime(DateUtils.getNowDate());
        return topicMapper.insertTopic(topic);
    }

    /**
     * 修改话题
     * 
     * @param topic 话题
     * @return 结果
     */
    @Override
    public int updateTopic(Topic topic)
    {
        return topicMapper.updateTopic(topic);
    }

    /**
     * 批量删除话题
     * 
     * @param ids 需要删除的话题主键
     * @return 结果
     */
    @Override
    public int deleteTopicByIds(Integer[] ids)
    {
        return topicMapper.deleteTopicByIds(ids);
    }

    /**
     * 删除话题信息
     * 
     * @param id 话题主键
     * @return 结果
     */
    @Override
    public int deleteTopicById(Integer id)
    {
        return topicMapper.deleteTopicById(id);
    }
}
