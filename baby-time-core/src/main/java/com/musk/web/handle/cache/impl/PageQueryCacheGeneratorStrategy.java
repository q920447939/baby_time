package com.musk.web.handle.cache.impl;


import com.musk.web.enums.contextCache.ContextRedisCacheTypeEnum;
import com.musk.web.handle.cache.CacheKeyGeneratorStrategy;
import org.example.musk.common.context.ThreadLocalTenantContext;
import org.example.musk.common.pojo.db.PageParam;
import org.springframework.stereotype.Service;

@Service
public class PageQueryCacheGeneratorStrategy implements CacheKeyGeneratorStrategy {

    @Override
    public String key(ContextRedisCacheTypeEnum rule, String keyPre, Object[] args) {
        PageParam pageParam = (PageParam) args[0];
        return getKey(rule, keyPre,pageParam.getPageNo() , pageParam.getPageSize());
    }

    private String getKey(ContextRedisCacheTypeEnum rule,String preKey,Integer pageNo ,Integer pageSize) {
        if (ContextRedisCacheTypeEnum.TENANT_PACKAGE == rule) {
            return String.format(preKey, ThreadLocalTenantContext.getTenantId(),pageNo,pageSize);
        }
        return String.format(preKey, ThreadLocalTenantContext.getTenantId(), ThreadLocalTenantContext.getMemberId(),pageNo,pageSize);
    }
}
