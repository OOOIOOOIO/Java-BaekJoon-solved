package problems.AAA;

import java.util.*;
import java.io.*;

public class Main{

    static int n;
    static Integer dp[];
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new Integer[5];

        solve(n, 0);

        System.out.println(ans);
    }

    /**
     최댓값을 제곱해서만 하면 안된다 -> 4개 안에 못할 수도 있음
     모든 경우의 수 구하기
     */

    public static void solve(int n, int cnt){

        // 횟수 넘어가면 종료
        if(cnt > 4) return;

//        System.out.println((int)Math.sqrt(n));

        // 1부터 ㄱ
        for(int i = 1; i <= (int)Math.sqrt(n); i++){

            int temp = (int)Math.pow((int)Math.sqrt(i), 2);

            // 더 크면 종료
            if(temp > n) return;

            // 같으면 끝내기
            if(temp == n){
//                System.out.println("SAdfasfdfsfsd");
                ans = Math.min(ans, cnt+1);
            }

//            System.out.println("i = " + i);
//            System.out.println("temp = " + temp);
            // n 최신화
            n -= temp;

            solve(n, cnt+1);

        }









    }


}