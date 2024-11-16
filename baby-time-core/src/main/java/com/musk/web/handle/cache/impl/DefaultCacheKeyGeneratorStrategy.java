package com.musk.web.handle.cache.impl;


import com.musk.web.enums.contextCache.ContextRedisCacheTypeEnum;
import com.musk.web.handle.cache.CacheKeyGeneratorStrategy;
import org.example.musk.common.context.ThreadLocalTenantContext;
import org.springframework.stereotype.Service;

@Service
public class DefaultCacheKeyGeneratorStrategy implements CacheKeyGeneratorStrategy {

    @Override
    public String key(ContextRedisCacheTypeEnum rule, String keyPre, Object[] args) {
        return getKey(rule,keyPre);
    }

    private String getKey(ContextRedisCacheTypeEnum rule,String preKey) {
        if (ContextRedisCacheTypeEnum.TENANT_PACKAGE == rule) {
            return String.format(preKey, ThreadLocalTenantContext.getTenantId());
        }
        return String.format(preKey, ThreadLocalTenantContext.getTenantId(), ThreadLocalTenantContext.getMemberId());
    }
}
