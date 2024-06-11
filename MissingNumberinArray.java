/*
Geeks for Geeks
Missing NUmber in an array
Given an array of size n-1 such that it only contains distinct integers in the range of 1 to n. Return the missing element.

Examples:

Input: n = 5, arr[] = {1,2,3,5}
Output: 4
Explanation : All the numbers from 1 to 5 are present except 4.

Input: n = 2, arr[] = {1}
Output: 2
Explanation : All the numbers from 1 to 2 are present except 2.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

*/
class Solution {
    public int[] countBits(int n) {
        
        int[] res=new int[n+1];        
        for(int i=0;i<=n;i++){
            int count=0;
            String binaryString = Integer.toBinaryString(i);
            int len=binaryString.length();
            for(int j=0;j<len;j++){
                if(binaryString.charAt(j)=='1'){
                    count++;
                }                
            }
            res[i]=count;            
        }      
        
        return res;
        
    }
}
            
        
