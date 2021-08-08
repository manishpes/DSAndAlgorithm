package com.manish.practice.algorithm.leetcode;

public class LongestPalindromicSubstring {
    int max =0;
    int start = 0;
    int end =0;
    public String longestPalindrome(String s) {
        int len = s.length();
        int max =0;
        int start = 0;
//        int end =0;
        for(int i =0;i<len-1; i++ ){
            expandRange(s, i,i);
            expandRange(s, i,i+1);
        }
        return s.substring(start,start+end);
    }
    void expandRange(String s,int i, int j){
        while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            j++;
            i--;
        }
        if(end < j-i-1)
        {
            end = j-i-1;
            start = i+1;
        }

    }
 /*   public String longestPalindrome(String s) {
        int len = s.length();
        int max =0;
        int start = 0;
        int end =0;
        for(int i =0;i<len; i++ ){
            for(int j =i+1;j<len; j++ ){
                if(isPalindrome(s,i,j)){
                    if(j-i+1 > max)
                    {
                        max = j-i+1;
                        start =i;
                        end = j;
                    }

                }
            }
        }
        return s.substring(start,end+1);
    }
    boolean isPalindrome(String s, int i, int j){

        while(j>=i )
        {
            if(s.charAt(i) == s.charAt(j)){
                j--;
                i++;
            }else{
                return false;
            }
        }
        return true;
    }
*/
    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
       String res = lps.longestPalindrome("ccc");
        System.out.println(res);
        }
}
