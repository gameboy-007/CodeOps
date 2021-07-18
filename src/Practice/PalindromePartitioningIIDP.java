package Practice;
//It incrementally builds the candidates for the solution and discards the candidates (backtrack) if it doesn't satisfy the condition.


public class PalindromePartitioningIIDP {
	
	private static Integer memoCuts[][];
    private static Boolean memoPalindrome[][];
    
	public static void main(String[] args) {	
		String s = "aab";
		memoCuts = new Integer[s.length()][s.length()];
		memoPalindrome = new Boolean[s.length()][s.length()];
		int cuts = findMinCuts(0, s, s.length() - 1, s.length());
		System.out.println(cuts);
	}
	
	public static int findMinCuts(int start, String s, int end, int minimumCuts){
		if (start == end || isPalindrome(s, start, end)) {
			return 0;
		}
		
		if (memoCuts[start][end] != null) {
			return memoCuts[start][end];
		}	
		
		for (int currentEndIndex = start; currentEndIndex <= end; currentEndIndex++) {
            if (isPalindrome(s, start, currentEndIndex)) {
                minimumCuts = Math.min(minimumCuts, 1 + findMinCuts(currentEndIndex + 1, s, end, minimumCuts));
            }
        }
		return memoCuts[start][end] = minimumCuts;
	}
	
	 private static boolean isPalindrome(String s, int start, int end) {
	        if (start >= end) {
	            return true;
	        }
	        if (memoPalindrome[start][end] != null) {
	            return memoPalindrome[start][end];
	        }
	        return memoPalindrome[start][end] = (s.charAt(start) == s.charAt(end))
	            && isPalindrome(s, start + 1, end - 1);
	 }
}
