package com.ruoyi.yearbook.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.yearbook.mapper.TagboardMapper;
import com.ruoyi.yearbook.domain.Tagboard;
import com.ruoyi.yearbook.service.ITagboardService;

/**
 * 留言条Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-30
 */
@Service
public class TagboardServiceImpl implements ITagboardService 
{
    @Autowired
    private TagboardMapper tagboardMapper;

    /**
     * 查询留言条
     * 
     * @param id 留言条主键
     * @return 留言条
     */
    @Override
    public Tagboard selectTagboardById(Integer id)
    {
        return tagboardMapper.selectTagboardById(id);
    }

    /**
     * 查询留言条列表
     * 
     * @param tagboard 留言条
     * @return 留言条
     */
    @Override
    public List<Tagboard> selectTagboardList(Tagboard tagboard)
    {
        return tagboardMapper.selectTagboardList(tagboard);
    }

    /**
     * 新增留言条
     * 
     * @param tagboard 留言条
     * @return 结果
     */
    @Override
    public int insertTagboard(Tagboard tagboard)
    {
        tagboard.setCreateTime(DateUtils.getNowDate());
        return tagboardMapper.insertTagboard(tagboard);
    }

    /**
     * 修改留言条
     * 
     * @param tagboard 留言条
     * @return 结果
     */
    @Override
    public int updateTagboard(Tagboard tagboard)
    {
        return tagboardMapper.updateTagboard(tagboard);
    }

    /**
     * 批量删除留言条
     * 
     * @param ids 需要删除的留言条主键
     * @return 结果
     */
    @Override
    public int deleteTagboardByIds(Integer[] ids)
    {
        return tagboardMapper.deleteTagboardByIds(ids);
    }

    /**
     * 删除留言条信息
     * 
     * @param id 留言条主键
     * @return 结果
     */
    @Override
    public int deleteTagboardById(Integer id)
    {
        return tagboardMapper.deleteTagboardById(id);
    }
}
