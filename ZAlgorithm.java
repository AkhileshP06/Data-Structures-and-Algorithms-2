import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {
    private final String text;
    private final int[] zValues;

    public ZAlgorithm(String text) {
        this.text = text;
        this.zValues = computeZValues(text);
    }

    public int[] getZValues() {
        return zValues;
    }

    public void search(String pattern) {
        String searchString = pattern + "$" + text;
        int[] zValues = computeZValues(searchString);
        int patternLength = pattern.length();
        for (int i = patternLength + 1; i < zValues.length; i++) {
            if (zValues[i] == patternLength) {
                System.out.println("Found at index: " + (i - patternLength - 1));
            }
        }
    }


    private int[] computeZValues(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && s.charAt(r - l) == s.charAt(r)) r++;
                z[i] = r - l; r--;
            } else {
                int k = i - l;
                if (z[k] < r - i + 1) {
                    z[i] = z[k];
                } else {
                    l = i;
                    while (r < n && s.charAt(r - l) == s.charAt(r)) r++;
                    z[i] = r - l; r--;
                }
            }
        }
        return z;
    }
}
