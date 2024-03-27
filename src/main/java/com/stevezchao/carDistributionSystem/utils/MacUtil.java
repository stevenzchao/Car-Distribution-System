package com.stevezchao.carDistributionSystem.utils;

import javax.crypto.Mac;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class MacUtil {

    public static byte[] mac(String algo, Key key, String data) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(algo);
        //这里是关键，需要一个key（这里就是和普通的消息摘要的区别点）
        mac.init(key);
        byte[] result = mac.doFinal(data.getBytes());

        return result;
    }

    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte h : hash) {
            String hex = Integer.toHexString(0xff & h);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

}