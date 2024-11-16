package com.musk.web.handle.cache;


import com.musk.web.enums.contextCache.ContextRedisCacheTypeEnum;

public interface CacheKeyGeneratorStrategy {

    String key(ContextRedisCacheTypeEnum rule , String keyPre, Object[] args);
}
