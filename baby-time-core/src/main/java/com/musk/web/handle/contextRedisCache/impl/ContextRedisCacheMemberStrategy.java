package com.musk.web.handle.contextRedisCache.impl;

import com.musk.web.handle.contextRedisCache.ContextRedisCacheStrategy;
import org.springframework.stereotype.Service;


@Service
public class ContextRedisCacheMemberStrategy implements ContextRedisCacheStrategy {

    @Override
    public String getKey() {
        return null;
    }
}
