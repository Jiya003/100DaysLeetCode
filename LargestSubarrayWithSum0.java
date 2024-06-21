/*
Largest Subarray with Sum 0

Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.

Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
-1000 <= A[i] <= 1000, for each valid i
*/
import java.util.*;
public class LongestSubarray{

	public static int BF(int[] arr){
		int n=arr.length;
		//int currentLength=0;
		int maxLength=0;
		
		
		
		for(int i=0;i<n;i++){
			int sum=0;
			for(int j=i;j<n;j++){
				
				sum+=arr[j];
				
				if(sum==0){
					int currentLength = j - i + 1;
                    			maxLength = Math.max(maxLength, currentLength);
					
				}
			}
		}
		return maxLength;
	}
	
	public static int Optimal(int[] arr){
		Map<Integer,Integer> hm=new HashMap<Integer,Integer>();
		int maxLength=0;
		int prefixSum=0;
		
		int currentLength=0;		
		int n=arr.length;
		for(int i=0;i<n;i++){
			
			prefixSum+=arr[i];
			
			if(prefixSum==0){
				maxLength=i+1;
			}else{
				if(hm.containsKey(prefixSum)){
					int prevIndex=hm.get(prefixSum);
					currentLength=i-prevIndex;
					
					maxLength=Math.max(currentLength,maxLength);
				}else{
					hm.put(prefixSum,i);
				}
				
			}
			}
			
			return maxLength;		
			
		}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number of elements:");
		int n=sc.nextInt();
		
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		
		System.out.println(BF(arr));
		
		System.out.println(Optimal(arr));
		sc.close();
	}
}
