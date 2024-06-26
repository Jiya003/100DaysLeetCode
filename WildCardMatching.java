/*
Queston No. 44 
Wildcard Matching

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

 

Constraints:

    0 <= s.length, p.length <= 2000
    s contains only lowercase English letters.
    p contains only lowercase English letters, '?' or '*'.


*/
class Solution {
  public boolean isMatch(String s, String p) {
    final int m = s.length();
    final int n = p.length();
    
    
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;

    for (int j = 0; j < p.length(); ++j)
      if (p.charAt(j) == '*')
        dp[0][j + 1] = dp[0][j];

    for (int i = 0; i < m; ++i)
      for (int j = 0; j < n; ++j)
        if (p.charAt(j) == '*') {
          final boolean matchEmpty = dp[i + 1][j];
          final boolean matchSome = dp[i][j + 1];
          dp[i + 1][j + 1] = matchEmpty || matchSome;
        } else if (isMatch(s, i, p, j)) {
          dp[i + 1][j + 1] = dp[i][j];
        }

    return dp[m][n];
  }

  private boolean isMatch(final String s, int i, final String p, int j) {
    return j >= 0 && p.charAt(j) == '?' || s.charAt(i) == p.charAt(j);
  }
}
