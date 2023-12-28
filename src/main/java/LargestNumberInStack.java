import java.util.Stack;

public class LargestNumberInStack {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(5);
        s.push(3);
        s.push(0);
        s.push(7);
        s.push(4);

        System.out.println(largestNumberInStack(s));

        System.out.println(s.toString());
    }

    public static int largestNumberInStack(Stack<Integer> s1) {
        int largest = 0;
        Stack<Integer> s2 = new Stack<Integer>();

        while (!s1.empty()) {
            int current = s1.pop();
            if (largest < current) {
                largest = current;
            }
            s2.push(current);
        }

        while (!s2.empty()) {
            s1.push(s2.pop());
        }

        return largest;
    }
}
