package com.unique.yyz.passs.app;

import com.unique.yyz.passs.app.core.FlowerPassword;

import junit.framework.TestCase;

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
        FlowerPassword.hmacMd5("5tw;s0;JTJFKZ4LK", "qq434211");
    }
}
