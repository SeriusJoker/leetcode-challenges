public class profitCalculateChallengeHarder {

    public boolean isNumberAPeak(int[] nums, int index){

        //First we need to check if the number is at the start of the Array
        if(index == 0) {
            if(nums[index] > nums[index+1]){
                return true;
            } else {
                return false;
            }
        }

        //Need to check if the number is at the end of the Array
        if(index == nums.length-1){
            if(nums[index] > nums[index-1]){
                return true;
            } else {
                return false;
            }
        }

        if(nums[index] == nums[index-1] && nums[index+1] < nums[index]){
            return true;
        } 
        if(nums[index] == nums[index-1] && nums[index+1] > nums[index]){
            return false;
        }


        //This will work for values in the middle of the array
        if(nums[index+1] < nums[index] && nums[index-1] < nums[index]){
            //We have a peek
            return true;

        }
         return false;
    }

    public boolean isNumberAValley(int[] nums, int index){



        //If the number is at the start of the array
        if(index == 0){
            if(nums[index] < nums[index+1]){
                return true;
            } else {return false;}
        }

        //If the number is at the end of the array
        //Note: This part may become irrelevent since you never purchase on the last day
        if(index == nums.length-1){
            if(nums[index] < nums[index-1]){
                return true;
            } else {return false;}
        }

        //What if the number has an identical number behind it.
        //Keep in mind, we skip the first value

        if(nums[index] == nums[index-1] && nums[index+1] > nums[index]){
            return true;
        } 
        if(nums[index] == nums[index-1] && nums[index+1] < nums[index]){
            return false;
        }

        //Now lets handle the cases in the middle
        if(nums[index] < nums[index-1] && nums[index] < nums[index+1]){
            return true;
        }
        return false;
    }

    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int currentSharePrice = -1; //Assumption: Share prices are never negative
        //Basic idea: Buy on the Valleys, sell on the peeks.

        //Check if there is only 1 day of data
        if(prices.length == 1){
            return 0;
        }


        
        for(int i = 0; i < prices.length; i++){
            
            //If a value is followed by an identical value, lets just keep rolling past it
            if(i < prices.length-1 && prices[i] == prices[i+1]){
                i++;
            }

            if(isNumberAValley(prices, i) && i != prices.length-1 && currentSharePrice == -1){ //Dont buy at last
                //System.out.println(prices[i] + " Is a valley");
                currentSharePrice = prices[i];
                totalProfit -= prices[i];
            }

            if(isNumberAPeak(prices, i) && currentSharePrice != -1 ){ //Cant sell if we don't have anything!
                totalProfit += prices[i];
                currentSharePrice = -1; //Sold our share.
            }
            // You're at the end. If you have anything left, sell it!
            if(i == prices.length-1 && currentSharePrice != -1){
                totalProfit += prices[i];
            }

            System.out.println("Current Profit is: " + totalProfit);

        }

        if(totalProfit < 0){
            return 0; //Will make no profit. Dont buy or sell
        }

        return totalProfit;
    }





    public static void main(String[] args) {
        int[] testNumbers = {1,9,6,9,1,7,1,1,5,9,9,9};
        profitCalculateChallengeHarder profit = new profitCalculateChallengeHarder();

        int totalProfit = profit.maxProfit(testNumbers);
        System.out.println(totalProfit);





    }
    
}
