import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task1d1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        br.lines().map(line -> line.split("\\s+")).forEach(pair -> {
            first.add(Integer.parseInt(pair[0]));
            second.add(Integer.parseInt(pair[1]));
        });

        first.sort(Comparator.naturalOrder());
        second.sort(Comparator.naturalOrder());

        int sum = 0;
        for (int i = 0; i < first.size(); i++) {
            sum += Math.abs(first.get(i) - second.get(i));
        }

        System.out.println(sum);
    }
}
