package year2015;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.stream.Stream;


public class Day_1 {
    private static final String inputTextLocation = "resources/2015/day1.txt";

    public static void main(String[] args) throws Exception {
        firstStar();
        secondStar();
    }

    public static String readFileAsString(String fileName) throws Exception {
        String basePath = new File(inputTextLocation).getAbsolutePath();
        return new String(Files.readAllBytes(Path.of(basePath)));
    }

    private static void firstStar() throws Exception {
        String input = readFileAsString(inputTextLocation);
        char[] chars = input.toCharArray();
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        for (char aChar : chars) {
            if (aChar == '(') {
                // go up
                stringIntegerHashMap.put("FLOOR", stringIntegerHashMap.getOrDefault("FLOOR", 0) + 1);
            } else {
                // go down
                stringIntegerHashMap.put("FLOOR", stringIntegerHashMap.getOrDefault("FLOOR", 0) - 1);
            }
        }
        System.out.println("Floor: " + stringIntegerHashMap.get("FLOOR"));
    }

    private static void secondStar() throws Exception {
        String input = readFileAsString(inputTextLocation);
        char[] chars = input.toCharArray();
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stringIntegerHashMap.put("FLOOR", stringIntegerHashMap.getOrDefault("FLOOR", 0) + 1);
            } else {
                stringIntegerHashMap.put("FLOOR", stringIntegerHashMap.getOrDefault("FLOOR", 0) - 1);
                if (stringIntegerHashMap.get("FLOOR") < 0) {
                    System.out.println("Entered basement at position: " + (i + 1));
                    break;
                }
            }
        }
    }
}
