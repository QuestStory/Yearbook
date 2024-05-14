package cn.moon.mapper;

import cn.moon.entity.Remark;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RemarkMapper {
    List<Remark> findAll();
    List<Remark> findByTopicId(int id);
    int insertRemark(Remark remark);
    int deleteRemark(int id);
}
