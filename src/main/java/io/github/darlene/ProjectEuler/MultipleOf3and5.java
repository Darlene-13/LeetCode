package io.github.darlene.ProjectEuler;

public class MultipleOf3and5 {

    public int multiples(int [] nums){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            int multiple3 = nums[i] % 3;
            int multiple5 = nums[i] % 5;
            if(multiple3  == 0|| multiple5 == 0){
                sum += nums[i];
            }
        } return sum;
    }
}
