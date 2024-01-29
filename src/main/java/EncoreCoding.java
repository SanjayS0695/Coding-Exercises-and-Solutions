
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EncoreCoding {

    //Kochouseph Chittilappilly went to Dhruv Zplanet ,
    // a gaming space, with his friends and played a game called “Guess the Word”.

    //Rules of games are –
    //	•	Computer displays some strings on the screen and the player should pick one string /
    //	word if this word matches with the random word that the computer picks then the player is declared as Winner.
    //	•	Kochouseph Chittilappilly’s friends played the game and no one won the game.
    //	This is Kochouseph Chittilappilly’s turn to play and he decided to must win the game.
    //	•	What he observed from his friend’s game is that the computer is picking up the string
    //	whose length is odd and also that should be maximum. Due to system failure computers sometimes
    //	cannot generate odd length words.
    //
    //	Check below cases for better understand
    //Sample input :
    //5 → number of strings
    //Hello Good morning Welcome you
    //Sample output :
    //morning
    //Explanation:
    //	•	Hello → 5
    //	•	Good → 4
    //	•	Morning → 7
    //	•	Welcome → 7
    //	•	You → 3
    //First word that is picked by computer is morning

    public static void main(String[] args) {
        String input = "H Good mornin Welcom  ";
        //System.out.println(playTheGame(input));

        Stream<String> stream1 = Stream.of("Welcome", "Here");
        Stream<String> stream2 = Stream.of("Hello", "World");
        String output = Stream.concat(stream1, stream2).collect(Collectors.joining());
        System.out.println(output);
    }

    private static String playTheGame(String input) {
        String[] inputArrays = input.split(" ");

        if (inputArrays.length == 0) {
            System.out.println("Input is empty");
            return null;
        }

        int maxLength = 0;

        for (int i = 0; i < inputArrays.length; i++) {
            var length = inputArrays[i].length();
            if (length % 2 != 0) {
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }
        int finalMaxLength = maxLength;
        var optionalResult = Arrays.stream(inputArrays).filter(s -> s.length() == finalMaxLength)
                .findFirst();
        return optionalResult.orElse(null);
    }

    //Write a Java 8 program to concatenate two Streams

}
