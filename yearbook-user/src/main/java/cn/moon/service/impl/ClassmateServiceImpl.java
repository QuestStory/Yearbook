package cn.moon.service.impl;

import cn.moon.entity.Classmate;
import cn.moon.mapper.ClassmateMapper;
import cn.moon.service.ClassmateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassmateServiceImpl implements ClassmateService {

    @Autowired
    private ClassmateMapper classmateMapper;

    /*
    * 根据id查找
    * */
    @Override
    public Classmate findOne(int id) {
        return classmateMapper.findOne(id);
    }

    /*
    * 分页列表
    * */
    @Override
    public PageInfo<Classmate> findAll(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Classmate> classmates=classmateMapper.findAll();
        PageInfo<Classmate> allPageInfo = new PageInfo<>(classmates);
        return allPageInfo;
    }

    /*
    * 条件分页查询
    * */
    @Override
    public PageInfo<Classmate> findByQuery(Integer pageIndex, Integer pageSize, String searchText) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Classmate> classmates=classmateMapper.findByQuery(searchText);
        PageInfo<Classmate> queryPageInfo = new PageInfo<>(classmates);
        return queryPageInfo;
    }

    /*
    * 随机个性签名
    * */
    @Override
    public Classmate randomFindSigns() {
        Classmate classmate=classmateMapper.randomFindSigns();
        return classmate;
    }

    @Override
    public int updateProfile(int id, String profile) {
        return classmateMapper.updateProfile(id,profile);
    }

    @Override
    public int updatePassword(int id, String password) {
        return classmateMapper.updatePassword(id,password);
    }

    @Override
    public int updateBasic(Classmate classmate) {
        return classmateMapper.updateBasic(classmate);
    }

    @Override
    public int updateContact(Classmate classmate) {
        return classmateMapper.updateContact(classmate);
    }

    @Override
    public int updateIntro(Classmate classmate) {
        return classmateMapper.updateIntro(classmate);
    }
}
