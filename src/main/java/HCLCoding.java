

import java.util.ArrayList;
import java.util.List;

public class HCLCoding {

    public static void main(String[] args) {
        //Write a function to chop a string into chunks of a given length and return it as array
        //stringChop("JavaScript"); // ["JavaScript"]
        //
        //stringChop("JavaScript", 2); // ["Ja", "va", "Sc", "ri", "pt"]
        //
        //stringChop("JavaScript", 3); // ["Jav", "aSc", "rip", "t"]

        System.out.println(stringChop("Javascript", 1));
    }

    public static List<String> stringChop(String input, int chopLength) {
        List<String> result = new ArrayList<>();

        int j = chopLength;
        int k = 2;
        for (int i = 0; i < input.length(); ) {
            //
            if (j > input.length()) {
                result.add(input.substring(i));
            } else {
                result.add(input.substring(i, j));
            }

            i = j;
            j = chopLength * k++;
        }

        return result;
    }
}