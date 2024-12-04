import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1d3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");

        long sum = br.lines()
                .mapToInt(line -> {
                    Matcher matcher = pattern.matcher(line);
                    int productSum = 0;

                    while (matcher.find()) {
                        int num1 = Integer.parseInt(matcher.group(1));
                        int num2 = Integer.parseInt(matcher.group(2));
                        productSum += num1 * num2;
                    }

                    return productSum;
                })
                .sum();

        System.out.println(sum);
    }
}
