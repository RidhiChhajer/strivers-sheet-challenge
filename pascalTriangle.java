import java.util.ArrayList;
import java.util.List;

public class pascalTriangle {
    public static void main(String[] args) {
        
    }

    public List<Integer> getRow(int rowIndex) {
        long ans = 1;
        List<Integer> res = new ArrayList<>();
        int n = rowIndex + 1;
        res.add((int)ans);
        for(int i = 1; i<=rowIndex; i++) {
            ans = ans*(n-i)/i;
            res.add((int)ans);
        }
        return res;
    }

    public List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int j=0; j<numRows; j++) {
            res.add(getRow(j));
        }
        return res;
    }


}
