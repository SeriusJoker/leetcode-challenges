public class twoSumChallenge {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length-1;
        int sum = numbers[left]+numbers[right];
        int[] returnArray = {0,0};

        //If left+right > target, decrease right.
        //If left+right < target, increase left.
        //There is always a solution!


        while(left != right){

            if(sum == target){
                returnArray[0] = left+1;
                returnArray[1] = right+1;
                break;
            }
            sum = numbers[left]+numbers[right];
            if(sum > target) right--; //Need smaller number
            if(sum < target) left++; //Need larger number




        }
        
        return returnArray;
            //To pass tests
    }


    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        twoSumChallenge challenge = new twoSumChallenge();
        int[] answer = challenge.twoSum(nums, target);
        
        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i] + " ");
        }
        
    }
    
}
