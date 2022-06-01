package com.example.java_backend_demo.encryption;

import org.apache.tomcat.util.codec.binary.Base64;
import org.assertj.core.internal.Bytes;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RsaEncryption {
    public PrivateKey getPrivateKeyFromFile() throws Exception {
        byte[] key = Files.readAllBytes(new File("./RSAPrivateKey").toPath());

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(key);

        return (RSAPrivateKey) keyFactory.generatePrivate(spec);
    }
    public PublicKey getPublicKeyFromFile() throws Exception {
        byte[] key = Files.readAllBytes(new File("./RSAPublicKey").toPath());

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec spec = new X509EncodedKeySpec(key);

        return (RSAPublicKey) keyFactory.generatePublic(spec);
    }
    public static void main(String [] args ) throws Exception {
        RsaEncryption rsaEncryption = new RsaEncryption();
        System.out.println(rsaEncryption.getPrivateKeyFromFile().toString());
        System.out.println(rsaEncryption.getPublicKeyFromFile().toString());
    }
}
