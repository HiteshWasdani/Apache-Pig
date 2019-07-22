package com;
import org.apache.commons.codec.binary.Base64;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;

public class Test extends EvalFunc<String>
{

    public String exec(Tuple input) throws IOException
    {
        try {
            if (input == null) return null;

            String plain_text = (String) input.get(0);
            int choice = Integer.parseInt((String)input.get(1));

            String str = "";

            if(choice == 1)  str = encrupt(plain_text);
            if(choice == 0)  str = decrupt(plain_text);
            return str;
        }
        catch (Exception e)  {return  null;}
    }


    public String encrupt(String plain_text) throws Exception
    {
        SecretKey key = new SecretKeySpec("abcdefgh12345678".getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,key);

        byte[] encrypted = cipher.doFinal(plain_text.getBytes("UTF-8"));
        return Base64.encodeBase64String(encrypted);

    }


    public String decrupt(String plain_text) throws Exception
    {
        SecretKey key = new SecretKeySpec("abcdefgh12345678".getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE,key);

        byte[] original = cipher.doFinal(Base64.decodeBase64(plain_text));

        return new String(original);
    }
}
