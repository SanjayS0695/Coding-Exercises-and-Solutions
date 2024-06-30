import java.util.Arrays;

public class MinimumSubSequence {

    public static void main(String[] args) {
        int[] arr = new int[] {3, 4, 5, 1, 2, 3, 1};
        System.out.println(sum(arr, 0, 0));
    }

    private static long sum(int[]arr, int start, long min) {

        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        for (int i = 3; i < arr.length; i++) {
            int current = arr[i] + Math.min(Math.min(a, b), c);
            a = b;
            b = c;
            c = current;
        }
        return Math.min(Math.min(a, b), c);
    }
}
