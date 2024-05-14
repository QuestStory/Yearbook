package cn.moon.mapper;

import cn.moon.entity.Classmate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassmateMapper {
    Classmate findOne(int id);
    List<Classmate> findAll();
    List<Classmate> findByQuery(String searchText);
    Classmate randomFindSigns();
    int updateProfile(int id,String profile);
    int updatePassword(int id,String password);
    int updateBasic(Classmate classmate);
    int updateContact(Classmate classmate);
    int updateIntro(Classmate classmate);
}
