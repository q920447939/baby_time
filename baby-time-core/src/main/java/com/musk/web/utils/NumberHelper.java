package com.musk.web.utils;

/**
 * @Description:
 * @date 2024年08月20日
 */
public class NumberHelper {

    public static int getNumberExcludeNull(Integer v){
        return null == v ? 0 : v;
    }

    public static int getNumberDefaultZero(Integer v){
        return getNumberDefaultValue(v,0);
    }

    public static int getNumberDefaultValue(Integer v, int defaultValue){
        return null == v ? defaultValue : v;
    }
}
