import java.util.Arrays;

/**
 * Created by zhoucheng on 11/5/17.
 */
public class BestTimeToBuyAndSellStock {
    // single transaction
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int min = prices[0];
        int diff = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < min) min = prices[i];
            if(prices[i] - min > diff) diff = prices[i] - min;
        }
        return diff;
    }


    // multiple transaction
    public int multipleTrans(int[] prices) {
        if(prices.length <= 1) return 0;
        int min = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > min) {
                profit+=(prices[i] - min);
                min = prices[i];
            } else if(prices[i] < min) {
                min = prices[i];
            }
        }
        return profit;
    }

    public int withCoolDown(int[] prices) {
        if(prices.length <= 1) return 0;
        int buy = -1 * prices[0];
        int sell = 0;
        int prev_sell = 0;
        int prev_buy = 0;
        for(int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_buy, prev_sell - price);
            prev_sell = sell;
            sell = Math.max(prev_sell, prev_buy + price);
        }
        return sell;
    }

    public int withFee(int[] prices, int fee) {
        int sell = 0;
        int buy = Integer.MIN_VALUE;
        for(int price : prices) {
            int prev_buy = buy;
            buy = Math.max(prev_buy, sell-price-fee);
            sell = Math.max(prev_buy+price, sell);
        }
        return sell;
    }

    // with transaction limit
    public int general(int k, int[] prices) {
        if(k >= prices.length/2) {
            // treat as infinite
            return multipleTrans(prices);
        }

        int[] noStocks = new int[k+1];
        int[] hasStocks = new int[k+1];

        Arrays.fill(noStocks, 0);
        Arrays.fill(hasStocks, Integer.MIN_VALUE);

        for(int i = 0; i < prices.length; i++) {
            int price = prices[i];
            for(int j = k; j >= 1; j++) {
                noStocks[j] = Math.max(noStocks[j], hasStocks[j] + price);
                hasStocks[j] = Math.max(hasStocks[j], noStocks[j-1] - price);
            }
        }

        return noStocks[k];
    }

}
