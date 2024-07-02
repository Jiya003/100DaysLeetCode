/*
Question No. 349
Intersection of Two Array I

Given two integer arrays nums1 and nums2, return an array of their
intersection
. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

 

Constraints:

    1 <= nums1.length, nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 1000


*/

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = nums1.length;
        int n2 = nums2.length;

        List<Integer> resultList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                // Avoid duplicates in result list
                if (resultList.isEmpty() || resultList.get(resultList.size() - 1) != nums1[i]) {
                    resultList.add(nums1[i]);
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        
        int[] array = new int[resultList.size()];
        for (int k = 0; k < resultList.size(); k++) {
            array[k] = resultList.get(k);
        }

        return array;
    }
}
