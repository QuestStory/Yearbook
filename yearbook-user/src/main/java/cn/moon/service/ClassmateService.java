package cn.moon.service;

import cn.moon.entity.Classmate;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ClassmateService {
    Classmate findOne(int id);
    PageInfo<Classmate> findAll(Integer pageIndex, Integer pageSize);
    PageInfo<Classmate> findByQuery(Integer pageIndex, Integer pageSize, String searchText);
    Classmate randomFindSigns();

    int updateProfile(int id,String profile);
    int updatePassword(int id,String password);
    int updateBasic(Classmate classmate);
    int updateContact(Classmate classmate);
    int updateIntro(Classmate classmate);
}
