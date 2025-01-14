public class minSizeSubarrayChallenge {
    
    //Apparently there is a way todo this in O(log(n)) time. No clue how?
    // Probably some sort of binary search madness. 
    // This passes all tests in 1ms. So imma just keep it
    
    public int minSubArrayLen(int target, int[] nums) {
    int leftPtr = 0, rightPtr = 0;
    int sum = 0;
    int minWindowSize = Integer.MAX_VALUE;

    while (rightPtr < nums.length) { 
        sum += nums[rightPtr];

        while (sum >= target) {
            minWindowSize = Math.min(minWindowSize, rightPtr - leftPtr + 1);
            sum -= nums[leftPtr];
            leftPtr++; //Move leftPtr forward and continue from this point
            //Note: If this never gets reached, then no point in moving left ptr.
            //Since we can never make the sum anyway
        }

        rightPtr++;
    }


    if(minWindowSize == Integer.MAX_VALUE){
        return 0;
    } else {return minWindowSize;}
        


    
    }

    public static void main(String[] args) {
        
        int[] testNumbers = {2,3,1,2,4,3};
        minSizeSubarrayChallenge challenge = new minSizeSubarrayChallenge();
        int challengeResult = challenge.minSubArrayLen(8, testNumbers);
        System.out.println(challengeResult);

    }


}





