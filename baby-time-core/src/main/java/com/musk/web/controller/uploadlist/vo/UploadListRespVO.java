package com.musk.web.controller.uploadlist.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.musk.web.controller.uploaddiscuss.vo.UploadDiscussRespVO;
import com.musk.web.controller.uploadimage.vo.UploadImageRespVO;
import lombok.Data;
import org.example.musk.common.util.date.DateUtils;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UploadListRespVO {

    private Integer id;

    private Integer babyId;

    private Short uploadType;

    private Integer uploadUser;

    @JsonFormat(pattern = DateUtils.FORMAT_YEAR_MONTH_DAY, timezone = DateUtils.TIME_ZONE_DEFAULT)
    private LocalDateTime uploadTime;

    private String remark;

    @JsonFormat(pattern = DateUtils.FORMAT_YEAR_MONTH_DAY, timezone = DateUtils.TIME_ZONE_DEFAULT)
    private LocalDateTime createTime;

    private MemberSimpleResVO  memberSimpleResVO;

    private List<UploadDiscussRespVO> uploadDiscussRespVO;

    private List<UploadImageRespVO>  uploadImageRespVO;

}
