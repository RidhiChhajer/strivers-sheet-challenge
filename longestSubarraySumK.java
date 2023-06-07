import java.util.HashMap;

public class longestSubarraySumK {
    public static void main(String[] args) {
        
    }

    public static int maxLenBrute(int arr[], int n)
    {
        int len = 0;
        for(int i = 0; i<n; i++) {
            int sum = 0;
            for(int j = i; j<n; j++) {
                sum+=arr[j];
                if(sum==0) {
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }

    public static int maxLenBetter(int arr[], int n) { 
        //using hashing. for all integers
        // sum k=0
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        
        for(int i = 0; i<n; i++) {
            prefixSum+=arr[i];
            if(prefixSum==0) {
                len = Math.max(len, i+1);
            } else {
                if(map.get(prefixSum-0)!=null) {
                    len = Math.max(len, i - map.get(prefixSum-0));
                } else {
                    map.put(prefixSum, i);
                }
            }
        }
        return len;
    }

    public static int maxLenOptimal(int arr[], int n, int k) { 
        // two pointer approach. only for positives.
        int len = 0;
        int first = 0;
        int second = 0;
        int sum = 0;
        while(second<n) {
            sum+=arr[second];
            if(sum<k) {
                second++;
            } else if(sum==k) {
                len = Math.max(len, second-first+1);
                second++;
            } else {
                while(sum>k) {
                    sum-=arr[first];
                    first++;
                }
                if(sum==k) {
                    len = Math.max(len, second-first+1);
                }
                second++;
            }
        }
        
        return len;
    }

    public static int lenOfLongSubarr (int arr[], int n, int k) {
        // sum k
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        
        for(int i = 0; i<n; i++) {
            prefixSum+=arr[i];
            if(prefixSum==k) {
                len = i+1;
            } 
            
            if(!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
                
            if(map.containsKey(prefixSum - k)) {
                len = Math.max(len, i - map.get(prefixSum-k));
            }
        }
        return len;
    }
}