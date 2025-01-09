package com.musk.web.controller.uploadlist.vo;

import lombok.Data;
import lombok.ToString;


@Data
@ToString(callSuper = true)
public class MemberSimpleMoreResVO {

    private Integer id;
    private String memberCode;

    private String memberNickName;

    /**
     * 头像地址
     */
    private String avatar;

}
