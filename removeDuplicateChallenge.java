public class removeDuplicateChallenge {
    public int removeDuplicates(int[] nums) {
        
        int previousValue = nums[0];
        int currentValue;
        int duplicateCount = 0;

        for(int i = 1; i < nums.length - duplicateCount; i++){
            currentValue = nums[i];

            if(currentValue == previousValue){ // Found a duplicate!
                shuffleDown(nums, i);
                duplicateCount++;
                i--;
            } else {
                previousValue = currentValue;
            }

        }

        return nums.length - duplicateCount;
    }
    //This function will take an array of Nums, remove the value from the index, shuffle all 
    //The other values down by 1. Then put the indexed number at the end
    public void shuffleDown(int[] nums, int index){

        int endOfArray = nums.length-1;
        int valueAtIndex = nums[index-1];

        for(int i = index; i <= endOfArray; i++){
            //System.out.print(nums[i] + " ");
            nums[i-1] = nums[i];
        }
        nums[endOfArray] = valueAtIndex;


    }

    public static void main(String[] args) {
        int[] testNumbers = {0,0,1,1,1,2,2,3,3,4};

        removeDuplicateChallenge theChallenge = new removeDuplicateChallenge();
        //theChallenge.shuffleDown(testNumbers, 2);
        int duplicateCount = theChallenge.removeDuplicates(testNumbers);

        for(int i = 0; i < testNumbers.length; i++){
            System.out.print(testNumbers[i] + " ");
        }
        System.out.println("\nDuplicate Count:" + duplicateCount);
    }
}
