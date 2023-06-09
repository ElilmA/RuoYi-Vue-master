package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysPatrolOrder;
import com.ruoyi.system.domain.SysPatrolOrderImg;

/**
 * 巡更工单管理Mapper接口
 *
 * @author lile
 * @date 2023-03-31
 */
public interface SysPatrolOrderMapper
{
    /**
     * 查询巡更工单管理
     *
     * @param patrolOrderId 巡更工单管理主键
     * @return 巡更工单管理
     */
    public SysPatrolOrder selectSysPatrolOrderByPatrolOrderId(Long patrolOrderId);

    /**
     * 查询巡更工单管理列表
     *
     * @param sysPatrolOrder 巡更工单管理
     * @return 巡更工单管理集合
     */
    public List<SysPatrolOrder> selectSysPatrolOrderList(SysPatrolOrder sysPatrolOrder);

    /**
     * 新增巡更工单管理
     *
     * @param sysPatrolOrder 巡更工单管理
     * @return 结果
     */
    public int insertSysPatrolOrder(SysPatrolOrder sysPatrolOrder);

    /**
     * 修改巡更工单管理
     *
     * @param sysPatrolOrder 巡更工单管理
     * @return 结果
     */
    public int updateSysPatrolOrder(SysPatrolOrder sysPatrolOrder);

    /**
     * 删除巡更工单管理
     *
     * @param patrolOrderId 巡更工单管理主键
     * @return 结果
     */
    public int deleteSysPatrolOrderByPatrolOrderId(Long patrolOrderId);

    /**
     * 批量删除巡更工单管理
     *
     * @param patrolOrderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysPatrolOrderByPatrolOrderIds(Long[] patrolOrderIds);


}
