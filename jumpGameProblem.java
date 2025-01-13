public class jumpGameProblem {





    
    public boolean canJump(int[] nums) {

        int target = nums[nums.length-1]; //Initial Target

        if(nums.length == 1){
            return true;
        }
        int jumpValue =0;

        for(int i = nums.length-1; i >= 0; i--){ //Starts array at 2nd position
            
            jumpValue = nums[i];

            if(jumpValue + i>= target){ // Can reach target from this position
                target = i;
            }
        }
        if(target == 0 )return true;
        return false;
    }


    public static void main(String[] args) {
        
        int[] testNumbers = {2,0,1,1,3};
        jumpGameProblem jump = new jumpGameProblem();
        boolean canJump = jump.canJump(testNumbers);
        System.out.println(canJump);


        
    }
    
}
