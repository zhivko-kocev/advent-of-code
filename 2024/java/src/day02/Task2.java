package day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Task2 {

    private static boolean isSafe(int[] levels) {
        BiPredicate<Integer, Integer> isValid = (a, b) -> a - b >= 1 && a - b <= 3;

        Stream<int[]> windows = IntStream.range(0, levels.length - 2 + 1)
                .mapToObj(i -> Arrays.copyOfRange(levels, i, i + 2));

        return windows.allMatch(window -> isValid.test(window[0], window[1]))
                || windows.allMatch(window -> isValid.test(window[1], window[0]));
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
                .collect(Collectors.toList());

        System.out.println(reports.stream().filter(Task2::safeAndFixed).count());
    }

}
