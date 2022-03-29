package com.bahar.publicKeyEncryption;

//Example 9.2 Java Public Key Encryption
//Modified from:
//http://www.javacirecep.com/java-security/java-rsa-encryption-decryption-example/
import java.nio.charset.StandardCharsets;
import java.security.*;
import javax.crypto.*;
import java.util.*;

public class PublicKeyDemo1 {

    private static KeyPair keyPair;
    private static String algorithm = " RSA";

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        keyPairGenerator.initialize(1024);
        keyPair= keyPairGenerator.generateKeyPair();

        final Cipher cipher=Cipher.getInstance(algorithm);
        final String plaintext = "hello world";

        System.out.println("Public Key = " + keyPair.getPublic().
                toString());
        System.out.println("Private Key = " + keyPair.getPrivate().
                toString());

        // ENCRYPT using the PUBLIC key
        cipher.init(Cipher.ENCRYPT_MODE,keyPair.getPublic());
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        String cipherText = new String(Base64.getEncoder().encode(encryptedBytes));

        System.out.println("encrypted (ciphertext) = " + cipherText);

        // DECRYPT using the PRIVATE key
        cipher.init(Cipher.ENCRYPT_MODE,keyPair.getPrivate());
        byte[] cipherTextBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        byte[] decryptedBytes =cipher.doFinal(cipherTextBytes);

        String decryptedString = new String(decryptedBytes);
        System.out.println("decrypted (plaintext) = " +
                decryptedString);

    }





}
