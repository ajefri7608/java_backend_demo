package com.example.java_backend_demo.encryption;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AesEncryption {
    private static String paddingAlgorithm = "AES/CBC/PKCS5Padding";
    private static String encryptAlgorithm = "AES";
    private static String aesBase64EncodedKey = "9nMcp5Xk2GMDY3oZX76SgQ==";
    private static int randomIvLength = 16;

    public static String encrypt(String algorithm, String msg, String iv, String key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance(algorithm);
        byte[] decodedKey = Base64.getDecoder().decode(key);
        SecretKey aesKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, encryptAlgorithm );
        IvParameterSpec initialVector = new IvParameterSpec(java.util.Base64.getDecoder().decode(iv));

        cipher.init(Cipher.ENCRYPT_MODE, aesKey, initialVector);
        byte[] cipherText = cipher.doFinal(msg.getBytes());

        return Base64.getEncoder()
                .encodeToString(cipherText);
    }

    public static String decrypt(String algorithm, String cipherText, String key, String iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {

        Cipher cipher = Cipher.getInstance(algorithm);
        IvParameterSpec initialVector = new IvParameterSpec(java.util.Base64.getDecoder().decode(iv));
        byte[] decodedKey = Base64.getDecoder().decode(key);
        SecretKey aesKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, encryptAlgorithm );
        cipher.init(Cipher.DECRYPT_MODE, aesKey, initialVector);
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
                .decode(cipherText.getBytes()));
        return new String(plainText, "GB2312");
    }

    public static SecretKey genKey(int length) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(encryptAlgorithm);
        keyGenerator.init(length);
        SecretKey key = keyGenerator.generateKey();
        return key;
    }

    public static String genRandomIv(){
        SecureRandom randomSecureRandom = new SecureRandom();
        byte[] iv = new byte[randomIvLength];
        randomSecureRandom.nextBytes(iv);

        return java.util.Base64.getEncoder()
                .encodeToString(iv);
    }
    public static void main( String [] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        String iv = genRandomIv();
        String aesEncryptedText = encrypt(paddingAlgorithm, "plain text", iv, aesBase64EncodedKey);
        String aesDecryptedText= decrypt(paddingAlgorithm, aesEncryptedText, aesBase64EncodedKey, iv );

        System.out.println("aes key to String: " + java.util.Base64.getEncoder()
                .encodeToString(genKey(256).getEncoded()));
        System.out.println(aesEncryptedText);
        System.out.println(aesDecryptedText);

    }
}
