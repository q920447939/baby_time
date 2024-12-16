package com.musk.web.exception;/**
 * @Project:
 * @Author:
 * @Date: 2021年09月14日
 */

import cn.hutool.core.lang.Assert;
import lombok.Getter;
import org.example.musk.common.exception.IBaseErrorInfo;

import java.util.Arrays;
import java.util.Optional;

/**
 * ClassName: BusinessPageExceptionEnum
 *
 * @author
 * @Description:  页面业务异常，可在页面上展示的异常
 * 开始编码 4100000
 * 结束编码 4200000
 * @date 2021年09月14日
 */
@Getter
public enum BusinessExceptionEnum implements IBaseErrorInfo {

    FAMILY_IS_EXISTS("4210002", "家庭已存在"),
    TAG_IS_RELATION("4210103", "该标签已被关联"),
    TAG_RELATION_NOT_EXISTS("4210104", "该标签未存在关联"),



    END("4200000", "");
    private String exCode;
    private String exDesc;

    BusinessExceptionEnum(String exCode, String exDesc) {
        this.exCode = exCode;
        this.exDesc = exDesc;
    }


    @Override
    public String getResultCode() {
        return this.exCode;
    }

    @Override
    public String getResultMsg() {
        return this.getExDesc();
    }

    public static BusinessExceptionEnum getBusinessPageExceptionEnumByCode(String code){
        Assert.notNull(code);
        return Optional.ofNullable(Arrays.stream(BusinessExceptionEnum.values()).filter(k->k.getExCode().equals(code)).findFirst().get()).orElse(null);
    }
}
