package com.musk.web.service.family;

import java.util.*;

import com.musk.web.controller.family.vo.FamilyPageReqVO;
import com.musk.web.controller.family.vo.FamilySaveReqVO;
import com.musk.web.dal.dataobject.family.FamilyDO;
import jakarta.validation.*;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.musk.common.pojo.db.PageResult;


/**
 * 家庭 Service 接口
 *
 * @author 马斯克源码
 */
public interface FamilyService extends IService<FamilyDO>{

    /**
     * 创建家庭
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createFamily(@Valid FamilySaveReqVO createReqVO);

    /**
     * 更新家庭
     *
     * @param updateReqVO 更新信息
     */
    void updateFamily(@Valid FamilySaveReqVO updateReqVO);

    /**
     * 删除家庭
     *
     * @param id 编号
     */
    void deleteFamily(Integer id);

    /**
     * 获得家庭
     *
     * @param id 编号
     * @return 家庭
     */
    FamilyDO getFamily(Integer id);

    /**
     * 获得家庭分页
     *
     * @param pageReqVO 分页查询
     * @return 家庭分页
     */
    PageResult<FamilyDO> getFamilyPage(FamilyPageReqVO pageReqVO);

}
