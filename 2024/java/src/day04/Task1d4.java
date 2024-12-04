package day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task1d4 {

    private static final int[][] DIRECTIONS = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 },
            { 1, 1 },
            { 1, -1 },
            { -1, 1 },
            { -1, -1 }
    };

    public static int countOccurrences(String[][] matrix, int size, String word) {
        int wordLength = word.length();
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int[] direction : DIRECTIONS) {
                    if (searchWord(matrix, size, i, j, word, wordLength, direction)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static boolean searchWord(String[][] matrix, int size, int row, int col, String word, int wordLength,
            int[] direction) {
        int r = row, c = col;
        for (int k = 0; k < wordLength; k++) {
            if (r < 0 || r >= size || c < 0 || c >= size) {
                return false;
            }
            if (!matrix[r][c].equals(String.valueOf(word.charAt(k)))) {
                return false;
            }
            r += direction[0];
            c += direction[1];
        }

        return true;
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] matrix = br.lines().filter(line -> !line.isEmpty()).map(line -> line.split(""))
                .toArray(String[][]::new);

        String word = "XMAS";

        System.out.println(countOccurrences(matrix, matrix.length, word));

    }
}
