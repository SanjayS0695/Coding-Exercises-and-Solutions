import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Convera {

    private static Dictionary<Integer, Integer> dictionary;

    static {
        dictionary = new Hashtable<>();
        dictionary.put(1, 10);
        dictionary.put(2, 9);
        dictionary.put(3, 8);
        dictionary.put(4, 7);
        dictionary.put(5, 6);
        dictionary.put(6, 5);
        dictionary.put(7, 4);
        dictionary.put(8, 3);
        dictionary.put(9, 2);
        dictionary.put(0, 1);

    }
    public static void main(String[] args) {
        findTheSeatPartition(36);
    }

    private static void findTheSeatPartition(int input) {
            int range = input % 10; //9
            int partition = range != 0 ? input / 10 + 1 : input / 10; //2
            int coupledSeat = input/10 * 10 + dictionary.get(range);
            System.out.println("Seating is: " + partition + "-" + coupledSeat);
    }

}
