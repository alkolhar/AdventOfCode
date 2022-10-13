package year2015;

import java.io.*;
import java.util.regex.Pattern;

public class Day_5 {
    private static final String inputTextLocation = "resources/2015/day5.txt";

    public static void main(String[] args) throws IOException {
        firstStar();
        secondStar();
    }

    private static void secondStar() throws IOException {
        int niceStringCounter = 0;
        Pattern twoLettersAtLeastTwice = Pattern.compile("(..).*\\1");
        Pattern repeatingWithOneLetterBetween = Pattern.compile("(.).\\1");

        // read line from file
        String absolutePath = new File(inputTextLocation).getAbsolutePath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (twoLettersAtLeastTwice.matcher(line).find() &&
                    repeatingWithOneLetterBetween.matcher(line).find()) {
                niceStringCounter++;
            }
        }
        System.out.println(niceStringCounter + " nice strings found!");
    }

    private static void firstStar() throws IOException {
        int niceStringCounter = 0;
        // define rules as patterns
        Pattern naughtyPattern = Pattern.compile("ab|cd|pq|xy");
        Pattern vowelPattern = Pattern.compile("(.*[aeiou]){3}");
        Pattern doubleLetterPattern = Pattern.compile("(.)\\1");

        // read line from file
        String absolutePath = new File(inputTextLocation).getAbsolutePath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!naughtyPattern.matcher(line).find() &&
                    vowelPattern.matcher(line).find() &&
                    doubleLetterPattern.matcher(line).find()) {
                niceStringCounter++;
            }
        }
        System.out.println(niceStringCounter + " nice strings found!");
    }


}
