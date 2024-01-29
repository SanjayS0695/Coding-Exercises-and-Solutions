import java.util.Arrays;
import java.util.stream.Collectors;

public class CognizantCoding {

    public static void main(String[] args) {

        Integer[] intArray = new Integer[]{3, 5, 10, 30};
        var avg = Arrays.asList(intArray).stream().map(ints -> ints*ints)
                .filter(integer -> integer > 100)
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(avg);
    }
}
