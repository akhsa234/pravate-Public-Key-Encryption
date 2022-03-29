package com.bahar.MessageDigest;

//Example 9.4 Java Message Digest 2
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestDemo2 {
    public static void main(String[] args) throws Exception {
        String stringToEncrypt="hello world";
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = messageDigest.digest(stringToEncrypt.getBytes(StandardCharsets.UTF_8));

        String encryptedString = bytesToHex(encodedHash);

        System.out.println("Original Text: " + stringToEncrypt);
        System.out.println("Message Digest: " + encryptedString);

         }


         public static  String bytesToHex(byte[] hash){
        StringBuffer hexString = new StringBuffer();
             for (int i = 0; i < hash.length; i++) {
                 String hex = Integer.toHexString(0xff & hash[i]);
                 if(hex.length() == 1) hexString.append('0');
                 hexString.append(hex);
             }
             return hexString.toString();
         }
}
