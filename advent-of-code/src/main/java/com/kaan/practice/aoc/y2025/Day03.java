package com.kaan.practice.aoc.y2025;

import java.util.List;
import java.util.Stack;

public final class Day03 {

    public long part1(List<String> lines) {

        long result = 0L;
        int max1;
        int max2;

        for(String line:lines){
            max1 = 0;
            max2 = 0;
            for(int i = 0; i<line.length(); i++){
                int value = Character.getNumericValue(line.charAt(i));
                if(value>max1 && (i != line.length()-1)){
                    max1=value;
                    max2=0;
                }
                else if(value >max2){
                    max2= value;
                }
            }
            result += (max1* 10L)+max2;
        }
        return result;
    }

    //“Always pick the largest digit you can without breaking the ability to finish the number.”
    public long part2(List<String> lines) {
        long result = 0L;

        for(String line:lines){
            int searchFrom = 0;
            StringBuilder number = new StringBuilder();

            for(int i = 12; i>0; i--){
                int max = 0;
                for(int j = searchFrom; j<=line.length()-i; j++){
                    int value = Character.getNumericValue(line.charAt(j));
                    if(value>max){
                        max = value;
                        searchFrom = j+1;
                    }
                }
                number.append(max);
            }
            result += Long.parseLong(number.toString());
            number.trimToSize();
        }
        return result;
    }





    /**
     * Part 2 – Stack-based "remove (n-k) digits" approach
     *
     * Build the maximum 12-digit subsequence while preserving order.
     * Equivalent view: remove (n - 12) digits to maximize the remaining number.
     *
     * Greedy rule:
     * - When a new digit arrives, pop smaller digits from the end of the current result
     *   as long as we still have removals left. This moves larger digits earlier.
     * - After processing all digits, if removals remain, remove from the end.
     * - Finally, take the first 12 digits as the result number for the line.
     */
    public long part2_another_approach(List<String> lines) {
        long result = 0L;
        final int k = 12;

        for (String line : lines) {
            int n = line.length();
            int removeLeft = n - k;

            // Using a char[] as a stack is faster than java.util.Stack and avoids boxing.
            char[] stack = new char[n];
            int size = 0;

            for (int i = 0; i < n; i++) {
                char c = line.charAt(i);

                // Pop while we can remove and the last digit is smaller than current.
                while (removeLeft > 0 && size > 0 && stack[size - 1] < c) {
                    size--;
                    removeLeft--;
                }

                stack[size++] = c;
            }

            // If we still need to remove digits, remove from the end (least valuable).
            size -= removeLeft;

            // Take first k digits as the maximal subsequence.
            long number = 0L;
            for (int i = 0; i < k; i++) {
                number = number * 10L + (stack[i] - '0');
            }

            result += number;
        }

        return result;
    }
}
