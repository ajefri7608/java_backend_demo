package com.example.java_backend_demo.encryption;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.*;
import java.util.Random;

public class RsaEncryption {
    private static String rsaPublicKeyPath = "./RSAPublicKey";
    private static String rsaPrivateKeyPath = "./RSAPrivateKey";

    private static String algorithm = "RSA";

    public static PrivateKey getPrivateKeyFromFile(String privateKeyPath) throws Exception {
        byte[] key = Files.readAllBytes(new File(privateKeyPath).toPath());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(key);

        return (RSAPrivateKey) keyFactory.generatePrivate(spec);
    }

    public static PublicKey getPublicKeyFromFile(String publicKeyPath) throws Exception {
        byte[] key = Files.readAllBytes(new File(publicKeyPath).toPath());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec spec = new X509EncodedKeySpec(key);

        return (RSAPublicKey) keyFactory.generatePublic(spec);
    }

    public static String encrypt(String content) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        try{
            cipher.init(Cipher.ENCRYPT_MODE, getPublicKeyFromFile(rsaPublicKeyPath));
        }catch (Exception e){
            System.out.println("Can't get privateKey from file");
        }
        byte[] secretMessageBytes = content.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = cipher.doFinal(secretMessageBytes);
        System.out.println("Encrypted content: " + Base64.encodeBase64String(encryptedMessageBytes));
        return Base64.encodeBase64String(encryptedMessageBytes);
    }

    public static String decrypt(String encryptedContent) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(algorithm);
        try{
            cipher.init(Cipher.DECRYPT_MODE, getPrivateKeyFromFile(rsaPrivateKeyPath));
        }catch (Exception e){
            System.out.println("Can't get privateKey from file");
        }
        byte[] plainText = cipher.doFinal(Base64.decodeBase64(encryptedContent));
        return new String(plainText);
    }

    public static byte[] signSignature(String content) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(getPrivateKeyFromFile(rsaPrivateKeyPath));
        byte[] contentToBytes = content.getBytes(StandardCharsets.UTF_8);
        signature.update(contentToBytes);
        return signature.sign();
    }



    public static boolean verifySignature(String content, byte[] receivedSignature) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(getPublicKeyFromFile(rsaPublicKeyPath));
        signature.update(content.getBytes(StandardCharsets.UTF_8));
        return signature.verify(receivedSignature);
    }


    public static void main(String [] args ) throws Exception {
        RsaEncryption rsaEncryption = new RsaEncryption();
        System.out.println(rsaEncryption.getPrivateKeyFromFile(rsaPrivateKeyPath).toString());
        System.out.println(rsaEncryption.getPublicKeyFromFile(rsaPublicKeyPath).toString());
        System.out.println("verifySignature: " + verifySignature("ASDQWE",signSignature("ASDQWE")));


    }
}
