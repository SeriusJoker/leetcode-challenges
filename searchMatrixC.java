public class searchMatrixC {

    //Will do Binary search on rows to find out where the target SHOULD BE
    public int findWhichRow(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
    
        // Will want to examine the final entry of the rows
        while (left <= right) {
            int mid = left + (right - left) / 2;
    
            if (matrix[mid][matrix[mid].length - 1] >= target) {
                // It could be in this row... Or a previous row... Hmmmm
                // Let's see how it holds up to the previous row
                if (mid == 0 || matrix[mid - 1][matrix[mid - 1].length - 1] < target) {
                    System.out.println(mid);
                    return mid;
                }
                // Okay, looks like we need to decrease the right
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    
        return -1; // Target not found in any row
    }
    

    public boolean searchMatrix(int[][] matrix, int target) {

        int correctRow = findWhichRow(matrix, target);
        //Now we have the correct row, we need to binary search through that row
        if(matrix.length==1){
            correctRow = 0;
        }
        if(correctRow == -1){
            return false;
        }

        int left = 0, right = matrix[correctRow].length-1;

        while(left<=right){

            int mid = left + (right-left)/2;
            
            if(matrix[correctRow][mid] == target){
                return true;
            }

            if(matrix[correctRow][mid] > target){
                right = mid-1;
            } else {
                left = mid+1;
            }



        }

        return false;
    }

    public static void main(String[] args){
        searchMatrixC searchMatrix = new searchMatrixC();
        
        //int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = {{1}};
        boolean answer = searchMatrix.searchMatrix(matrix, 1);
        System.out.println(answer);


    }
    
}
