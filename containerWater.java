public class containerWater {




    public int maxArea(int[] height) {
        int endPtr = height.length - 1;
        int startPtr = 0;
        int maxArea = 0;
    
        while (startPtr < endPtr) {
            int length = endPtr - startPtr;
            int tallness = Math.min(height[startPtr], height[endPtr]);
            int currentArea = tallness * length;
            maxArea = Math.max(maxArea, currentArea);
    
            // Move the pointer pointing to the shorter line
            if (height[startPtr] < height[endPtr]) {
                startPtr++;
            } else {
                endPtr--;
            }
        }
    
        return maxArea;
    }


    public static void main(String[] args) {

        int[] heights = {1,8,6,2,5,4,8,3,7};

        containerWater container = new containerWater();
        int answer = container.maxArea(heights);
        System.out.println(answer);

        
    }
    
}
