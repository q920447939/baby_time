package com.musk.web.vo.res.home;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewsVO {
    private Integer newsSourceId;

    private String newsImageUrl;

    private String newsTitle;

    /**
     * 文章简要描述
     */
    private String briefDescription;

    private String newsOutline;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private LocalDateTime newsReleaseTime;

    private Long likeCount = 0L;

}
