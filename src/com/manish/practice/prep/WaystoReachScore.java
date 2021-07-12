package com.manish.practice.prep;

import java.util.Arrays;

public class WaystoReachScore {

    private static int waysToReachN(int score, int arr[]){

        int scoreTable[] = new int [score+1];
        Arrays.fill(scoreTable,0);
        scoreTable[0] = 1;
        for(int point = 0; point < arr.length; point++ ){

            for(int i = arr[point];i <= score ; i++ )
            {
                scoreTable [i] += scoreTable[i-arr[point]];
            }
        }
        return scoreTable[score];
    }
    private static int waysToReachNWith3510(int score)
    {
        int scoretable[] = new int[score+1];
        Arrays.fill(scoretable, 0);
        scoretable[0] = 1;
        for(int i = 3; i <= score; i++)
        {
            scoretable[i] += scoretable[i-3];
        }
        for(int i = 5; i <= score; i++)
        {
            scoretable[i] += scoretable[i-5];
        }
        for(int i = 10; i <= score; i++)
        {
            scoretable[i] += scoretable[i-10];
        }

        return scoretable[score];

    }


    public static void main(String[] args) {
       int ways = waysToReachN(13, new int [] {3, 5, 10});
        System.out.println(ways);
        System.out.println(waysToReachNWith3510(20));
    }
}
