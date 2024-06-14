/*
Question No. 945
Minimum Increment to make Array Unique
You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.

Return the minimum number of moves to make every value in nums unique.

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].

Example 2:

Input: nums = [3,2,1,2,1,7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.

 

Constraints:

    1 <= nums.length <= 105
    0 <= nums[i] <= 105


*/
class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int cnt=0;
       
        for(int i=1;i<n;i++){
            int prev=0;
            prev=nums[i-1];
            if(prev>=nums[i]){
                int temp=nums[i];
                nums[i]=nums[i-1]+1;
                cnt=(nums[i]-temp)+cnt;                
            }
        }
        return cnt;        
    }
}
