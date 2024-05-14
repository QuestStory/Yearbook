package cn.moon.service.impl;

import cn.moon.entity.Topic;
import cn.moon.mapper.TopicMapper;
import cn.moon.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public List<Topic> findAll() {
        return topicMapper.findAll();
    }

    @Override
    public List<Topic> findByType(String type) {
        return topicMapper.findByType(type);
    }

    @Override
    public List<Topic> findByQuery(String keyword) {
        return topicMapper.findByQuery(keyword);
    }

    @Override
    public int insertTopic(Topic topic) {
        return topicMapper.insertTopic(topic);
    }

    @Override
    public int deleteTopic(int id) {
        return topicMapper.deleteTopic(id);
    }
}
