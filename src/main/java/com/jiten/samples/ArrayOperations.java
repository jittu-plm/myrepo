package com.jiten.samples;

import java.util.HashMap;
import java.util.Map;

public class ArrayOperations {

    public static void main(String[] args) {
        System.out.println("Hello Java");
        int[] nums = new int[]{2,5,4,7};

        printArray(findMatch(nums,6));
    }

    public static int[] findMatch(int[] nums, int target){
        Map<Integer, Integer> map  = new HashMap<>();
        int                   diff = 0;
        for(int i = 0; i<nums.length;i++){
            diff = target - nums[i];
             if(!map.containsKey(nums[i])) {
                map.put(diff,nums[i]);
             } else {
                 return new int[] {map.get(nums[i]),nums[i]};
            }
        }
        return null;
    }

    public static void printArray(int[] result){
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}


/*

class MyCode {
    public static void main (String[] args) {


        MyCode.findMatch(nums, 6)
                .entrySet()
                .stream()
                .filter(e -> e.getKey() + e.getValue() == 6)
                .forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
    }



}*/
