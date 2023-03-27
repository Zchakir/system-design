package org.zchakir.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {
    public static long getHash(String key) throws NoSuchAlgorithmException {
        // Use a hash function to map the key to a 64-bit integer
        // For example, use the MD5 hash algorithm
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(key.getBytes());
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
