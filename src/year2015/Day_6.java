package year2015;

import java.io.*;


public class Day_6 {
    private static final String inputTextLocation = "resources/2015/day6.txt";
    private enum Mode {
        ON, OFF, TOGGLE
    }

    public static void main(String[] args) throws IOException {
        firstStar();
        secondStar();
    }

    private static void firstStar() throws IOException {
        int[][] lightsArray = new int[1000][1000];
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        // read line from file
        String absolutePath = new File(inputTextLocation).getAbsolutePath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath));
        String line;
        Mode mode;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(" ");
            if (line.startsWith("turn on")) {
                startX = Integer.parseInt(split[2].split(",")[0]);
                startY = Integer.parseInt(split[2].split(",")[1]);
                endX = Integer.parseInt(split[4].split(",")[0]);
                endY = Integer.parseInt(split[4].split(",")[1]);
                mode = Mode.ON;
            } else if (line.startsWith("turn off")) {
                startX = Integer.parseInt(split[2].split(",")[0]);
                startY = Integer.parseInt(split[2].split(",")[1]);
                endX = Integer.parseInt(split[4].split(",")[0]);
                endY = Integer.parseInt(split[4].split(",")[1]);
                mode = Mode.OFF;
            } else {
                // toggle
                startX = Integer.parseInt(split[1].split(",")[0]);
                startY = Integer.parseInt(split[1].split(",")[1]);
                endX = Integer.parseInt(split[3].split(",")[0]);
                endY = Integer.parseInt(split[3].split(",")[1]);
                mode = Mode.TOGGLE;
            }
            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    switch (mode) {
                        case ON -> lightsArray[i][j] = 1;
                        case OFF -> lightsArray[i][j] = 0;
                        case TOGGLE -> lightsArray[i][j] = lightsArray[i][j] == 1 ? 0 : 1;
                    }
                }
            }
        }
        int lightCount = 0;
        for (int[] ints : lightsArray) {
            for (int anInt : ints) {
                lightCount += anInt;
            }
        }
        System.out.println("Lights count: " + lightCount);
    }
    private static void secondStar() throws IOException {
        int[][] lightsArray = new int[1000][1000];
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        // read line from file
        String absolutePath = new File(inputTextLocation).getAbsolutePath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath));
        String line;
        Mode mode;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(" ");
            if (line.startsWith("turn on")) {
                startX = Integer.parseInt(split[2].split(",")[0]);
                startY = Integer.parseInt(split[2].split(",")[1]);
                endX = Integer.parseInt(split[4].split(",")[0]);
                endY = Integer.parseInt(split[4].split(",")[1]);
                mode = Mode.ON;
            } else if (line.startsWith("turn off")) {
                startX = Integer.parseInt(split[2].split(",")[0]);
                startY = Integer.parseInt(split[2].split(",")[1]);
                endX = Integer.parseInt(split[4].split(",")[0]);
                endY = Integer.parseInt(split[4].split(",")[1]);
                mode = Mode.OFF;
            } else {
                // toggle
                startX = Integer.parseInt(split[1].split(",")[0]);
                startY = Integer.parseInt(split[1].split(",")[1]);
                endX = Integer.parseInt(split[3].split(",")[0]);
                endY = Integer.parseInt(split[3].split(",")[1]);
                mode = Mode.TOGGLE;
            }
            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    switch (mode) {
                        case ON -> lightsArray[i][j] += 1;
                        case OFF -> lightsArray[i][j] = lightsArray[i][j] == 0 ? 0 : lightsArray[i][j] - 1;
                        case TOGGLE -> lightsArray[i][j] += 2;
                    }
                }
            }
        }
        int brightness = 0;
        for (int[] ints : lightsArray) {
            for (int anInt : ints) {
                brightness += anInt;
            }
        }
        System.out.println("Brightness of all lights: " + brightness);
    }
}
