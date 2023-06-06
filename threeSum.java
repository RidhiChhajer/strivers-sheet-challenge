import java.util.*;

public class threeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = betterSoln(nums);

        for(List<Integer> sublist: ans) {

            for(Integer elt: sublist) {
                System.out.print(elt + ", ");
            }
            System.out.println(".");
        }
    }

    public static List<List<Integer>> betterSoln(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) { // only till 3rd last
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

                int c = -nums[i];
                int lp = i + 1;
                int rp = nums.length - 1;
                while (lp < rp) {
                    if (nums[lp] + nums[rp] == c) {

                        ans.add(Arrays.asList(nums[i], nums[lp], nums[rp]));

                        int p = nums[lp];
                        int r = nums[rp];
                        while (lp < rp && nums[lp + 1] == p) {
                            lp++;
                        }
                        while (lp < rp && nums[rp - 1] == r) {
                            rp--;
                        }
                        lp++;
                        rp--;

                    } else if (nums[lp] + nums[rp] < c) {
                        lp++;
                    } else {
                        rp--;
                    }

                }

            }

        }
        return ans;
    }
}
