package com.musk.web.vo.res;


import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ResBaseVO implements Serializable {

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
