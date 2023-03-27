package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysPersonnel;

/**
 * 员工管理Service接口
 * 
 * @author lile
 * @date 2023-03-27
 */
public interface ISysPersonnelService 
{
    /**
     * 查询员工管理
     * 
     * @param personnelId 员工管理主键
     * @return 员工管理
     */
    public SysPersonnel selectSysPersonnelByPersonnelId(Long personnelId);

    /**
     * 查询员工管理列表
     * 
     * @param sysPersonnel 员工管理
     * @return 员工管理集合
     */
    public List<SysPersonnel> selectSysPersonnelList(SysPersonnel sysPersonnel);

    /**
     * 新增员工管理
     * 
     * @param sysPersonnel 员工管理
     * @return 结果
     */
    public int insertSysPersonnel(SysPersonnel sysPersonnel);

    /**
     * 修改员工管理
     * 
     * @param sysPersonnel 员工管理
     * @return 结果
     */
    public int updateSysPersonnel(SysPersonnel sysPersonnel);

    /**
     * 批量删除员工管理
     * 
     * @param personnelIds 需要删除的员工管理主键集合
     * @return 结果
     */
    public int deleteSysPersonnelByPersonnelIds(Long[] personnelIds);

    /**
     * 删除员工管理信息
     * 
     * @param personnelId 员工管理主键
     * @return 结果
     */
    public int deleteSysPersonnelByPersonnelId(Long personnelId);
}
