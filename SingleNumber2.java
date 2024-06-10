/*
Question No.:137 
Single Number 2 
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,3,2]
Output: 3

Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99

*/
class Solution {
    public int singleNumber(int[] nums) {
        int number=0;
        for(int i=0;i<nums.length;i++)
        {  
            int flag = 0;
            number=nums[i];
            for(int j=0;j<nums.length;j++)
            {
                if(i == j)continue;
                if(nums[j] == number)
                {
                    flag++;
                }
            }
            if(flag == 0)break;
            
        }
       
    return number;
    }

    }

