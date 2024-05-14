package com.ruoyi.web.controller.yearbook;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.yearbook.domain.Topic;
import com.ruoyi.yearbook.service.ITopicService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 话题Controller
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
@RestController
@RequestMapping("/yearbook/topic")
public class TopicController extends BaseController
{
    @Autowired
    private ITopicService topicService;

    /**
     * 查询话题列表
     */
    @PreAuthorize("@ss.hasPermi('yearbook:topic:list')")
    @GetMapping("/list")
    public TableDataInfo list(Topic topic)
    {
        startPage();
        List<Topic> list = topicService.selectTopicList(topic);
        return getDataTable(list);
    }

    /**
     * 导出话题列表
     */
    @PreAuthorize("@ss.hasPermi('yearbook:topic:export')")
    @Log(title = "话题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Topic topic)
    {
        List<Topic> list = topicService.selectTopicList(topic);
        ExcelUtil<Topic> util = new ExcelUtil<Topic>(Topic.class);
        util.exportExcel(response, list, "话题数据");
    }

    /**
     * 获取话题详细信息
     */
    @PreAuthorize("@ss.hasPermi('yearbook:topic:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(topicService.selectTopicById(id));
    }

    /**
     * 新增话题
     */
    @PreAuthorize("@ss.hasPermi('yearbook:topic:add')")
    @Log(title = "话题", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Topic topic)
    {
        return toAjax(topicService.insertTopic(topic));
    }

    /**
     * 修改话题
     */
    @PreAuthorize("@ss.hasPermi('yearbook:topic:edit')")
    @Log(title = "话题", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Topic topic)
    {
        return toAjax(topicService.updateTopic(topic));
    }

    /**
     * 删除话题
     */
    @PreAuthorize("@ss.hasPermi('yearbook:topic:remove')")
    @Log(title = "话题", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(topicService.deleteTopicByIds(ids));
    }
}
