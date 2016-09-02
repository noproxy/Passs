package com.unique.yyz.passs.app;

import com.unique.yyz.passs.app.core.EncryptionException;
import com.unique.yyz.passs.app.core.FlowerPassword;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Carlos on 12/7/15.
 */
@RunWith(JUnit4.class)
public class FlowerPasswordTest {

    @Test
    public void testMd5() throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String value = FlowerPassword.hmacMd5("5tw;s0;JTJFKZ4LK", "qq434211");
        assert value == "696e2cf1c9046317b60526db76ee4113";
    }

    @Test
    public void testEncrypt() throws EncryptionException {
        String value = FlowerPassword.encrypt("5tw;s0;JTJFKZ4LK", "qq434211");
        Assert.assertEquals(value, "C2DeCeAc0C3393e2");
    }
}
