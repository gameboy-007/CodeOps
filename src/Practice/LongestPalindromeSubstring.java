package Practice;

public class LongestPalindromeSubstring {
	static boolean[][] dp;
	
	
	public static void main(String[] args) {
		
		String s = "abcd";
		dp = new boolean[s.length()][s.length()];
		System.out.println(findPalin(s));
	}
	
	public static void print(String s, int start, int end) {
		System.out.println(s.substring(start, end + 1));
	}
	
	static int findPalin(String s) {
		
		int maxlength = 1;
		
		for(int i = 0; i < s.length(); i++) {
			dp[i][i] = true; 
		}	
		
		int start = 0;
		
		for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i+1] = true;
				start = i;
				maxlength = 2;
			}
		}
		
		for(int k = 3; k <= s.length(); k++) {
			for(int i = 0; i < s.length() - k + 1; i++) {
				int j = i + k - 1;
				if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
					dp[i][j] = true;
					if (k > maxlength) {
						start = i;
						maxlength = k;
					}
				}
			}
		}	
		
		
        print(s, start, start + maxlength - 1);
		return maxlength;
		
	}

}
