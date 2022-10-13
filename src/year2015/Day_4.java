package year2015;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;

public class Day_4 {
    private static final String inputTextLocation = "resources/2015/day4.txt";

    public static void main(String[] args) throws Exception {
        findHash(5); // first star
        findHash(6); // second star
    }

    public static String readFileAsString() throws Exception {
        String basePath = new File(inputTextLocation).getAbsolutePath();
        return new String(Files.readAllBytes(Path.of(basePath)));
    }

    private static void findHash(int numberOfLeadingZeroes) throws Exception {
        String secretKey = readFileAsString();

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest;

        int i = 0;
        while (true) {
            digest = md.digest(secretKey.concat(Integer.toString(i++)).getBytes());
            if (digest[0] == 0 && digest[1] == 0 && (digest[2] & 0xf0) == 0) { // 5th zero takes up half the 3rd digit
                if (digest[2] == 0 || numberOfLeadingZeroes == 5) // 2nd star: check full 3rd digit
                    break;
            }
        }

        System.out.println("Hash with " + numberOfLeadingZeroes + " leading zeroes found: " + (i-1));
    }
}
