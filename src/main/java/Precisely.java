import java.util.Arrays;

public class Precisely {

    public static void main(String[] args) {
        int[] input = new int[]{2, 7, 11, 15};
        Arrays.sort(input);

        System.out.println(twoSumWithRecursion(input, 2, 0, input.length-1));
    }

    private static void twoSum(int[] input, int a, int b, int target) {
        Arrays.sort(input);
        boolean sumFound = false;
        for (int i = 0; i <input.length; i++) {
            for (int j=i; j< input.length; j++) {
                int sum = input[i] + input[j];
                if (sum == target) {
                    sumFound = true;
                    System.out.println("Two numbers: " + input[i] + " ," + input[j]);
                }
            }
        }
        if (!sumFound) {
            System.out.println("Target not found");
        }
    }

    private static String twoSumWithRecursion(int[] input, int target, int i, int j) {
        if (i == input.length-1 || j == 0) {
            return "Target not found";
        }
        if (input[i] + input[j] == target) {
            return String.format("Two numbers: %s %s", input[i], input[j]);
        }
        if (input[i] + input[j] < target) {
            return twoSumWithRecursion(input, target, i+1, j);
        }
        return twoSumWithRecursion(input, target, i, j-1);
    }

}
