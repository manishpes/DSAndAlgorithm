package com.manish.practice.algorithm.string;

import java.util.LinkedHashMap;
import java.util.Stack;

public class BracketMatch {

        static int bracketMatch(String text) {
            // your code goes here

           int diffCounter = 0;
            int ans = 0;
            int n = text.length();

            for (int i = 0; i<n ;i++){

                if ( text.charAt(i) == '(' ){
                    diffCounter += 1;
                }
                else if ( text.charAt(i) == ')' ) {
                    diffCounter -= 1;
                }
                if ( diffCounter < 0 ) {
                    diffCounter += 1;
                    ans += 1;
                }

            }
            return ans + diffCounter;
            /*Stack<Character> stack = new Stack<>();
            for(int i = 0; i<text.length();  i++)
            {
                char ch = text.charAt(i);
                if(ch == '('){
                    stack.push(ch);
                }else{
                    if( !stack.isEmpty() && stack.peek() == '(')
                    {
                        stack.pop();
                    }else{
                        stack.push(ch);
                    }
                }


            }
            return stack.size();*/
        }

        public static void main(String[] args) {

             System.out.println(bracketMatch("())("));



        }

}
