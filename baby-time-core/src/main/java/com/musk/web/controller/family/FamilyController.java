package com.musk.web.controller.family;

import com.musk.web.controller.family.vo.FamilyPageReqVO;
import com.musk.web.controller.family.vo.FamilyRespVO;
import com.musk.web.controller.family.vo.FamilySaveReqVO;
import com.musk.web.dal.dataobject.family.FamilyDO;
import com.musk.web.service.family.FamilyService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.example.musk.common.context.ThreadLocalTenantContext;
import org.example.musk.common.pojo.CommonResult;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.example.musk.common.pojo.CommonResult.success;


@RestController
@RequestMapping("/baby/family")
@Validated
public class FamilyController {

    @Resource
    private FamilyService familyService;

    /**
     * 创建家庭
     */
    @PostMapping("/create")
    public CommonResult<Integer> createFamily(@Valid @RequestBody FamilySaveReqVO createReqVO) {
        createReqVO.setCreateId(ThreadLocalTenantContext.getMemberId());
        return success(familyService.createFamily(createReqVO));
    }

    /**
     * 更新家庭
     */
    @PutMapping("/update")
    public CommonResult<Boolean> updateFamily(@Valid @RequestBody FamilySaveReqVO updateReqVO) {
        familyService.updateFamily(updateReqVO);
        return success(true);
    }

    /**
     * 删除家庭
     */
    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteFamily(@RequestParam("id") Integer id) {
        familyService.deleteFamily(id);
        return success(true);
    }

    /**
     * 获得家庭
     */
    @GetMapping("/get")
    public CommonResult<FamilyRespVO> getFamily(@RequestParam("id") Integer id) {
        FamilyDO family = familyService.getFamily(id);
        return success(BeanUtils.toBean(family, FamilyRespVO.class));
    }


    /**
     * 获得家庭分页
     */
    @GetMapping("/page")
    public CommonResult<PageResult<FamilyRespVO>> getFamilyPage(@Valid FamilyPageReqVO pageReqVO) {
        PageResult<FamilyDO> pageResult = familyService.getFamilyPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FamilyRespVO.class));
    }


}
