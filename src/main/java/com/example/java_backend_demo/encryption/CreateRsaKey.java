package com.example.java_backend_demo.encryption;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

public class CreateRsaKey {
    private KeyPairGenerator generator;
    private PublicKey rsaPublicKey;
    private PrivateKey rsaPrivateKey;
    private static String rsaPublicKeyPath = "./RSAPublicKey";
    private static String rsaPrivateKeyPath = "./RSAPrivateKey";
    public CreateRsaKey() throws NoSuchAlgorithmException {
        generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();
        rsaPublicKey = pair.getPublic();
        rsaPrivateKey = pair.getPrivate();
    }
    public void writeKeyToFile(String publicKeyPath, String privateKeyPath){
        try {
            if(rsaPublicKey != null && rsaPrivateKey != null){
                FileOutputStream fileOutputStream = new FileOutputStream(publicKeyPath);
                fileOutputStream.write(rsaPublicKey.getEncoded());
                fileOutputStream.flush();
                fileOutputStream.close();
                fileOutputStream = new FileOutputStream(privateKeyPath);
                fileOutputStream.write(rsaPrivateKey.getEncoded());
                fileOutputStream.flush();
                fileOutputStream.close();
                System.out.println("Successfully wrote to the file.");
                System.out.println(rsaPublicKey.toString());
                System.out.println(rsaPrivateKey.toString());
            }else{
                System.out.println("Rsa private Key or rsa public key not exist.");
            }
        } catch (IOException e) {
            System.out.println("Can't wrote to the file.");
            e.printStackTrace();
        }

    }

    public PublicKey getRsaPublicKey() {
        return rsaPublicKey;
    }
    public PrivateKey getRsaPrivateKey() {
        return rsaPrivateKey;
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        CreateRsaKey rsaEncrypt = new CreateRsaKey();
        rsaEncrypt.writeKeyToFile(rsaPublicKeyPath, rsaPrivateKeyPath);

    }

}
