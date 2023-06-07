public class nextPermutation {
    public static void main(String[] args) {
        
    }
    public void nextPermutationOptimal(int[] nums) {
        
        int bp = breakPoint(nums);
        if(bp==-1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        int ceilIndex = ceil(bp, nums);
        
        //swap
        int temp = nums[bp];
        nums[bp] = nums[ceilIndex];
        nums[ceilIndex] = temp;
        
        reverse(nums, bp + 1, nums.length - 1);
        
    }
    
    public int breakPoint(int[] nums) {
        int ans = -1;
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i]<nums[i+1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }
    
    public int ceil(int index, int[] nums) {
        int ans = -1;
        for(int i = nums.length - 1; i>index; i--) {
            if(nums[i]>nums[index]) {
                ans = i;
                break;
            }
        }
        return ans;
        
        
    } 
    
    public void reverse(int[] nums, int st, int end) {
        int temp;
        while(st<end) {
            temp = nums[st];
            nums[st]=nums[end];
            nums[end] = temp;
            st++;
            end--;
        }
    }
}
