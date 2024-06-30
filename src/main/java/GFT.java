import java.nio.file.Path;

public class GFT {

    public static void main(String[] args) {
        //System.out.println(secondLargest(new int[]{1, 4, 6, 8, 5}));

        var instance = new Child();
    }

    private static int secondLargest(int[] input) {
        int max = 0;
        for (int i=0; i<input.length; i++) {
            if (input[i] > max) {
                max = input[i];
            }
        }

        int secondMax = 0;
        for (int i=0; i<input.length; i++) {
            if (input[i] > secondMax && input[i] != max) {
                secondMax = input[i];
            }
        }
        return secondMax;
    }


    static class Parent {
        private String instanceName;
        Parent(){
            System.out.println("Default Parent");
        }

        Parent(String instanceName){
            this.instanceName = instanceName;
            System.out.println(instanceName);
        }
    }

    static class Child extends Parent {
        private String childInstanceName;

        Child(){
            System.out.println("Default Child");
        }

        Child(String instanceName, String childInstanceName){
            super(instanceName);
            this.childInstanceName = childInstanceName;
            System.out.println(childInstanceName);
        }
    }
}
