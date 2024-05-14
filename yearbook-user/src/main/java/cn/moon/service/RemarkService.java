package cn.moon.service;

import cn.moon.entity.Remark;

import java.util.List;

public interface RemarkService {
    List<Remark> findAll();
    List<Remark> findByTopicId(int id);
    int insertRemark(Remark remark);
    int deleteRemark(int id);
}
