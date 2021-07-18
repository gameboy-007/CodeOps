package Practice;

public class JumpGameII {
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 1, 4};
		System.out.println(jump(nums));
	}
	public static int jump(int[] nums) {
        return jumps(nums);
    }
    
    public static int jumps(int[] nums){
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i] = 9999999;
        }
        dp[0] = 0;
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] + j >= i){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }
}
