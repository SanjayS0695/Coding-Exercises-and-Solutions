public class Wayfair {

    public static void main(String[] args) {
        System.out.println("Sum of the numbers is: " + addTwoNumbersWithComma("317,811", "514,229"));
        System.out.println("Sum of the numbers is: " + addTwoNumbersWithComma("701,408,733", "433,494,437"));
        System.out.println("Sum of the numbers is: " + addTwoNumbersWithComma("8,944,394,323,791,464", "14,472,334,024,676,221"));
    }

    private static String addTwoNumbers(String input1, String input2) {
        if (input1.length() != input2.length()) {
            int maxLength = Math.max(input1.length(), input2.length());
            if (input1.length() > input2.length()) {
                String number2 = prepend(input2, maxLength);
                return sum(input1, number2);
            } else {
                String number1 = prepend(input1, maxLength);
                return sum(number1, input2);
            }
        } else {
            return sum(input1, input2);
        }
    }

    private static String addTwoNumbersWithComma(String input1, String input2) {
        if (input1.isBlank() || input2.isBlank()) {
            System.out.println("Input cannot be empty.");
        }
        if (input1.length() != input2.length()) {
            int maxLength = Math.max(input1.length(), input2.length());
            if (input1.length() > input2.length()) {
                String number2 = prepend(input2, maxLength);
                return sum(removeComma(input1), removeComma(number2));
            } else {
                String number1 = prepend(input1, maxLength);
                return sum(removeComma(number1), removeComma(input2));
            }
        } else {
            return sum(removeComma(input1), removeComma(input2));
        }
    }

    private static String sum(String input1, String input2) {

        char[] arr1 = input1.toCharArray();
        char[] arr2 = input2.toCharArray();

        int carry = 0;
        StringBuilder total = new StringBuilder();
        for (int i = input1.length()-1; i >= 0; i--) {
            int number1 = Integer.parseInt(String.valueOf(arr1[i]));
            int number2 = Integer.parseInt(String.valueOf(arr2[i]));
            int sum = number1 + number2 + carry;
            if (sum > 9 && i != 0) {
                int reminder = sum % 10;
                carry = sum / 10;
                total.insert(0, reminder);
            } else {
                total.insert(0, sum);
                carry = 0;
            }
        }
        return addComma(total.toString());
    }


    private static String removeComma(String input) {
        if (input.isBlank()) {
            System.out.println("Input cannot be empty.");
        }
        return input.replaceAll(",", "");
    }

    private static String addComma(String input) {
        if (input.isBlank()) {
            System.out.println("Input cannot be empty.");
        }
        if (input.length() <= 3) {
            return input;
        } else {
            StringBuilder sb = new StringBuilder(input).reverse();
            char[] arr1 = sb.toString().toCharArray();
            int index = 1;

            StringBuilder result = new StringBuilder();
            while (index <= sb.length()) {
                if ((index) % 3 == 0 && index != sb.length()) {
                    result.append(arr1[index - 1]).append(",");
                } else {
                    result.append(arr1[index - 1]);
                }
                index++;
            }
            return result.reverse().toString();
        }
    }

    private static String prepend(String input, int maxLength) {
        if (input.isBlank()) {
            System.out.println("Input cannot be an empty string.");
        }
        return "0".repeat(maxLength - input.length()) + input;
    }
}
