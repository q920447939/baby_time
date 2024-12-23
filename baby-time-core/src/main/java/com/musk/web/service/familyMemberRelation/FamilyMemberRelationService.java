package com.musk.web.service.familyMemberRelation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.musk.web.dal.dataobject.familyMemberRelation.FamilyMemberRelationDO;
import com.musk.web.dal.dataobject.familyMemberRelation.bo.FamilyMemberRelationPageReqBO;
import jakarta.validation.*;
import org.example.musk.common.pojo.db.PageResult;

import java.util.List;

/**
 *  Service 接口
 *
 * @author 代码生成器
 */
public interface FamilyMemberRelationService extends IService<FamilyMemberRelationDO> {

    /**
     * 创建
     *
     * @param familyMemberRelationDO 创建信息
     * @return ID
     */
    Integer createFamilyMemberRelation(@Valid FamilyMemberRelationDO familyMemberRelationDO);
    /**
     * 更新
     *
     * @param updateFamilyMemberRelation 更新信息
     */
    void updateFamilyMemberRelationById(Integer id, @Valid FamilyMemberRelationDO updateFamilyMemberRelation);
    /**
     * 删除
     *
     * @param id 编号
     */
    void deleteFamilyMemberRelation(Integer id);
    /**
     * 获得
     *
     * @param id 编号
     * @return
     */
    FamilyMemberRelationDO getFamilyMemberRelation(Integer id);
    /**
     * 获得分页
     *
     * @param pageReqBO 分页查询
     * @return 分页
     */
    PageResult<FamilyMemberRelationDO> getFamilyMemberRelationPage(FamilyMemberRelationPageReqBO pageReqBO);


    List<FamilyMemberRelationDO> getFamilyMemberRelationByMemberId(Integer memberId);

}
