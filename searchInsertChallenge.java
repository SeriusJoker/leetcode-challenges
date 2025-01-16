public class searchInsertChallenge {


    public int searchInsert(int[] nums, int target) {
        //Goal, find target in nums in O(Log(n)) time. Divide and Conquer Algorithm

        if(target > nums[nums.length-1]){
            return nums.length;
        }
        if(target < nums[0]){
            return 0;
        }
       
        int left = 0, right = nums.length-1;

        while(left<=right){
            int mid = left + (right - left) /2;

            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                //Target is in bottom half
                right = mid-1; // -1 because we know its not mid itself. Already checked
            }
            if(nums[mid] < target){
                //Target is in top half
                left = mid+1;
            }


        }

        return left;
      

    }

    
    
    
    public static void main(String[] args) {
        int[] testNumbers = {1,3,5,6};   
        int target = 6;
        
        searchInsertChallenge insert = new searchInsertChallenge();
        int answer = insert.searchInsert(testNumbers, target);
        System.out.println(answer);
    }
    
}
