public class SumOfTwoLargeNumbers {

    public static void main(String[] args) {
        String a = "99,999";
        String b = "9,999";
        sumTheNumbers(a, b);

        String a1 = "1234";
        String b1 = "2345";
        sumTheNumbers(a1, b1);

        String a2 = "12345";
        String b2 = "12345";
        sumTheNumbers(a2, b2);

        String a3 = "54321";
        String b3 = "54321";
        sumTheNumbers(a3, b3);

        String a4 = "99999";
        String b4 = "99999";
        sumTheNumbers(a4, b4);

        String a5 = "5";
        String b5 = "1234";
        sumTheNumbers(a5, b5);

        String a6 = "5";
        String b6 = "12345";
        sumTheNumbers(a6, b6);

        String a7 = "1";
        String b7 = "99999";
        sumTheNumbers(a7, b7);

        String a8 = "001";
        String b8 = "00002";
        sumTheNumbers(a8, b8);

        String a9 = "000";
        String b9 = "00000";
        sumTheNumbers(a9, b9);
    }

    private static String sumTheNumbers(String a, String b) {

        int aLength = a.length();
        int bLength = b.length();
        int maxLength = Math.max(aLength, bLength);
        String firstNumber = getPaddedString(a, maxLength);
        String secondNumber = getPaddedString(b, maxLength);

        char[] inputA = firstNumber.toCharArray();
        char[] inputB = secondNumber.toCharArray();

        if (inputA.length == inputB.length) {
            StringBuilder result = new StringBuilder();
            int carry = 0;
            for (int i = inputA.length-1; i >= 0; i--) {
                int val1 = Character.getNumericValue(inputA[i]);
                int val2 = Character.getNumericValue(inputB[i]);
                int total = carry + val1 + val2;
                if (i > 0) {
                    int sum = total % 10;
                    carry = total / 10;
                    result.insert(0, sum);
                } else {
                    result.insert(0, total);
                }
            }

            System.out.printf("Sum of %s + %s = %s%n", a, b, result.toString().replaceFirst("^0+(?!$)", ""));
        }
        return "";
    }

    private static String getPaddedString(String s, int max) {
        int length = s.length();
        String withoutCommas = s.replaceAll(",", "");
        if (max != length) {
            return "0".repeat(Math.max(0, max - length)) + withoutCommas;
        } else {
            return withoutCommas;
        }
    }
}
