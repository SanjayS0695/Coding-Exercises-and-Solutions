import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Payoda {

    public static void main(String[] args) {
        var inputList = List.of(5,4,7,9,5,7,4,5);

        var countMap = inputList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        inputList.stream().forEach(integer -> {
            if (integer % 2 == 0) {
                System.out.println("Even: " + integer);
            } else {
                System.out.println("Odd: " + integer);
            }
        });
    }
}
