package Practice;

public class ProductArrayExceptSelf {
	
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 4};
		int[] ret = productExceptSelf(nums);
		for (int i = 0; i < ret.length; i++) {
			System.out.print(ret[i] + " ");
		}
	}
	
	public static int[] productExceptSelf(int[] nums) {
	    int leng = nums.length;
	    int[] ret = new int[leng];
	    if(leng == 0)
	        return ret;
	    int runningprefix = 1;
	    for(int i = 0; i < leng; i++){
	        ret[i] = runningprefix;
	        runningprefix*= nums[i];
	    }
	    int runningsufix = 1;
	    for(int i = leng -1; i >= 0; i--){
	        ret[i] *= runningsufix;
	        runningsufix *= nums[i];
	    }
	    return ret;
	    
	}

}
