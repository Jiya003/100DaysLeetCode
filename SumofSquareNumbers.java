/*
Question No. 633
Sum of SQuare Numbers

Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

 

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5

Example 2:

Input: c = 3
Output: false

*/


class Solution{
  public static boolean judgeSquareSum(int c) {
        
        int sr = (int)Math.sqrt(c);
        if((sr*sr)==c) return true;
        int i=0;
        int j=sr;

        while(i<=j){
            int sum=(i*i)+(j*j);
            if (sum==c) return true;
            else if (sum>c) j--;
            else i++;            
        }
        return false;
  }
}
