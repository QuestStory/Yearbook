package cn.moon.service;

import cn.moon.entity.Tagboard;

import java.util.List;

public interface TagboardService {
    List<Tagboard> findAll();
    Tagboard findOne(int classmateId);
    int insertTag(Tagboard tagboard);
    int deleteTag(int id);
}
