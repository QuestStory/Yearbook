package cn.moon.service.impl;

import cn.moon.entity.Classes;
import cn.moon.mapper.ClassesMapper;
import cn.moon.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public Classes queryClasses() {
        return classesMapper.queryClasses();
    }


    @Override
    public int updateClasses(Classes classes) {
        return classesMapper.updateClasses(classes);
    }
}
