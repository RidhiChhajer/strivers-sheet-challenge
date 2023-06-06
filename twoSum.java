import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

        // int[] ans = twoSumNaive(arr, target);

        // int[] ans = twoSumBetter(arr, target);
        // System.out.println(ans[0] + ", " + ans[1] + ".");

        System.out.println(variation1(arr, target));
    }

    public static int[] twoSumNaive(int[] arr, int target) {
        int[] ans = new int[2];
        for(int i = 0; i<arr.length; i++) {
            for(int j = i+1; j<arr.length; j++) {
                if(arr[i] + arr[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    public static int[] twoSumBetter(int[] arr, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++) {
            if(map.containsKey(target - arr[i])) {
                ans[0] = map.get(target - arr[i]);
                ans[1] = i;
                return ans;
            }
            map.put(arr[i], i);
        }
        return ans;
    }

    public static boolean variation1(int[] arr, int target) {
        Arrays.sort(arr);
        int lp = 0;
        int rp = arr.length - 1;
        while(lp<rp) {
            if(arr[lp]+arr[rp]==target) {
                return true;
            }
            if(arr[lp]+arr[rp]<target) {
                lp++;
            } else {
                rp--;
            }

        }
        return false;        
    }


}