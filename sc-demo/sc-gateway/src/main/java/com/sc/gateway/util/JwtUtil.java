package com.sc.gateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class JwtUtil {
    /**
     * 验证jwt
     */
    public static Claims verifyJwt(String token,String secretKey) {
        //签名秘钥，和生成的签名的秘钥一模一样
        SecretKey key = generalKey(secretKey);
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }//设置需要解析的jwt
        return claims;

    }


    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public static SecretKey generalKey(String secretKey) {
        byte[] encodedKey = Base64.decodeBase64(secretKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
}
