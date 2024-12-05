package day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Task1d5 {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> rules = new HashMap<>();
        List<List<Integer>> rows = new ArrayList<>();
        AtomicBoolean isRules = new AtomicBoolean(true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.lines().forEach(line -> {

            if (line.isEmpty()) {
                isRules.set(false);

                return;
            }

            if (isRules.get()) {
                String[] parts = line.split("\\|");
                rules.putIfAbsent(Integer.parseInt(parts[0]), new ArrayList<>());
                rules.get(Integer.parseInt(parts[0])).add(Integer.parseInt(parts[1]));
                return;
            }
            rows.add(Arrays.stream(line.split(",")).map(el -> Integer.parseInt(el)).toList());
        });

        int sum = rows.stream().mapToInt(row -> {
            boolean againstRules = row.stream().anyMatch(element -> {
                System.out.println(element);
                List<Integer> after = rules.get(element);

                if (after == null) {
                    return false;
                }

                int index = row.indexOf(element);

                for (int i = 0; i < index; i++) {
                    if (after.contains(row.get(i))) {
                        return true;
                    }
                }
                return false;
            });

            if (againstRules) {
                return 0;
            }

            return row.get(row.size() / 2);
        }).sum();

        System.out.println(sum);
    }
}
