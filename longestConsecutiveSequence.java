import java.util.Arrays;

public class longestConsecutiveSequence {
    public static void main(String[] args) {
        
    }
    public static int longestConsecutive(int[] nums) {
        if(nums.length==0) {
            return 0;
        }
        Arrays.sort(nums);
        
        int longest = 1;
        int counter = 0;
        int lastSmaller = Integer.MIN_VALUE;
        
        for(int i = 0; i<nums.length; i++) {
            
            if( nums[i]-1==lastSmaller ) {
                counter++;
                lastSmaller = nums[i];
            } else if( nums[i] != lastSmaller ) {
                lastSmaller = nums[i];
                counter = 1;
            }
            longest = Math.max(longest, counter);
        }
        return longest;
    }
}
