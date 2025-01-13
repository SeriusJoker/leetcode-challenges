//import java.util.*;
public class removeElementChallenge {

    public int findFirstSparePlace(int[] nums, int val){
        
        for(int i = nums.length - 1; i >= 0; i--){
            //First spare place is the first index which isn't a val
            if(nums[i] == val) return i;
        }
        //If loop completes, there is no spare space. Return -1;
        return -1;
        
    }

    public int removeElement(int[] nums, int val) {
        int functionalEndOfArrayIndex = nums.length - 1;
        //int removalCount = 0;
    
        for (int i = 0; i <= functionalEndOfArrayIndex; i++) {
            if (nums[i] == val) {
                // Swap the current element with the element at functionalEndOfArrayIndex
                nums[i] = nums[functionalEndOfArrayIndex];
                nums[functionalEndOfArrayIndex] = val;
                functionalEndOfArrayIndex--;
                //removalCount++;
                i--; // Recheck the current index as it now has a new value
            }
        }
        //Lets just count all the values
        int counter = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val) counter++;
        }
        return nums.length - counter;
    }

    public static void main(String[] args) {
        int[] testArray = {0,1,2,2,3,0,4,2};
        removeElementChallenge elementCounter = new removeElementChallenge();
        int count = elementCounter.removeElement(testArray, 2);

        for(int i = 0; i < testArray.length; i++){
            System.out.println(testArray[i]);
        } 
        System.out.println("You removed: " + count+ " Items");

        //int coun = elementCounter.findFirstSparePlace(testArray, 2);
        //System.out.println(coun);
    }
    
}
