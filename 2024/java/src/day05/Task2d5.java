package day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Task2d5 {
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
                List<Integer> cpy = new ArrayList<>(row);
                for (int i = 0; i < cpy.size(); i++) {
                    List<Integer> after = rules.get(cpy.get(i));
                    if (after == null) {
                        continue;
                    }

                    for (int j = 0; j < i; j++) {
                        if (after.contains(cpy.get(j))) {
                            cpy.add(i + 1, cpy.get(j));
                            cpy.remove(j);
                            i--;
                        }
                    }
                }
                System.out.println(cpy);
                return cpy.get(cpy.size() / 2);
            }

            return 0;
        }).sum();

        System.out.println(sum);

    }
}
