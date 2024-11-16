package com.musk.web.utils;

import java.util.Base64;

public class StringXORer {

    private static final String KEY = "42b0d705374741ddbaf47cf544d7df23";

    // 对字符串进行异或编码
    public static String encode(String s) {
        return Base64.getEncoder().encodeToString(xorWithKey(s.getBytes(), KEY.getBytes()));
    }

    // 对字符串进行异或解码
    public static String decode(String s) {
        return new String(xorWithKey(Base64.getDecoder().decode(s), KEY.getBytes()));
    }

    // 使用密钥对字节数组进行异或操作
    private static byte[] xorWithKey(byte[] a, byte[] key) {
        byte[] out = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            out[i] = (byte) (a[i] ^ key[i % key.length]);
        }
        return out;
    }

}
