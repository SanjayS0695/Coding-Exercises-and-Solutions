import java.util.function.Predicate;

public class TEKSystems {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 4, 6, 8, 9};

        int firstMax = findMax(input, 0);
        int secondMax = findMax(input, firstMax);
        System.out.println(String.format("Second max is %s.", secondMax));

        Predicate<String> pred = (String a) -> (a.length() > 0);
        pred.test("Hello");
    }

    public static int findMax(int[] arr, int highest) {
        int max = 0;
        for (int i =0; i < arr.length; i++) {
            if (arr[i] > max && highest != arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
