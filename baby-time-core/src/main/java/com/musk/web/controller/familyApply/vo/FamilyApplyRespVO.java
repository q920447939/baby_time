package com.musk.web.controller.familyApply.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.musk.web.controller.uploadlist.vo.MemberSimpleResVO;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import lombok.*;

@Data
public class FamilyApplyRespVO {

    private Integer id;

    private Integer applyFamilyId;

    private String applyFamilyCode;

    private Integer applyId;

    private Integer applyStatus;

    private String failReason;

    private String creator;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private LocalDateTime createTime;

    private String updater;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private LocalDateTime updateTime;

    /**
     * 家庭编码
     */
    private String familyCode;

    private MemberSimpleResVO applyInfo;

}
