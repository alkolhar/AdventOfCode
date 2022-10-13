package year2015;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Day_2 {
    private static final String inputTextLocation = "resources/2015/day2.txt";

    public static void main(String[] args) throws IOException {
        firstStar();
        secondStar();
    }

    private static void secondStar() throws IOException {
        int totalRibbon = 0;

        // read line from file
        String absolutePath = new File(inputTextLocation).getAbsolutePath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            // convert to int
            int[] numbers = Arrays.stream(line.split("x")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(numbers);
            // calculate ribbon length
            int ribbonLength = 0;
            ribbonLength += 2 * numbers[0] + 2 * numbers[1];
            // add tie length
            ribbonLength += numbers[0] * numbers[1] * numbers[2];
            // add to total
            totalRibbon += ribbonLength;
        }

        // print value
        System.out.println("Total ribbon needed: " + totalRibbon);
    }

    private static void firstStar() throws IOException {

        int totalWrappingPaper = 0;
        // l x w x h + smallest side

        // read line from file
        String absolutePath = new File(inputTextLocation).getAbsolutePath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            // convert to int
            int[] numbers = Arrays.stream(line.split("x")).mapToInt(Integer::parseInt).toArray();
            // calculate box size
            int boxSize = 0;
            boxSize += 2 * numbers[0] * numbers[1];
            boxSize += 2 * numbers[1] * numbers[2];
            boxSize += 2 * numbers[2] * numbers[0];
            // add slack
            Arrays.sort(numbers);
            boxSize += numbers[0] * numbers[1];
            // add to total
            totalWrappingPaper += boxSize;
        }

        // print value
        System.out.println("Total wrapping paper needed: " + totalWrappingPaper);
    }
}
