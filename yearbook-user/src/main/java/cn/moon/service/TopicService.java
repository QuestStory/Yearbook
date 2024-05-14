package cn.moon.service;

import cn.moon.entity.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> findAll();

    List<Topic> findByType(String type);

    List<Topic> findByQuery(String keyword);
    int insertTopic(Topic topic);
    int deleteTopic(int id);
}
