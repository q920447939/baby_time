package com.musk.web.handle.cache.impl;


import com.alibaba.fastjson2.JSONObject;
import com.musk.web.enums.contextCache.ContextRedisCacheTypeEnum;
import com.musk.web.handle.cache.CacheKeyGeneratorStrategy;
import org.example.musk.common.context.ThreadLocalTenantContext;
import org.springframework.stereotype.Service;

@Service
public class JsonQueryCacheGeneratorStrategy implements CacheKeyGeneratorStrategy {

    @Override
    public String key(ContextRedisCacheTypeEnum rule, String keyPre, Object[] args) {
        Object object = args[0];
        return getKey(rule, keyPre, object);
    }

    private String getKey(ContextRedisCacheTypeEnum rule, String preKey, Object object) {
        String customerKey = JSONObject.toJSONString(object);
        if (ContextRedisCacheTypeEnum.TENANT_PACKAGE == rule) {
            return String.format(preKey, ThreadLocalTenantContext.getTenantId(), customerKey);
        }
        return String.format(preKey, ThreadLocalTenantContext.getTenantId(), ThreadLocalTenantContext.getMemberId(), customerKey);
    }
}
