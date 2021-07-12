package com.manish.practice.prep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstring {


    private static boolean isHavingDuplicateCharacter(String str, int start, int end) {

        boolean visited[] = new boolean[26];
        Arrays.fill(visited, false);

        for (int i = start; i <= end; i++) {
            if (visited[str.charAt(i) - 'a']) {
                return false;
            } else {
                visited[str.charAt(i) - 'a'] = true;
            }

        }
        return true;
    }

    private static int longestSubStringN3(String str) {
        int length = str.length();
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (isHavingDuplicateCharacter(str, i, j))
                    res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }

    private static int longestSubStringN2(String str) {

        int length = str.length();
        boolean visited[] = new boolean[26];
        Arrays.fill(visited, false);
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (visited[str.charAt(j) - 'a'])
                    break;
                visited[str.charAt(j) - 'a'] = true;
                res = Math.max(res, j - i + 1);
            }
            visited[str.charAt(i) - 'a'] = false;
        }
        return res;
    }

    private static int longestSubStringNSet(String str)
    {
        int length = str.length();
        Set<Character> uniquechar = new LinkedHashSet<>();
        int maxLenth =0;
        for(int i=0; i < length; i++)
        {
            char ch = str.charAt(i);
            if(!uniquechar.contains(ch))
            {
                uniquechar.add(ch);
                maxLenth = Math.max(maxLenth, uniquechar.size());

            }else {
                uniquechar.clear();
            }

        }
        uniquechar.stream().forEach(i->System.out.print(i));
        System.out.println();
        return maxLenth;

    }

    private static int longestSubStringN(String str)
    {
        int length = str.length();

        int i =0;
        int result = 0;
        int lastIndex[] = new int [26];
        Arrays.fill(lastIndex, -1);
//        int endIndex =0;
        for(int j = 0; j< length; j++)
        {
            char ch = str.charAt(j);
            i = Math.max(i, lastIndex[ch -'a']+1);
            result = Math.max(result, j-i+1);
           /* if (result < (j-i+1))
            {
                endIndex = j;
                result = j-i+1;

            }*/

            lastIndex[ch - 'a'] = j;
        }
//        System.out.println("The Substring is "+ str.substring(i, endIndex));
        return result;
    }

    public static void main(String[] args) {
        System.out.println("The length of longest non repeating sub-string  in N^3 :: " + longestSubStringN3("maamanishabcdefghijklmno"));
        System.out.println("The length of longest non repeating sub-string  in N^2 :: " + longestSubStringN2("maamanishabcdefghijklmno"));
//        System.out.println("The length of longest non repeating sub-string  in NSet  :: " + longestSubStringNSet("maamanishabcdefghijklmno"));
        System.out.println("The length of longest non repeating sub-string  in NSet  :: " + longestSubStringN("maamanishabcdefghijklmno"));
    }

}
