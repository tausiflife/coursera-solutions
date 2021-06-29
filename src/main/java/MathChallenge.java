import java.util.Arrays;

public class MathChallenge {
    public  int findSmallestNumberGreaterThanGivenNumber(int num) {
        String strNum = String.valueOf(num);
        char[] digits = strNum.toCharArray();
        int digitLength = digits.length;
        int i = digitLength - 1;
        for (; i > 0; i--) {
            if (digits[i-1] < digits[i])
                break;
        }
        if (i == 0)
            return -1;
        char inversionDigit = digits[i-1];
        //find smallest number greater that inversionDigit from digits between i & length -1, both inclusive.
        int diff = Integer.MAX_VALUE, smallestIndex = -1;
        for (int j = i; j < digitLength && digits[j] > inversionDigit; j++) {
            int d = digits[j] - inversionDigit;
            if (d > 0 && d < diff) {
                diff = d;
                smallestIndex = j;
            }
        }
        char tmp = digits[smallestIndex];
        digits[i-1] = tmp;
        digits[smallestIndex] = inversionDigit;
        //sort from i to length - 1
        Arrays.sort(digits, i , digitLength);
        String finalNumberStr = String.valueOf(digits);
        int finalNumber = Integer.parseInt(finalNumberStr);
        return finalNumber;
    }
}
