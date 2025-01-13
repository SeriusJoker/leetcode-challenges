public class rotateArrayChallenge {
    
    public void swapTwoValues(int[] nums, int index1, int index2){

        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

    }

    public void shuffleLeft(int[] nums){



        //Lets start with the wrap around value
        int temp = nums[0];
        int temp2;
        nums[0] = nums[nums.length-1];

        for(int i = 1; i <= nums.length-1; i++){

            temp2 = nums[i];
            nums[i] = temp;
            temp = temp2;

        }






    }

    
    
    
    public void rotate(int[] nums, int k) {


        for(int i = 0; i < k; i++){

            shuffleLeft(nums);



        }
        
    }



    public static void main(String[] args) {
        
        int[] testNumbers = {0,1,2,3,4,5,6};

        rotateArrayChallenge rotate = new rotateArrayChallenge();

        rotate.rotate(testNumbers,3);

        for(int i = 0; i < testNumbers.length; i++){
            System.out.print(testNumbers[i] + " ");
        }


    }
}
