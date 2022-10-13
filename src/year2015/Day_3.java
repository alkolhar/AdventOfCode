package year2015;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Day_3 {
    private static final String inputTextLocation = "resources/2015/day3.txt";

    public static void main(String[] args) throws Exception {
        firstStar();
        secondStar();
    }

    private static void secondStar() throws Exception {
        String input = readFileAsString(inputTextLocation);
        // input to char array
        char[] chars = input.toCharArray();
        // create a map of maps
        HashSet<LocationKey> locationSet = new HashSet<>();
        // set initial locations
        int roboX = 0;
        int roboY = 0;
        int santaX = 0;
        int santaY = 0;
        locationSet.add(new LocationKey(0, 0));
        boolean santasTurn = true;

        // TODO: this needs some refactoring (get rid of ifs)
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '^' -> {
                    if (santasTurn) {
                        santaY++;
                    } else {
                        roboY++;
                    }
                }
                case 'v' -> {
                    if (santasTurn) {
                        santaY--;
                    } else {
                        roboY--;
                    }
                }
                case '>' -> {
                    if (santasTurn) {
                        santaX++;
                    } else {
                        roboX++;
                    }
                }
                case '<' -> {
                    if (santasTurn) {
                        santaX--;
                    } else {
                        roboX--;
                    }
                }
            }
            int newX = santasTurn ? santaX : roboX;
            int newY = santasTurn ? santaY : roboY;
            santasTurn = !santasTurn;

            locationSet.add(new LocationKey(newX, newY));
        }
        System.out.println(locationSet.size());
    }

    public static String readFileAsString(String fileName) throws Exception {
        String basePath = new File(inputTextLocation).getAbsolutePath();
        return new String(Files.readAllBytes(Path.of(basePath)));
    }

    private static void firstStar() throws Exception {
        String input = readFileAsString(inputTextLocation);
        // input to char array
        char[] chars = input.toCharArray();
        // create a map of maps
        HashMap<LocationKey, Integer> locationMap = new HashMap<>();
        // set initial location
        int xPosition = 0;
        int yPosition = 0;
        locationMap.put(new LocationKey(xPosition, yPosition), 1);
        // loop over char array
        for (char charA : chars) {
            switch (charA) {
                case '^' -> yPosition++;
                case 'v' -> yPosition--;
                case '>' -> xPosition++;
                case '<' -> xPosition--;
            }
            // add 1 to visited location
            locationMap.put(
                    new LocationKey(xPosition, yPosition),
                    locationMap.getOrDefault(new LocationKey(xPosition, yPosition), 1));
        }
        System.out.println(locationMap.keySet().size());
    }

    // Wrapper Key Object
    public static class LocationKey {
        private final int x;
        private final int y;

        public LocationKey(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof LocationKey key)) return false;
            return x == key.x && y == key.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
