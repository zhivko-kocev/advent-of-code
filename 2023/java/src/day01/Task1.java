package day01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = br.lines().filter(line -> !line.isEmpty()).mapToInt(line -> {
            List<String> digits = Arrays.stream(line.split("")).filter(ch -> Character.isDigit(ch.charAt(0))).toList();

            return Integer.parseInt(digits.getFirst() + digits.getLast());
        }).sum();

        System.out.println(sum);

    }
}
