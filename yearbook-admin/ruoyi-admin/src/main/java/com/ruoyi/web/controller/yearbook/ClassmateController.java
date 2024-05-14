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
import com.ruoyi.yearbook.domain.Classmate;
import com.ruoyi.yearbook.service.IClassmateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 同学Controller
 * 
 * @author ruoyi
 * @date 2024-03-30
 */
@RestController
@RequestMapping("/yearbook/classmate")
public class ClassmateController extends BaseController
{
    @Autowired
    private IClassmateService classmateService;

    /**
     * 查询同学列表
     */
    @PreAuthorize("@ss.hasPermi('yearbook:classmate:list')")
    @GetMapping("/list")
    public TableDataInfo list(Classmate classmate)
    {
        startPage();
        List<Classmate> list = classmateService.selectClassmateList(classmate);
        return getDataTable(list);
    }

    /**
     * 导出同学列表
     */
    @PreAuthorize("@ss.hasPermi('yearbook:classmate:export')")
    @Log(title = "同学", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Classmate classmate)
    {
        List<Classmate> list = classmateService.selectClassmateList(classmate);
        ExcelUtil<Classmate> util = new ExcelUtil<Classmate>(Classmate.class);
        util.exportExcel(response, list, "同学数据");
    }

    /**
     * 获取同学详细信息
     */
    @PreAuthorize("@ss.hasPermi('yearbook:classmate:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return success(classmateService.selectClassmateById(id));
    }

    /**
     * 新增同学
     */
    @PreAuthorize("@ss.hasPermi('yearbook:classmate:add')")
    @Log(title = "同学", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Classmate classmate)
    {
        return toAjax(classmateService.insertClassmate(classmate));
    }

    /**
     * 修改同学
     */
    @PreAuthorize("@ss.hasPermi('yearbook:classmate:edit')")
    @Log(title = "同学", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Classmate classmate)
    {
        return toAjax(classmateService.updateClassmate(classmate));
    }

    /**
     * 删除同学
     */
    @PreAuthorize("@ss.hasPermi('yearbook:classmate:remove')")
    @Log(title = "同学", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(classmateService.deleteClassmateByIds(ids));
    }
}
