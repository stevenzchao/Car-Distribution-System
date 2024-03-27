package com.stevezchao.carDistributionSystem.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import static com.stevezchao.carDistributionSystem.utils.MacUtil.bytesToHex;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MDUtilTests {

    //秘钥（必须要是通信双方共享的）
    static final String STR_KEY = "266f5fe18e714688a083df4ca9f78064";

    @Test
    void md5Test() throws NoSuchAlgorithmException, InvalidKeyException {

        String string = "thumbs";
        String enString = MDUtil.md5Encryption(string);
        String enStringWithSalt = MDUtil.md5EncryptionWithSalt(string,"ikgobG7O");
        System.err.println(string);
        System.err.println(enString);
        System.err.println(enStringWithSalt);

    }

}
