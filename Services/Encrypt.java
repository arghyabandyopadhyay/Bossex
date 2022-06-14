package BusinessGenie.app.Bossex.Services;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Java program to calculate SHA hash value

public class Encrypt {
    public static String getSHA(String input)
    {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return toHexString(md.digest(input.getBytes(StandardCharsets.UTF_8)));
    }

    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
}


