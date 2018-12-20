package com.training.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

@Component
public class PasswordSalt {

    @Autowired
    public PasswordSalt() {
    }

    public String createSalt(String passwordToHash) throws NoSuchProviderException, NoSuchAlgorithmException {
        byte[] salt = getSalt();

        String securePassword = getSecurePassword(passwordToHash, salt);
        return securePassword;
    }

    private String getSecurePassword(String passwordToHash, byte[] salt) {
        String generatedPassword = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt);

            byte[] bytes = md.digest(passwordToHash.getBytes());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            generatedPassword = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return generatedPassword;
    }

    private byte[] getSalt() throws NoSuchProviderException, NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
}
