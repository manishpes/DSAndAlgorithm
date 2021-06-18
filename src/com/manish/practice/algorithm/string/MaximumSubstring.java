package com.manish.practice.algorithm.string;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class MaximumSubstring {
    private static int maximumSubString(String s){
        boolean count[] = new boolean[26];
        Arrays.fill(count, false);
        int max = 0;
        int i = 0, j =0;
        int n = s.length();

//        while(i<n) {
            count[s.charAt(i)-97] = true;
            j = 0;
            while (j != n-1) {
                if(!count[s.charAt(j+1)-97])
                {
                    j++;
                    count[s.charAt(j)-97] = true;
                     max = Math.max(j - i + 1,max);
                }else
                    {
                    count[s.charAt(i)-97] = false;
                    i++;
                }
            }

        return max;
    }

    public static String longestString = "";
    public static int maxLen = 0;

    public static void nonRepeatingSubstring(String input) {
        if (input == null || input == "") {
            return;
        }
        char[] charArray = input.toCharArray();

        LinkedHashMap<Character, Integer> charPosMap = new LinkedHashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(i);
            char ch = charArray[i];
            if (!charPosMap.containsKey(ch)) {
                charPosMap.put(ch, i);
            } else {
//               i = charPosMap.get(ch);
                charPosMap.clear();
            }
            if(charPosMap.size()>maxLen) {
                maxLen = charPosMap.size();
                longestString = charPosMap.keySet().toString().replace(",", "");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(maximumSubString("maniashaxyktew"));
        nonRepeatingSubstring("maniashaxyktew");
        System.out.println(maxLen +"  "+longestString );
    }
}
