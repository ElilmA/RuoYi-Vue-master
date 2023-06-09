package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.controller.AppBaseController;
import com.ruoyi.common.core.domain.entity.SysPersonnel;
import com.ruoyi.system.domain.SysPatrolOrder;
import com.ruoyi.system.domain.SysPatrolPoint;
import com.ruoyi.system.domain.SysRepair;
import com.ruoyi.system.service.ISysPatrolPointService;
import com.ruoyi.system.service.ISysPersonnelService;
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
import com.ruoyi.system.domain.SysRepairOrder;
import com.ruoyi.system.service.ISysRepairOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 维修工单Controller
 *
 * @author lile
 * @date 2023-04-03
 */
@RestController
@RequestMapping("/system/repairOrder")
public class SysRepairOrderController extends AppBaseController
{
    @Autowired
    private ISysRepairOrderService sysRepairOrderService;

    @Autowired
    private ISysPersonnelService personnelService;

    @Autowired
    private ISysPatrolPointService patrolPointService;

    /**
     * 查询维修工单列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysRepairOrder sysRepairOrder)
    {
        startPage();
        List<SysRepairOrder> list = sysRepairOrderService.selectSysRepairOrderList(sysRepairOrder);
        return getDataTable(list);
    }

    /**
     * 导出维修工单列表
     */
    @Log(title = "维修工单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysRepairOrder sysRepairOrder)
    {
        List<SysRepairOrder> list = sysRepairOrderService.selectSysRepairOrderList(sysRepairOrder);
        ExcelUtil<SysRepairOrder> util = new ExcelUtil<SysRepairOrder>(SysRepairOrder.class);
        util.exportExcel(response, list, "维修工单数据");
    }

    /**
     * 获取维修工单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:repairOrder:query')")
    @GetMapping(value = "/{repairOrderId}")
    public AjaxResult getInfo(@PathVariable("repairOrderId") Long repairOrderId)
    {
        AjaxResult ajax = AjaxResult.success();
        SysRepairOrder sysRepairOrder = sysRepairOrderService.selectSysRepairOrderByRepairOrderId(repairOrderId);
        ajax.put(AjaxResult.DATA_TAG,sysRepairOrder);
        ajax.put("imgUrls",sysRepairOrderService.selectImgUrlsByRepairOrderId(repairOrderId));
        return ajax;
    }

    /**
     * 新增维修工单
     */
    @Log(title = "维修工单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRepairOrder sysRepairOrder)
    {
        SysPatrolPoint sysPatrolPoint = patrolPointService.selectSysPatrolPointByPatrolPointId(sysRepairOrder.getPatrolPointId());
        sysRepairOrder.setPatrolPointName(sysPatrolPoint.getPatrolPointName());
        SysPersonnel sysPersonnel = personnelService.selectSysPersonnelByPersonnelId(getAppUserId());
        sysRepairOrder.setPersonnelId(getAppUserId());
        sysRepairOrder.setPersonnelName(getAppUsername());
        sysRepairOrder.setPersonnelPhone(sysPersonnel.getPersonnelPhone());
        return toAjax(sysRepairOrderService.insertSysRepairOrder(sysRepairOrder));
    }

    /**
     * 生成维修任务
     */
    @GetMapping(value = "/createRepair/{repairOrderId}")
    public AjaxResult createRepair(@PathVariable("repairOrderId") Long repairOrderId) {
        SysRepairOrder sysRepairOrder = sysRepairOrderService.selectSysRepairOrderByRepairOrderId(repairOrderId);
        SysRepair repair = new SysRepair();
        repair.setRepairName(sysRepairOrder.getPatrolPointName());
        repair.setRepairDescribe(sysRepairOrder.getRepairOrderDescribe());
        repair.setRepairStatus("0");
        Long[] longArrayForPoints = {sysRepairOrder.getPatrolPointId()};
        repair.setPatrolPointIds(longArrayForPoints);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("personnels", personnelService.selectPersonnelAll());
        ajax.put("patrolPoints", patrolPointService.selectPatrolPointAll());
        ajax.put(AjaxResult.DATA_TAG, repair);
        ajax.put("patrolPointIds", longArrayForPoints);
        ajax.put("imgUrls",sysRepairOrder.getImgUrls());
        return ajax;
    }

    /**
     * 修改维修工单
     */
    @Log(title = "维修工单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRepairOrder sysRepairOrder)
    {
        return toAjax(sysRepairOrderService.updateSysRepairOrder(sysRepairOrder));
    }

    /**
     * 删除维修工单
     */
    @Log(title = "维修工单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{repairOrderIds}")
    public AjaxResult remove(@PathVariable Long[] repairOrderIds)
    {
        return toAjax(sysRepairOrderService.deleteSysRepairOrderByRepairOrderIds(repairOrderIds));
    }
}
