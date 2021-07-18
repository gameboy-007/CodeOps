package Practice;

public class MinSumPath {
	public static void main(String[] args) {
		int[][] arr = {{1,3,1} ,{1,5,1},{4,2,1}};
		int[][] memoSum = new int[arr.length][arr[0].length];
		System.out.println(sumPaths(arr, 0, 0, memoSum));
		
	}
	
	public static int sumPaths(int[][] arr, int x, int y, int[][] memoSum){
		
		if (x == arr.length - 1 && y == arr[0].length - 1) {
			return arr[x][y];
		}
		
		int minSum = Integer.MAX_VALUE;
		
		if (memoSum[x][y] != 0) {
			return memoSum[x][y];
		}
		
		if (x != arr.length - 1) {
			minSum = Math.min(minSum, arr[x][y] + sumPaths(arr, x + 1, y, memoSum));
			
		}
		
		
		if (y != arr[0].length - 1) {
			minSum = Math.min(minSum, arr[x][y] + sumPaths(arr, x, y + 1, memoSum));
		}	
		
		return memoSum[x][y] = minSum;
	}
}
