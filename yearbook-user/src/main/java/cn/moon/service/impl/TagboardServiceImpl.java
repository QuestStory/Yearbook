package cn.moon.service.impl;

import cn.moon.entity.Tagboard;
import cn.moon.mapper.TagboardMapper;
import cn.moon.service.TagboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagboardServiceImpl implements TagboardService{

    @Autowired
    private TagboardMapper tagboardMapper;

    @Override
    public List<Tagboard> findAll() {
        return tagboardMapper.findAll();
    }

    @Override
    public Tagboard findOne(int classmateId) {
        return tagboardMapper.findOne(classmateId);
    }

    @Override
    public int insertTag(Tagboard tagboard) {
        return tagboardMapper.insertTag(tagboard);
    }

    @Override
    public int deleteTag(int id) {
        return tagboardMapper.deleteTag(id);
    }
}
