public class CodingHCL {

    public static void main(String[] args) {

    }

//    public static  merge(int[] arr, int l, int r) {
//        int N = arr.length;
//
//        while (l < r) {
//            if (arr[l] > arr[r]) {
//                int temp = arr[l];
//                arr[l++] = arr[r];
//                arr[r++] = temp;
//            }
//            l++;
//            r++;
//        }
//
//        merge(arr, l, N/2) + merge(arr, N/2, N);
//
//    }

    class ParkingLot {
        private Integer spaceForTwoWheeler;
        private Integer spaceForFourWheeler;
        private Integer spaceForThreeWheeler;

        //getter
        //setters

        public void park(Vehicle vehicle) {
            //
        }
    }

    class Vehicle {
        private VehicleType type;
        private Integer spaceNeeded;

    }

    class TwoWheeler extends Vehicle {

    }

    class FourWheeler extends Vehicle {

    }

    class ThreeWheeler extends Vehicle {

    }

    enum VehicleType {
        TWO_WHEELER,
        FOUR_WHEELER,
        THREE_WHEELER
    }
}
