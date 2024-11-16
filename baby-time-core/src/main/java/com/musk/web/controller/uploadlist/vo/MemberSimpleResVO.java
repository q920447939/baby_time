package com.musk.web.controller.uploadlist.vo;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString(callSuper = true)
public class MemberSimpleResVO {


    private String memberCode;

    private String memberNickName;

    /**
     * 头像地址
     */
    private String avatar;

}
