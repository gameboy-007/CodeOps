package Practice;

import java.util.ArrayList;

public class PalindromePartitioningDP {
	public static void main(String[] args) {
		String s = "abba";
		boolean dp[][] = new boolean[s.length()][s.length()];
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> res = dfs(0, s, list, new ArrayList<String>(), dp);
		System.out.println(res);
	}
	
	public static ArrayList<ArrayList<String>> dfs(int start, String s, ArrayList<ArrayList<String>> list, ArrayList<String> currentList,boolean[][] dp){
		if(start >= s.length()) {
			list.add((new ArrayList<String>(currentList)));
		}
		
		for(int end = start; end < s.length(); end++) {
			 if(s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
				 dp[start][end] = true;
				 currentList.add(s.substring(start, end + 1));
				 dfs(end + 1, s, list, currentList, dp);
				 currentList.remove(currentList.size() - 1);
			 }
		}
		return list;
	}
	
		
}
