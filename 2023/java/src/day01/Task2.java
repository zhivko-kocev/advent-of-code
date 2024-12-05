package day01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Map<String, String> nums = new HashMap<>(
                Map.of("one", "o1e", "two", "t2o", "three", "t3e", "four", "f4r", "five", "f5e",
                        "six", "s6x", "seven", "s7n", "eight", "e8t", "nine", "n9e"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = br.lines()
                .filter(line -> !line.isEmpty())
                .mapToInt(line -> {
                    for (Map.Entry<String, String> entry : nums.entrySet()) {
                        line = line.replaceAll(entry.getKey(), entry.getValue());
                    }
                    line = line.replaceAll("[A-Za-z]", "");
                    return Integer.parseInt(line.charAt(0) + "" + line.charAt(line.length() - 1));
                })
                .sum();

        System.out.println(sum);

    }
}
