package com.stevezchao.carDistributionSystem.utils;

import jakarta.xml.bind.annotation.adapters.HexBinaryAdapter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDUtil {

    public static String md5Encryption(String originalString) {
        // 创建MD5摘要对象
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        messageDigest.update(originalString.getBytes(StandardCharsets.UTF_8));
        // 计算哈希值
        byte[] result = messageDigest.digest();
        // 将哈希值转换为十六进制字符串
        return new HexBinaryAdapter().marshal(result);
    }

    public static String md5EncryptionWithSalt(String originalString, String salt) {
        // 创建MD5摘要对象
        MessageDigest messageDigest = null;
        originalString += salt;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        messageDigest.update(originalString.getBytes(StandardCharsets.UTF_8));
        // 计算哈希值
        byte[] result = messageDigest.digest();
        // 将哈希值转换为十六进制字符串
        return new HexBinaryAdapter().marshal(result);
    }



}
