import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Coding {

    public static void main(String[] args) {
        String input = "WEDNESDAY";

        char[] arr = input.toCharArray();

        var countMap = input.chars().mapToObj(value -> (char) value).collect(Collectors
                .groupingBy(Function.identity(), Collectors.counting()));

        countMap.forEach((character, aLong) -> System.out.println(character+" "+aLong));
    }
}
