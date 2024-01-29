

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LegionCoding {

    public static void main(String[] args) {
        //[15, 28] [1, 5] [27, 35]
        //arr = [1000, 1100][0800, 0900] [0930, 1030]

        //for i = 1000; i < 1100; i++
        //while(i != )

        //for [a, b]
        // c d
        // (c >= a && c <=b) || (d >= a && d <=b)

        // function(List<> arr, List<> list, int index)
        // for(List<Integer> entry: list) {
        // if (entry.get(0) >= )

        Integer[] arr1 = new Integer[]{1000, 1100};
        Integer[] arr2 = new Integer[]{800, 930};
        Integer[] arr3 = new Integer[]{930, 1000};
        List<Integer[]> slots = List.of(arr1, arr2, arr3);
        checkAvailability(slots);
    }

    public static boolean checkAvailability(List<Integer[]> slots) {
        if (slots.isEmpty()) {
            System.out.println("Slots are empty");
        } else {
            var sortedList = slots.stream().sorted(Comparator.comparing(o -> o[0])).toList();
            sortedList.forEach(integers -> {
                System.out.println(String.format("[%s - %s]", integers[0], integers[1]));
            });

            for (int i = 0; i < sortedList.size() - 1; i++) {
                var currentSlot = sortedList.get(i);
                var nextSlot = sortedList.get(i + 1);

                if ((nextSlot[0] >= currentSlot[0] && nextSlot[0] <= currentSlot[1])) {
                    System.out.println(String.format("There is conflict between slots of [%s - %s] and [%s -%s]",
                            currentSlot[0], currentSlot[1], nextSlot[0], nextSlot[1]));
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
