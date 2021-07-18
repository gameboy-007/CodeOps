package Practice;

import java.util.ArrayList;

public class PalindromePartitioning {
	public static void main(String[] args) {
		String s = "aab";
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> res = dfs(0, s, list, new ArrayList<String>());
		System.out.println(res);
	}
	
	public static ArrayList<ArrayList<String>> dfs(int start, String s, ArrayList<ArrayList<String>> list, ArrayList<String> currentList){
		if(start >= s.length()) {
			list.add((new ArrayList<String>(currentList)));
		}
		
		for(int end = start; end < s.length(); end++) {
			 if(isPalindrome(start, end, s)){
				 currentList.add(s.substring(start, end + 1));
				 dfs(end + 1, s, list, currentList);
				 currentList.remove(currentList.size() - 1);
			 }
		}
		return list;
	}
	
	public static boolean isPalindrome(int a, int b, String s) {
		int flag = 0;
		while (a <= b) {
			if(s.charAt(a) == s.charAt(b)) {
				a++;
				b--;
			}else {
				flag = 1;
				break;
			} 
		}
		if(flag == 1) {
			return false;
		}
		return true;
	}
	
	
}
