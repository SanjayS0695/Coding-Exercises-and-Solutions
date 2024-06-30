import java.util.Collections;
import java.util.List;

public class NashTech {

    //Niraj Kumar Sharma
    //const familyData = [ { id: 1, name: “John Doe”, birthYear: 1945, children:
    // [ { id: 2, name: “Anna Doe”, birthYear: 1973, children: [ { id: 5, name: “Ella Doe”, birthYear: 2000, children: [] },
    // { id: 6, name: “Lucas Doe”, birthYear: 2003, children: [] } ] }, { id: 3, name: “Robert Doe”, birthYear: 1978,
    // children: [ { id: 7, name: “Sophie Doe”, birthYear: 2010, children: [] } ] },
    // { id: 4, name: “Emily Doe”, birthYear: 1985,
    // children: [ { id: 8, name: “James Doe”, birthYear: 2015, children:
    // [ { id: 9, name: “Mia Doe”, birthYear: 2030, children: [] } ] } ] } ] },
    // { id: 10, name: “Jane Smith”, birthYear: 1950,
    // children: [ { id: 11, name: “Ethan Smith”, birthYear: 1980, children: [] } ] } ];

    public static void main(String[] args) {
        var third1 = new Node(5, "Ella Doe", 2000, Collections.emptyList());
        var third2 = new Node(6, "Lucas Doe", 2003, Collections.emptyList());
        var second1 = new Node(2, "Anna Doe", 1973, List.of(third1, third2));
        var third4 = new Node(2, "Sophie Doe", 2010, Collections.emptyList());
        var second2 = new Node(3, "Robert Doe", 1978, List.of(third4));
        var forth1 = new Node(9, "Mia Doe", 1978, Collections.emptyList());
        var third5 = new Node(8, "James Doe", 2030, List.of(forth1));
        var second3 = new Node(4, "Emily Doe", 1985, List.of(third5));

        var first1 = new Node(1, "John Doe", 1945, List.of(second1, second2, second3));
        var second4 = new Node(5, "Ethan Smith", 1980, Collections.emptyList());
        var first2 = new Node(10, "Jane Smith", 1950, List.of(second4));

        var family = List.of(first1, first2);
        printTheFamilyTree(family);

    }

    private static void printTheFamilyTree(List<Node> tree) {
        if (tree.isEmpty()) {
            return;
        }

        for (int i=0; i < tree.size(); i++) {
            System.out.print(tree.get(i));
            System.out.println("----------------");
            printTheFamilyTree(tree.get(i).children);
        }
    }

    static class Node {
        Node(Integer id, String name, Integer birthYear, List<Node> children) {
            this.id = id;
            this.name = name;

            this.birthYear = birthYear;
            this.children = children;
        }
        public Integer id;
        public String name;
        public Integer birthYear;
        public List<Node> children;

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", birthYear=" + birthYear +
                    ", children=" + children +
                    '}';
        }
    }
}
