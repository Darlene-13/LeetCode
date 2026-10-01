package io.github.darlene.InterviewPrep.Day1Arrays;

public class ContainerWithMostWater {

    public int maxArea(int[] height){
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        for(int i = 0; i < height.length ; i++){
            int currHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = currHeight * width;
            maxArea = Math.max(area, maxArea);


            if(height[left] < height[right]){
                left ++;
            } else {
                right --;
            }
        }

        return maxArea;
    }
}
