
// CODE EXAMPLE VALID FOR COMPILING
import java.util.*;
import java.util.stream.Collectors;

class EpamCoding {
    public static void main(String[] args) {

        int price[] = { 20,10,20,30,40,50,80,10,90 };
        //
        //to buy
        Map<String, Integer> maxProfitDays = new HashMap<>();
        for (int i = 0; i < price.length-1;) {
            int buy = price[i];
            int maxProfit = 0;
            int soldOn = 0;
            boolean shouldIncrement = true;

            for (int j = i+1; j < price.length;) {
                int sold = price[j];
                soldOn = j;
                if (sold <= buy) {
                    i  = j;
                    shouldIncrement = false;
                    break;
                }
                int profit = sold - buy;

                if (profit > maxProfit) {
                    maxProfit = profit;
                }
                j++;
            }

            if (shouldIncrement) {
                i++;
            }
            if (maxProfit > 0) {
                maxProfitDays.put(String.format("Buy at day %s and Sell at day %s", i, soldOn), maxProfit);
            }
        }

        System.out.println("Profitable days: ");
        for (Map.Entry<String, Integer> entry : maxProfitDays.entrySet()) {
            System.out.println(String.format("%s : %s", entry.getKey(), entry.getValue()));
        }
        System.out.println(String.format("Max profit is %s", maxProfitDays.values().stream().collect(Collectors.summarizingInt(Integer::intValue)).getSum()));
    }
}