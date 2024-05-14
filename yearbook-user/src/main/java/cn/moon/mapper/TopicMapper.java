package cn.moon.mapper;

import cn.moon.entity.Topic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopicMapper {
    List<Topic> findAll();

    List<Topic> findByType(String type);

    List<Topic> findByQuery(String keyword);
    int insertTopic(Topic topic);
    int deleteTopic(int id);
}
