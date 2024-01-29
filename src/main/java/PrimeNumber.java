public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(String.format("%s is a Prime number", isPrime(1)));
    }

    public static boolean isPrime(int input) {
        if (input == 1) {
            return false;
        }

        int count = 0;
        for (int i = 2; i < input; i++) {
            if (input % i == 1) {
                count++;
            }
        }

        return count == 1;
    }
}
