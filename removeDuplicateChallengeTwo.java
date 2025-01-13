public class removeDuplicateChallengeTwo {
    
    

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

    public boolean checkIfTwoAreAlreadyDetected(int[] nums, int value){
        
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == value) count++;
            if(count == 2) return true;
        }



        
        return false;
    }

    public int removeDuplicates(int[] nums) {
        // Now I need to check if there are at least two of a value before I shuffle
        int[] duplicateValueArray = new int[nums.length]; // When I check this, only check up to the removed amount
        int duplicateValueIndex = 0;
        int zeroCount = 0;

        int previousValue = nums[0];
        int currentValue;
        int duplicateCount = 0;

        for (int i = 0; i < nums.length - duplicateCount; i++) { // Start from 0 to include the first element
            currentValue = nums[i];

            if (currentValue == 0) {
                zeroCount++;
                if (zeroCount > 2) {
                    shuffleDown(nums, i);
                    duplicateCount++;
                    i--;
                }
            } else if (currentValue == previousValue && checkIfTwoAreAlreadyDetected(duplicateValueArray, currentValue)) { // Found a duplicate!
                shuffleDown(nums, i);
                duplicateCount++;
                i--;
            } else {
                duplicateValueArray[duplicateValueIndex] = currentValue;
                duplicateValueIndex++;
                previousValue = currentValue;
            }
        }

        return nums.length - duplicateCount;
    }

    public static void main(String[] args) {

        int[] testNumbers = {0,0,0,1,1,1,2,2,3};

        removeDuplicateChallengeTwo duplicateTwo = new removeDuplicateChallengeTwo();
        duplicateTwo.removeDuplicates(testNumbers);
        for(int i = 0; i < testNumbers.length; i++){
            System.out.print(testNumbers[i] + " ");
        }


        
    } 


}
