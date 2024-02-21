public class Yahoo {

    public static void main(String[] args) {
        printStar(19);
    }

    private static void printStar(int N) {
        int star1 = 0;
        int star2 = N-1;
        for (int i = 0; i < N; i++ ) {
            for (int j = 0; j < N; j++) {
                if (j == star1 || j == star2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            star1++;
            star2--;
            System.out.println("");
        }
    }
}
