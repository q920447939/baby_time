package com.musk.web.service.familyApply;

import com.baomidou.mybatisplus.extension.service.IService;
import com.musk.web.dal.dataobject.familyApply.FamilyApplyDO;
import com.musk.web.dal.dataobject.familyApply.bo.FamilyApplyPageReqBO;
import jakarta.validation.*;
import org.example.musk.common.pojo.db.PageResult;

import java.util.Collections;
import java.util.List;

/**
 * 家庭申请 Service 接口
 *
 * @author 代码生成器
 */
public interface FamilyApplyService extends IService<FamilyApplyDO> {

    /**
     * 创建家庭申请
     *
     * @param familyApplyDO 创建信息
     * @return ID
     */
    Integer createFamilyApply(@Valid FamilyApplyDO familyApplyDO);
    /**
     * 更��家庭申请
     *
     * @param updateFamilyApply 更新信息
     */
    void updateFamilyApplyById(Integer id, @Valid FamilyApplyDO updateFamilyApply);
    /**
     * 删除家庭申请
     *
     * @param id 编号
     */
    void deleteFamilyApply(Integer id);
    /**
     * 获得家庭申请
     *
     * @param id 编号
     * @return 家庭申请信息
     */
    default FamilyApplyDO getFamilyApply(Integer id){
         List<FamilyApplyDO> resultList =  getFamilyApplyByIds(Collections.singletonList(id));
         return  (null == resultList || resultList.isEmpty()) ? null : resultList.getFirst();
    }
    /**
     * 获得家庭申请
     *
     * @param ids 编号编号
     * @return 家庭申请信息
     */
    List<FamilyApplyDO> getFamilyApplyByIds(List<Integer> ids);
    /**
     * 家庭申请分页查询
     *
     * @param pageReqBO 分页查询参数
     * @return 家庭申请分页数据
     */
    PageResult<FamilyApplyDO> getFamilyApplyPage(FamilyApplyPageReqBO pageReqBO);

    boolean updateApplyStatus(@Valid Integer id, Integer applyStatus);
}
