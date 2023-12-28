import java.util.Arrays;

public class MergeSortedArrays {

    public static void  main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 6, 10, 11, 15};
        int[] b = new int[]{1, 3, 5, 8, 12, 14, 19};

        System.out.println(Arrays.toString(mergeArrays(a, b)));
    }

    public static int[] mergeArrays(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] result = new int[a.length + b.length];
        int k = 0;
        while (i != a.length && j != b.length) {
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else if (b[j] < a[i]) {
                result[k++] = b[j++];
            } else {
                result[k++] = a[i++];
                result[k++] = b[j++];
            }
        }

        while (i != a.length) {
            result[k++] = a[i++];
        }

        while (j != b.length) {
            result[k++] = b[j++];
        }

        return result;
    }
}
