package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.NewEvaluateRepair;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-05-13
 */
public interface NewEvaluateRepairMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param evaluateId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public NewEvaluateRepair selectNewEvaluateRepairByEvaluateId(String evaluateId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param newEvaluateRepair 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<NewEvaluateRepair> selectNewEvaluateRepairList(NewEvaluateRepair newEvaluateRepair);

    /**
     * 新增【请填写功能名称】
     *
     * @param newEvaluateRepair 【请填写功能名称】
     * @return 结果
     */
    public int insertNewEvaluateRepair(NewEvaluateRepair newEvaluateRepair);

    /**
     * 修改【请填写功能名称】
     *
     * @param newEvaluateRepair 【请填写功能名称】
     * @return 结果
     */
    public int updateNewEvaluateRepair(NewEvaluateRepair newEvaluateRepair);

    /**
     * 删除【请填写功能名称】
     *
     * @param evaluateId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteNewEvaluateRepairByEvaluateId(String evaluateId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param evaluateIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNewEvaluateRepairByEvaluateIds(String[] evaluateIds);
}
