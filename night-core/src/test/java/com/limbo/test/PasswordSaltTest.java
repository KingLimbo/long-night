package com.limbo.test;

import com.limbo.practice.core.constant.CoreConsts;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

/**
 * long-night
 *
 * @author : limbo
 * @date : 2020/5/18
 */
public class PasswordSaltTest {
    private static final String loginAccount = "admin";
    private static final String loginSalt = "admin";

    String password = "admin";//明码
    String algorithmName = "MD5";//加密算法
    Object source = password;//要加密的密码

    Object salt = "admin";//盐值，一般都是用户名或者userid，要保证唯一

    @Test
    public void getPassword(){
        ByteSource passwordByte = ByteSource.Util.bytes(loginAccount + CoreConsts.SALT_CONNECT + loginSalt);

        SimpleHash simpleHash = new SimpleHash(algorithmName,source,
                loginAccount + CoreConsts.SALT_CONNECT + loginSalt,3);
        System.out.println(passwordByte.toString());
        System.out.println(simpleHash.toString());
    }
}
