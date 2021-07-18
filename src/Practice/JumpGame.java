package Practice;

public class JumpGame {
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 1, 4};
		System.out.println(canJump(nums));
		
	}
	
	public static boolean canJump(int[] nums) {
        int j = nums.length - 1;
       for(int i = nums.length - 2; i >= 0; i--){
           if(i + nums[i] >= j){
               j = i;
           }
       }
       return j==0;
   }
	
}
