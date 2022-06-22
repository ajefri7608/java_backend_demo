package com.example.java_backend_demo.encryption;

import org.apache.tomcat.util.codec.binary.Base64;
import org.assertj.core.internal.Bytes;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.*;

public class RsaEncryption {
    public static PrivateKey getPrivateKeyFromFile() throws Exception {
        byte[] key = Files.readAllBytes(new File("./RSAPrivateKey").toPath());

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(key);

        return (RSAPrivateKey) keyFactory.generatePrivate(spec);
    }
    public static PublicKey getPublicKeyFromFile() throws Exception {

        byte[] key = Files.readAllBytes(new File("./RSAPublicKey").toPath());

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec spec = new X509EncodedKeySpec(key);

        return (RSAPublicKey) keyFactory.generatePublic(spec);
    }
    public static String encrypt(String content) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        try{
            cipher.init(Cipher.ENCRYPT_MODE, getPublicKeyFromFile());
        }catch (Exception e){
            System.out.println("Can't get privateKey from file");
        }
        byte[] secretMessageBytes = content.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = cipher.doFinal(secretMessageBytes);
        System.out.println("Encrypted content: " + Base64.encodeBase64String(encryptedMessageBytes));
        return Base64.encodeBase64String(encryptedMessageBytes);
    }
    public static byte[] signSignature(String content) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(getPrivateKeyFromFile());
        byte[] contentToBytes = content.getBytes(StandardCharsets.UTF_8);
        signature.update(contentToBytes);


        return signature.sign();
    }
    public static boolean verifySignature(String content, byte[] receivedSignature) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(getPublicKeyFromFile());
        signature.update(content.getBytes(StandardCharsets.UTF_8));
        return signature.verify(receivedSignature);
    }

    public static AlgorithmParameterSpec genIv() throws NoSuchAlgorithmException, NoSuchPaddingException {
        SecureRandom randomSecureRandom = SecureRandom.getInstanceStrong();
        //byte[] iv = new byte[16];
        byte[] iv = new byte[16];
        randomSecureRandom.nextBytes(iv);
        return new IvParameterSpec(iv);
    }
    public static String decrypt(String encryptedContent) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA");
        try{
            cipher.init(Cipher.DECRYPT_MODE, getPrivateKeyFromFile());
        }catch (Exception e){
            System.out.println("Can't get privateKey from file");
        }
        byte[] plainText = cipher.doFinal(Base64.decodeBase64(encryptedContent));
        return new String(plainText);
    }
    public static void main(String [] args ) throws Exception {
        RsaEncryption rsaEncryption = new RsaEncryption();
        System.out.println(rsaEncryption.getPrivateKeyFromFile().toString());
        System.out.println(rsaEncryption.getPublicKeyFromFile().toString());
        System.out.println(decrypt(encrypt("ASDQWE")));
        System.out.println("test1231   " + verifySignature("ASDQWE",signSignature("ASDQWE")));


    }
}
