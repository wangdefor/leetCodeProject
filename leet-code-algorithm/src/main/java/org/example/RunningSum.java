package org.example;

/**
 * @Classname RunningSum
 * @Description RunningSum
 * @Date 2021/2/23 19:43
 * @Created wangyong
 */
public class RunningSum {

    public static int[] runningSum(int[] nums) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int start = 0;
            for (int j = 0 ; j < i + 1 ; j ++){
                start = start + nums[j];
            }
            a[i] = start;
        }
        return a;
    }
}
