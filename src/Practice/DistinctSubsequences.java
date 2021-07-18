package Practice;
import java.util.ArrayList;
import java.util.Arrays;

public class DistinctSubsequences {

	public static void main(String[]args) {
		String s = "rabbbit";
		String t = "rabbit";
		System.out.println(numDistinct(s, t));
	}
	
	public static int numDistinct(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for (int r = 0; r < memo.length; r++) {
            Arrays.fill(memo[r], -1);
        }
        return numDistinct(s, t, 0, 0, memo);
    }
	
    private static int numDistinct(String s, String t, int i, int j, int[][] memo) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int subsequences = numDistinct(s, t, i + 1, j, memo);

        if (s.charAt(i) == t.charAt(j)) {
            subsequences += numDistinct(s, t, i + 1, j + 1, memo);
        }

        return memo[i][j] = subsequences;
    }
	
}
