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
import com.ruoyi.yearbook.domain.Tagboard;
import com.ruoyi.yearbook.service.ITagboardService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 留言条Controller
 * 
 * @author ruoyi
 * @date 2024-03-30
 */
@RestController
@RequestMapping("/yearbook/tagboard")
public class TagboardController extends BaseController
{
    @Autowired
    private ITagboardService tagboardService;

    /**
     * 查询留言条列表
     */
    @PreAuthorize("@ss.hasPermi('yearbook:tagboard:list')")
    @GetMapping("/list")
    public TableDataInfo list(Tagboard tagboard)
    {
        startPage();
        List<Tagboard> list = tagboardService.selectTagboardList(tagboard);
        return getDataTable(list);
    }

    /**
     * 导出留言条列表
     */
    @PreAuthorize("@ss.hasPermi('yearbook:tagboard:export')")
    @Log(title = "留言条", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Tagboard tagboard)
    {
        List<Tagboard> list = tagboardService.selectTagboardList(tagboard);
        ExcelUtil<Tagboard> util = new ExcelUtil<Tagboard>(Tagboard.class);
        util.exportExcel(response, list, "留言条数据");
    }

    /**
     * 获取留言条详细信息
     */
    @PreAuthorize("@ss.hasPermi('yearbook:tagboard:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(tagboardService.selectTagboardById(id));
    }

    /**
     * 新增留言条
     */
    @PreAuthorize("@ss.hasPermi('yearbook:tagboard:add')")
    @Log(title = "留言条", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Tagboard tagboard)
    {
        return toAjax(tagboardService.insertTagboard(tagboard));
    }

    /**
     * 修改留言条
     */
    @PreAuthorize("@ss.hasPermi('yearbook:tagboard:edit')")
    @Log(title = "留言条", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Tagboard tagboard)
    {
        return toAjax(tagboardService.updateTagboard(tagboard));
    }

    /**
     * 删除留言条
     */
    @PreAuthorize("@ss.hasPermi('yearbook:tagboard:remove')")
    @Log(title = "留言条", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(tagboardService.deleteTagboardByIds(ids));
    }
}
