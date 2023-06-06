import java.util.*;
public class fourSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        // List<List<Integer>> ans = fourSumBetter(nums, target);

        List<List<Integer>> ans = fourSumOptimal(nums, target);

        for(List<Integer> sublist: ans) {

            for(Integer elt: sublist) {
                System.out.print(elt + ", ");
            }
            System.out.println(".");
        }
        
    }

    public static List<List<Integer>> fourSumBetter(int[] nums, int target) {
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                Set<Long> hs = new HashSet<>();
                for (int k = j + 1; k < nums.length; k++) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    if (hs.contains(target - sum)) {
                        List<Integer> sub = new ArrayList<>();
                        sub.add(nums[i]);
                        sub.add(nums[j]);
                        sub.add(nums[k]);
                        sub.add((int) (target - sum));
                        sub.sort(Integer::compareTo);
                        st.add(sub);
                    }
                    hs.add((long) nums[k]);
                }

            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }

    public static List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i<nums.length - 2 ; i++) {
            if(i==0 || (i>0 && nums[i]!=nums[i-1])) {
                for(int j = i+1; j<nums.length - 1; j++) {
                    if(j==i+1 || (j>i+1 && nums[j]!=nums[j-1])) {
                        // long newTarget = target - nums[i] - nums[j];
                        int lo = j+1;
                        int hi = nums.length - 1;
                        while(lo<hi) {
                            long sum = nums[i] + nums[j];
                            sum+=nums[lo];
                            sum+=nums[hi];
                            if(sum==target) {
                                List<Integer> sublist = new ArrayList<>();
                                sublist.add(nums[i]);
                                sublist.add(nums[j]);
                                sublist.add(nums[lo]);
                                sublist.add(nums[hi]);
                                ans.add(sublist);
                                
                                while(lo<hi && nums[lo]==nums[lo+1]) {
                                    lo++;
                                }
                                while(lo<hi && nums[hi]==nums[hi-1]) {
                                    hi--;
                                }
                                lo++;
                                hi--;
                                
                            } else if(sum<target) {
                                lo++;
                            } else {
                                hi--;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
