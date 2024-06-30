import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Microsoft {

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{1, 3}, new int[]{2, 2}));
    }
    public static boolean solution(int N, int[] A, int[] B) {
        // Implement your solution here
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i =0; i < A.length ; i++) {
            int value = A[i];
            if (null == map.get(value)) {
                List<Integer> list = new ArrayList<>();
                list.add(B[i]);
                map.put(value, list);
            } else {
                List<Integer> list = map.get(value);
                list.add(B[i]);
                map.put(A[i], list);
            }
        }
        boolean valid = true;
        for (int i = 1; i <= N-1; i++) {
            if ((map.get(i) != null && map.get(i).contains(i+1)) || checkIfKeyHAsValue(map, i)) {
                continue;
            } else {
                valid = false;
                break;
            }
        }
        return valid;
    }

    private static boolean checkIfKeyHAsValue(Map<Integer, List<Integer>> map, int i) {
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            if (entry.getValue().contains(i) && entry.getKey() == i +1) {
                return true;
            }
        }
        return false;
    }
}
