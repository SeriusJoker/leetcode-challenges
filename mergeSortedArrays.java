import java.util.*;
public class mergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {        

        int nums2Counter = 0;

        for(int i = m+n-1; i >= 0; i--){
            //System.out.println(nums1[i]);
            if(nums1[i] == 0){
                //If the num is 0 then we need to insert a value here
                nums1[i] = nums2[nums2Counter];
                nums2Counter++;
                if(nums2Counter > n-1){
                    break;
                }
            }
        }

        Arrays.sort(nums1);

        for(int i = m+n-1; i >= 0; i--){
            System.out.println(nums1[i]);
        }


        
        
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        mergeSortedArrays merger = new mergeSortedArrays();
        merger.merge(nums1, 3, nums2, 3);
        
        int[] nums3 = {1};
        int[] nums4 = {};
        System.out.println();
        merger.merge(nums3, 1, nums4, 0);

        int[] nums5 = {0};
        int[] nums6 = {1};

        System.out.println();
        merger.merge(nums5, 0, nums6, 1);

        int[] nums7 = {-1,0,0,3,3,3,0,0,0};
        int[] nums8 = {1,2,2};
        System.out.println();
        merger.merge(nums7, 6, nums8, 3);

        
    }
}
