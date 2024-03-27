package com.stevezchao.carDistributionSystem.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import static com.stevezchao.carDistributionSystem.utils.MacUtil.bytesToHex;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class MacUtilTests {

    //秘钥（必须要是通信双方共享的）
    static final String STR_KEY = "266f5fe18e714688a083df4ca9f78064";

    @Test
    void macTest() throws NoSuchAlgorithmException, InvalidKeyException {

        System.err.println("testing");
        Key key = new SecretKeySpec(STR_KEY.getBytes(), "");

        String s1 = "123456789";
        String s2 = "123456789";
        String t1 = "123456789";
        String t2 = "12345678910";
        assertEquals(bytesToHex(MacUtil.mac("HmacMD5", key, s1)), bytesToHex(MacUtil.mac("HmacMD5", key, s2)));
        assertNotEquals(bytesToHex(MacUtil.mac("HmacMD5", key, t1)), bytesToHex(MacUtil.mac("HmacMD5", key, t2)));
    }

}
