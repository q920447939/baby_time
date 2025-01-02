package com.musk.web.controller.baby.vo;

import lombok.*;

import java.time.LocalDate;

import jakarta.validation.constraints.*;

@Data
public class BabyInfoSaveReqVO {

    private Integer id;

    @NotNull(message = "家庭不能为空")
    private Integer familyId;

    @NotEmpty(message = "宝宝昵称不能为空")
    private String name;

    private String avatarUrl;

    @NotNull(message = "性别不能为空")
    private Short sex;

    @NotNull(message = "出生日期不能为空")
    private LocalDate birthday;

}
