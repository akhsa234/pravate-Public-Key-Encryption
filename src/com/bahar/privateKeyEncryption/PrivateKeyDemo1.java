package com.bahar.privateKeyEncryption;//Example 9.1 Private Key Encryption
//Modified from
//http://jexp.ru/index.php/Java_Tutorial/Security/Key_Generator
import java.nio.charset.StandardCharsets;
import java.security.*;
import javax.crypto.*;


public class PrivateKeyDemo1 {

    static String algorithm="AES";
    static Key key;
    static Cipher cipher;

    public static void main(String[] args) throws Exception {
        key = KeyGenerator.getInstance(algorithm).generateKey();
        cipher = Cipher.getInstance(algorithm);
        String text = "hello world";
        byte[] encryptionBytes = encrypt(text);

        System.out.println("Original Text: " + text);
        System.out.println( "key" + key.toString()  );
        System.out.println( " Encrypted Text: " + encrypt(text) );
        System.out.println( " Decrypted Text: " + decrypt(encryptionBytes) );

    }
    private static byte[] encrypt(String input) throws Exception{
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
        return cipher.doFinal(inputBytes);

    }

    private static String decrypt(byte[] encryptionBytes) throws Exception {

        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] recoveredBytes = cipher.doFinal(encryptionBytes);
        String recovered = new String(recoveredBytes);
        return recovered;

    }

}
