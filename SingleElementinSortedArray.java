/*
Question No. 540
Single element in a sorted array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10

 

Constraints:

    1 <= nums.length <= 105
    0 <= nums[i] <= 105


*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans=0;
        int index=0;
        int n=nums.length;

        for(int num:nums){
            ans=ans^num;
        }        
        for(int i=0;i<n;i++){
            int mask=(1<<i);
            if((ans&(mask))!=0){
                index=i;
                break;
            }
        }
        int mask=(1<<index);
        int xor1=0;

        for(int i=0;i<n;i++){
            if((ans&mask)!=0){
                xor1=xor1^nums[i];
            }
        }
        return xor1;
    }
}
