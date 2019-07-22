package com;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class my {
    public static void main(String[] arsg) throws Exception
    {
        String temp = "hitesh wasdani";

        String t1 = encrupt(temp);
        String t2 = decrupt(t1);

        System.out.println(t1);
        System.out.println(t2);
    }

    private static String encrupt(String temp) throws Exception
    {
        SecretKey key = new SecretKeySpec("abcdefgh12345678".getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,key);

        byte[] encrypted = cipher.doFinal(temp.getBytes());
        return Base64.encodeBase64String(encrypted);

    }


    private static String decrupt(String temp) throws Exception
    {
        SecretKey key = new SecretKeySpec("abcdefgh12345678".getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE,key);

        byte[] original = cipher.doFinal(Base64.decodeBase64(temp));

        return new String(original);
    }

}
