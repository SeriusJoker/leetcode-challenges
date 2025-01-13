public class majorityChallenge {


    public int majorityElement(int[] nums) {
        int count = 0, candidate = -1;

        for(int i = 0; i < nums.length; i++){

            if(count == 0){
                candidate = nums[i];
                count++;
            } else {
                if(nums[i] == candidate){
                    count++;
                } else {
                    count--;
                }
            }
            ;

        }
        return candidate;

    }

    

    public static void main(String[] args) {



        majorityChallenge majority = new majorityChallenge();
        int[] testNumbers = {2,2,1,1,1,2,2};
        int count = majority.majorityElement(testNumbers);
        System.out.println(count);
        
    }
}
