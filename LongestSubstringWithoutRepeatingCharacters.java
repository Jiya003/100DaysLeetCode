/*
Question 3:
Given a string s, find the length of the longest substring without repeating characters. 

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring. 

Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
*/


class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs	=new HashSet<>();
    	
    	int n=s.length();
		int res=0;
		int start=0;

		for(int i=0; i<n; i++){
			if(hs.contains(s.charAt(i))){
				while(s.charAt(i)!=s.charAt(start)){
					hs.remove(s.charAt(start));
					start++;
				}
				start++;
			} 
			hs.add(s.charAt(i));
			res=Math.max(res, i-start+1);
		}
		return res;
        
    }
}
