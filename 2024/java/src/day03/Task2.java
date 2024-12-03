import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don't\\(\\)");

        boolean calculate = true;
        long sum = 0;
        String line;
        while ((line = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                if (matcher.group(0).equals("do()")) {
                    calculate = true;
                    continue;
                }

                if (matcher.group(0).equals("don't()")) {
                    calculate = false;
                    continue;
                }

                if (calculate) {
                    int num1 = Integer.parseInt(matcher.group(1));
                    int num2 = Integer.parseInt(matcher.group(2));
                    sum += (long) num1 * num2;
                }
            }
        }

        System.out.println(sum); // Print the final sum
    }
}
