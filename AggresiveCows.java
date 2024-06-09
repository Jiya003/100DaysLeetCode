/*
Question No.:

Aggressive Cow

You are given an array consisting of n integers which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
The first line of input contains two space-separated integers n and k.
The second line contains n space-separated integers denoting the position of the stalls.

Example 1:

Input:
n=5 
k=3
stalls = [1 2 4 8 9]
Output:
3
Explanation:
The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows, in this case, is 3, 
which also is the largest among all possible ways.

Example 2:

Input:
n=5 
k=3
stalls = [10 1 2 7 5]
Output:
4
Explanation:
The first cow can be placed at stalls[0],
the second cow can be placed at stalls[1] and
the third cow can be placed at stalls[4].
The minimum distance between cows, in this case, is 4,
which also is the largest among all possible ways.
*/
import java.util.*;
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        
        int n=stalls.length();
        int low=stalls[0];
        int high=stalls[n-1];
        int result=0;
        
        while(low<=high){
            int mid=(low+high)/2;
            
            if(PlacingCows(stalls,mid,k)){
                result=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return result;
    }
    
    public static boolean PlacingCows(int[] array, int dist, int cows){
        int countCows=1; //minimum would be one cow
        int cow=array[0];
        int n=array.length;
        
        for(int i=1;i<n;i++){
            if(array[i]-cow>dist){
                countCows++;
                cow=array[i];
            }
            
        }
        if(countCows>=dist) return true;
        return false;
    }
}
