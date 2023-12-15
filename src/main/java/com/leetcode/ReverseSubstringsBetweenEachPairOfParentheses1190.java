package com.leetcode;

public class ReverseSubstringsBetweenEachPairOfParentheses1190 {
    public static void main(String[] args) {
        ReverseSubstringsBetweenEachPairOfParentheses1190 r =  new ReverseSubstringsBetweenEachPairOfParentheses1190();
        System.out.println(r.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
    public String reverseParentheses(String s) {
        //find the inner most parenthesis
        //keep track of last opening braces, and when you
        //find closing braces that is your inner braces.
        //while traversing opening braces keep count of
        //how many braces have been found. This will be
        //used to decide to keep the string as it or reverse
        //it.
        int n= s.length();
        int openBracesCount =0;
        int lastOpenBraceIndex = 0;
        int firstClosedBraceIndex = 0;
        for(int i =0; i<n; i++ ) {
            if(s.charAt(i) == '(') {
                lastOpenBraceIndex = i;
                openBracesCount++;
            } else if(s.charAt(i) ==')') {
                firstClosedBraceIndex = i;
                break;
            }
        }
        // we have found inner most closed and open braces.
        //Get the character between these braces and depending
        // on the count reverse it.
        String innerMostSubStr = s.substring(lastOpenBraceIndex + 1, firstClosedBraceIndex );
        if(openBracesCount % 2 != 0)
            innerMostSubStr = new StringBuilder(innerMostSubStr).reverse().toString();
        openBracesCount--;
        //now we move the lastOpenBraceIndex towards left and untill we
        //find ( and firstClosedBraceIndex untill we find ).
        while(openBracesCount >0) {
            int i = lastOpenBraceIndex - 1;
            while(i>=0 && s.charAt(i) !='(') {
                i--;
            }
            StringBuilder left = new StringBuilder(s.substring(i + 1, lastOpenBraceIndex));
            lastOpenBraceIndex = i;

            int j = firstClosedBraceIndex + 1;
            while(j <n && s.charAt(j) !=')') {
                j++;
            }
            StringBuilder right = new StringBuilder(
                    s.substring(firstClosedBraceIndex + 1, j));
            if(openBracesCount % 2!= 0) {
                innerMostSubStr = right.reverse().toString() + innerMostSubStr
                        + left.reverse().toString();
            } else {
                innerMostSubStr = left.toString() + innerMostSubStr + right.toString();
            }

            firstClosedBraceIndex = j;
            openBracesCount--;
        }
        //All the parts have been processed, now only the left and right needs to be
        //appended
        if(lastOpenBraceIndex >0)
            innerMostSubStr = s.substring(0,lastOpenBraceIndex) + innerMostSubStr;

        if(firstClosedBraceIndex < n)
            innerMostSubStr = innerMostSubStr + s.substring(firstClosedBraceIndex + 1,n);

        return innerMostSubStr;
    }
}
