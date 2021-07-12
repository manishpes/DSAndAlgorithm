package com.manish.practice.prep;

import java.util.HashMap;
import java.util.Map;

public class FewestCoins {

    private static int fewestCoins(int N, int [] coins)
    {
        if(N == 0)
        return 0;

        int res =Integer.MAX_VALUE;

        for(int i = 0; i <coins.length; i++)
        {
            if(coins[i] <= N ) {
                int sub_res = fewestCoins(N - coins[i], coins);

                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;

            }
        }
        return res;
    }

   static int minCoins(int coinList[], int n, int value) {
        int coins[] = new int[value+1];       //store minimum coins for value i

        if(value == 0)
            return 0;              //for value 0, it needs 0 coin

        coins[0] = 0;

        for (int i=1; i<=value; i++)
            coins[i] = Integer.MAX_VALUE;            //initially all values are infinity except 0 value

        for (int i=1; i<=value; i++) {      //for all values 1 to value, find minimum values
            for (int j=0; j<n; j++)
                if (coinList[j] <= i) {
                    int tempCoins = coins[i-coinList[j]];
                    System.out.println("tempCoins "+tempCoins);
                    if (tempCoins != Integer.MAX_VALUE && tempCoins + 1 < coins[i])
                        coins[i] = tempCoins + 1;
                }
        }
        return coins[value];       //number of coins for value
    }


    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int coins[] = new int []{1, 2, 5};
        System.out.println(fewestCoins(8, coins));
        System.out.println(minCoins(coins, coins.length, 8));
    }
}
