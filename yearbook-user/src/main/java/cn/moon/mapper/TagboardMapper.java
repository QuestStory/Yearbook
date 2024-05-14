package cn.moon.mapper;

import cn.moon.entity.Tagboard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagboardMapper {
    List<Tagboard> findAll();
    Tagboard findOne(int classmateId);
    int insertTag(Tagboard tagboard);
    int deleteTag(int id);
}
