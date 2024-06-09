/*Question No.: 974
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.
 

Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

Example 2:

Input: nums = [5], k = 9
Output: 0

 

Constraints:

    1 <= nums.length <= 3 * 104
    -104 <= nums[i] <= 104
    2 <= k <= 104


 */
/import java.util.*;
public class Subarray {

    public static int BruteForce(int[] array,int k){
        int n=array.length;
        int i=0; 
        int j=0;
        //int sum=0;
        int count=0;
        for(i=0;i<n;i++){
            int sum=0;
            for(j=i;j<n;j++){
                
                sum+=array[j];//Here we are calculating sum everytime, we can use O(1) also.
                if(sum%k==0) count++;
            }            
        }
        return count;
    }

    public static int BruteForce2(int[] array,int k){
        int n=array.length;
        int p1=0;
        int p2=0;
        int count=0;

        int[] cumulativesum=new int[n];

        
        for(int i=1;i<n;i++){
            cumulativesum[i]=array[i-1]+cumulativesum[i-1];
        }

        for(p1=0;p1<n;p1++){
            int sum=0;
            for(p2=p1;p2<n;p2++){
                if(p1==0){
                    sum=cumulativesum[p2];
                }
                else{
                    sum=cumulativesum[p2]-cumulativesum[p1-1];
                }

                if (sum%k==0) count++;
            }
        }
        return count;
    }

    public static int optimalApproach(int[] array, int k){
        Map<Integer,Integer> hm=new HashMap<>();
        int sum=0;
        int count=0;

        for(int i=0;i<array.length;i++){
            sum=sum+array[i];

            int rem=sum%k;
            if(rem<0)
                rem=k+rem;
            
            if(!hm.containsKey(rem)){
                hm.put(rem,1);
            }
            else{
                hm.put(rem,hm.get(rem)+1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int freq = entry.getValue();
            count += (freq * (freq - 1)) / 2; // Count of combinations
        }

        // Add frequency of remainder 0
        count += hm.getOrDefault(0, 0);

        return count;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n;
        System.out.println("Enter the length of the array:");
        n=sc.nextInt();

        int array[]=new int[n];

        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        System.out.println("Enter k:");
        int k=sc.nextInt();

        System.out.println(BruteForce(array,k));
        System.out.println(BruteForce2(array,k));
        System.out.println(BruteForce2(array,k));

    }
}
