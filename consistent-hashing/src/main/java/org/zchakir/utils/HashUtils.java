package org.zchakir.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {
    public long getHash(String key) {
        // Use a hash function to map the key to a 64-bit integer
        // For example, use the MD5 hash algorithm
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            // Work on more general exception message
            System.out.println("Message Digest can't get the md5 algorithm");
        }
        byte[] digest = md.digest(key.getBytes());
        // To be refactored
        long h = ((long)digest[0] << 56) |
                ((long)(digest[1] & 255) << 48) |
                ((long)(digest[2] & 255) << 40) |
                ((long)(digest[3] & 255) << 32) |
                ((long)(digest[4] & 255) << 24) |
                ((digest[5] & 255) << 16) |
                ((digest[6] & 255) << 8) |
                ((digest[7] & 255));
        return h;
    }
}
