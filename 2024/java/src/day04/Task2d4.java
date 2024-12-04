package day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task2d4 {

    private static boolean isXmas(String[][] matrix, int r, int c) {
        String topLeft = matrix[r][c];
        String center = matrix[r + 1][c + 1];
        String bottomRight = matrix[r + 2][c + 2];

        String topRight = matrix[r][c + 2];
        String bottomLeft = matrix[r + 2][c];

        boolean diagonal1 = (topLeft.equals("M") && center.equals("A") && bottomRight.equals("S")) ||
                (topLeft.equals("S") && center.equals("A") && bottomRight.equals("M"));

        boolean diagonal2 = (bottomLeft.equals("M") && center.equals("A") && topRight.equals("S")) ||
                (bottomLeft.equals("S") && center.equals("A") && topRight.equals("M"));

        return diagonal1 && diagonal2;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] matrix = br.lines().filter(line -> !line.isEmpty()).map(line -> line.split(""))
                .toArray(String[][]::new);

        int count = 0;
        for (int r = 0; r <= matrix.length - 3; r++) {
            for (int c = 0; c <= matrix[r].length - 3; c++) {
                if (isXmas(matrix, r, c)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
