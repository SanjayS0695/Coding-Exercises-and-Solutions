public class NthFibonacci {

    public static void main(String[] args) {
        System.out.println(getNthFibonacci(10));
    }

    private static int getNthFibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] series = new int[n+1];
        series[0] = 1;
        series[1] = 1;

        for (int i = 2; i <= n; i++) {
            series[i] = series[i-2] + series[i-1];
        }
        return series[n-1];
    }
}
