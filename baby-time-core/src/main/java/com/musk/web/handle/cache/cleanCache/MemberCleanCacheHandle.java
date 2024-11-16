package com.musk.web.handle.cache.cleanCache;

import cn.hutool.extra.spring.SpringUtil;
import org.example.musk.middleware.redis.RedisUtil;
import org.springframework.stereotype.Service;



/**
 * 通用用户相关的缓存数据
 */
@Service
public class MemberCleanCacheHandle {

    public static RedisUtil getRedisUtil() {
        return SpringUtil.getBean(RedisUtil.class);
    }
}
