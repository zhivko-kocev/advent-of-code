package day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task1 {

    private static Stream<int[]> allWindows(int[] array, int size) {
        return IntStream.range(0, array.length - size + 1)
                .mapToObj(i -> Arrays.copyOfRange(array, i, i + size));
    }

    private static boolean isSafe(int[] levels) {
        BiPredicate<Integer, Integer> isValid = (a, b) -> a - b >= 1 && a - b <= 3;

        return allWindows(levels, 2).allMatch(window -> isValid.test(window[0], window[1]))
                || allWindows(levels, 2).allMatch(window -> isValid.test(window[1], window[0]));
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> reps = br.lines()
                .map(line -> Arrays.stream(line.split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .collect(Collectors.toList());

        System.out.println(reps.stream().filter(rep -> isSafe(rep)).count());
    }
}
