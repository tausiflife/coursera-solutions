import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public ArrayList<int[]> find(int[] arr, int sum) {
        ArrayList<int[]> results = new ArrayList<int[]>();
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 2; i ++) {
            if (i == 0 || arr[i] > arr[i - 1]) {
                int start = i + 1, end = arr.length - 1;
                while (start < end) {
                    if (arr[start] + arr[end] == sum - arr[i]) {
                        results.add(new int[] {arr[i], arr[start], arr[end]});
                    }
                    if (arr[start] + arr[end] < sum - arr[i]) {
                        int currentStart = start;
                        while (arr[start] == arr[currentStart] && start < end)
                            start++;
                    } else {
                        int currentEnd = end;
                        while (arr[end] == arr[currentEnd] && start < end)
                            end--;
                    }
                }
            }
        }
        return results;
    }
}
