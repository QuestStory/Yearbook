package cn.moon.service.impl;

import cn.moon.entity.Remark;
import cn.moon.mapper.RemarkMapper;
import cn.moon.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemarkServiceImpl implements RemarkService {

    @Autowired
    private RemarkMapper remarkMapper;

    @Override
    public List<Remark> findAll() {
        return remarkMapper.findAll();
    }

    @Override
    public List<Remark> findByTopicId(int id){
        return remarkMapper.findByTopicId(id);
    }

    @Override
    public int insertRemark(Remark remark) {
        return remarkMapper.insertRemark(remark);
    }

    @Override
    public int deleteRemark(int id) {
        return remarkMapper.deleteRemark(id);
    }
}
