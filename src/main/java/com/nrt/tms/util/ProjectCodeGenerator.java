package com.nrt.tms.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

public class ProjectCodeGenerator {

    public static String generateProjectCode(String projectName) {
        String clientPrefix = "NRT";


        String input = projectName + "-" + System.currentTimeMillis();
        String hashFragment = generateShortHash(input);

        return clientPrefix + "-" + hashFragment;
    }

    private static String generateShortHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                String hex = Integer.toHexString(0xff & encodedHash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString().toUpperCase(); // Always uppercase
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }
}
