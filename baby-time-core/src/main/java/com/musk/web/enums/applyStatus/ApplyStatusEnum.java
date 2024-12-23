package com.musk.web.enums.applyStatus;

import lombok.Getter;

/**
 * ClassName: ApplyStatusEnum
 * @Description:
 * @author
 * @date 2024年12月20日
 */
@Getter
public enum ApplyStatusEnum {
    APPLING(1,"申请中"),
    APPLY_SUCC(2,"申请成功"),
    APPLY_FAIL(3,"拒绝"),
    APPLY_CANCEL(4,"申请人撤销"),
    END(999,"");

    private Integer status ;
    private String desc ;

    ApplyStatusEnum(Integer status,String desc ){
        this.status = status;
        this.desc = desc;
    }

}
