package com.manish.practice.prep.Educative.io;

import java.util.HashMap;
import java.util.Map;

class MaxFruitCountOf2Types {
        public static int findLength(char[] arr) {

            Map<Character, Integer> map = new HashMap<>();
            int size = arr.length;
            int start = 0;
            int end = 0;
            int maxLen = Integer.MIN_VALUE;
            for(end = 0; end < size ; end++){

                map.put(arr[end], map.getOrDefault(arr[end], 0 )+1);

                while(map.size() >2 )
                {
                    maxLen = Math.max(end-start+1, maxLen);
                    map.put(arr[start], map.get(arr[start]) - 1);

                    if(map.get(arr[start]) == 0 )
                        map.remove(arr[start]);

                    start++;;
                }

            }

            return maxLen;
        }

        public static void main(String[] args) {
           int max =  findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' });
            System.out.println(max);
        }
    }
