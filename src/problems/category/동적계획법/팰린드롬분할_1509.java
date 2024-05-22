package problems.category.동적계획법;

import java.util.*;
import java.io.*;

public class 팰린드롬분할_1509 {

    static int[] dp;
    static boolean[][] palindrome;
    static int cnt = 0;
    static String str = "";
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        length = str.length();
        palindrome = new boolean[length+1][length+1];
        dp = new int[length + 1];

        isPalin();
        setDp();

        System.out.println(dp[length]);

    }


    private static void isPalin(){
        for(int i = 1; i <= length; i++){
            for(int j = i; j <= length; j++){
                boolean flag = true;
                int lp = i -1;
                int rp = j -1;

                while(lp <= rp){
                    if(str.charAt(lp++) != str.charAt(rp--)){
                        flag = false;
                        break;
                    }
                }

                if(flag) palindrome[i][j] = true;
            }
        }
    }

    private static void setDp(){
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= length; i++){
            for(int j = 1; j <= i; j++){
                if(palindrome[j][i]) dp[i] = Math.min(dp[i], dp[j-1] + 1);
            }
        }

    }


}


