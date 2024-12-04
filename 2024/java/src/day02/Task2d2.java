package day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Task2d2 {

    private static Stream<int[]> allWindows(int[] array, int size) {
        return IntStream.range(0, array.length - size + 1)
                .mapToObj(i -> Arrays.copyOfRange(array, i, i + size));
    }

    private static boolean isSafe(int[] levels) {
        BiPredicate<Integer, Integer> isValid = (a, b) -> a - b >= 1 && a - b <= 3;

        return allWindows(levels, 2).allMatch(window -> isValid.test(window[0], window[1]))
                || allWindows(levels, 2).allMatch(window -> isValid.test(window[1], window[0]));
    }

    private static boolean safeAndFixed(int[] levels) {
        for (int i = 0; i < levels.length; i++) {
            int[] reducedLevels = IntStream.concat(
                    Arrays.stream(levels, 0, i),
                    Arrays.stream(levels, i + 1, levels.length))
                    .toArray();
            if (isSafe(reducedLevels)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> reports = br.lines()
                .map(line -> Arrays.stream(line.split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toList();

        System.out.println(reports.stream().filter(Task2d2::safeAndFixed).count());
    }

}
