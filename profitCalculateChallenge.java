public class profitCalculateChallenge {

    public int calculateProfit(int[] prices, int startDay, int endDay){


        int profit = prices[endDay] - prices[startDay];
        //System.out.println(profit);
        return profit;

    }

    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int cheapestDay = Integer.MAX_VALUE;


        for(int i = 0; i < prices.length; i++){

            if(prices[i] < cheapestDay){
                cheapestDay = prices[i];
            } else if (prices[i] - cheapestDay > maxProfit){
                maxProfit = prices[i] - cheapestDay;
            }



        }

        return maxProfit;

        
    }

    public static void main(String[] args) {
        
        
        int[] testNumbers = {7,1,5,3,6,4};
        profitCalculateChallenge profit = new profitCalculateChallenge();
        int totalProfit = profit.maxProfit(testNumbers);
        System.out.println("Total Profit is... " + totalProfit);

        

    }
    
}
