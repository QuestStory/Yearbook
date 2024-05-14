package cn.moon.mapper;

import cn.moon.entity.Classes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassesMapper {
    Classes queryClasses();
    int updateClasses(Classes classinfo);
}
