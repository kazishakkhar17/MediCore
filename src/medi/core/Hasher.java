package medi.core;

import java.security.MessageDigest;

public class Hasher {

    // Method to hash the password
    public static String hashPassword(String password) {
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Apply the algorithm to the password
            byte[] hashBytes = digest.digest(password.getBytes());

            // Convert bytes to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));  // Format each byte as a two-character hex string
            }

            return sb.toString();  // Return the hashed password
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
