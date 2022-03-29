package com.bahar.MessageDigest;

//Example 9.3 Java Message Digest
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MessageDigestDemo1 {

    public static void main(String[] args) throws Exception {
        String stringToEncrypt = "hello world";
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(stringToEncrypt.getBytes(StandardCharsets.UTF_8));

        String encryptedString = new String(messageDigest.digest());

        System.out.println("Original Text: " + stringToEncrypt);
        System.out.println("Message Digest: " + encryptedString);
    }
}
