/*
Question No. 1248
Count Number of Nice Subarray

Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.

Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16

 

Constraints:

    1 <= nums.length <= 50000
    1 <= nums[i] <= 10^5
    1 <= k <= nums.length


*/
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //Brute Force
        /*
        int n=nums.length;
        int[] arr=new int[n+1];
        arr[0]=0;

        for(int i=0;i<n;i++){
            if(nums[i]%2==0) arr[i+1]=arr[i]+0;
            else arr[i+1]=arr[i]+1;
        }

        int count = 0;

        // Count subarrays with exactly k odd numbers
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (arr[j] - arr[i] == k)
                    count++;
            }
        }

        return count;
        */

        int n=nums.length;
        Map<Integer,Integer> hm=new HashMap<>();

        hm.put(0,1);
        int count = 0;
        int oddCount = 0;

        for (int num : nums) {
            if (num % 2 == 1) {
                oddCount++;
            }

            // Check if there exists a count such that (oddCount - count) == k
            if (hm.containsKey(oddCount - k)) {
                count += hm.get(oddCount - k);
            }

            // Update the countMap
            hm.put(oddCount, hm.getOrDefault(oddCount, 0) + 1);
        }

        return count;
    }

    
}
