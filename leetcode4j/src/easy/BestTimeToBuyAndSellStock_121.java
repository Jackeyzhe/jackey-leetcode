package easy;

public class BestTimeToBuyAndSellStock_121 {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock_121 solution = new BestTimeToBuyAndSellStock_121();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int result = solution.maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < minValue) {
                minValue = price;
            } else if (price - minValue > max) {
                max = price - minValue;
            }
        }
        return max;
    }
}
