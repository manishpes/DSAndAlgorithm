package com.manish.practice.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutation {

        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {

            int l =0;
            int r = nums.length-1;

            permute(nums, l, r);
            return result;

        }

        private void permute(int []nums , int l, int r){
            if(l == r)
            {
                result.add(new ArrayList<Integer>() {{ for (int i : nums) add(i); }});
            }
            for(int i =l; i<=r; l++){
                swap(nums, l,i);
                permute(nums, l+1,r);
                swap(nums, l,i);
            }
        }
        private void swap(int nums[], int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
}
