package softeer.오토2024년2분기;

import java.io.*;
import java.util.*;

public class 일번문제 {
    static int[] dp;
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        //초기화
        map = new int[N+1][3];
        dp = new int[N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(br.readLine());
            int s = Integer.parseInt(br.readLine());
            int t = Integer.parseInt(br.readLine());

            map[i][0] = f;
            map[i][0] = s;
            map[i][0] = t;
        }

        //dp
        //첫위치 2,
        solve(2, 1, 0);

        System.out.println(dp[N]);
    }

    private static void solve(int pos, int depth, int cnt){
        if(depth == N){

            return;
        }

        // 현재 위치에서 같은 방향은 다음 위치로 움직일 때 && 비어있을 때
        if(map[depth][pos] == 0){
            dp[depth] = dp[depth-1]; // 그대로
            solve(pos, depth+1, cnt);
        }
        else{
            if(pos == 0){
                //2, 3 검사 -> 비어있다면 dp 증가
                if(map[depth][1] == 0){
                    dp[depth] = Math.min(dp[depth], cnt+1);
                    solve(1, depth+1, cnt+1);

                }

                if(map[depth][2] == 0){
                    dp[depth] = Math.min(dp[depth], cnt+1);
                    solve(2, depth+1, cnt+1);

                }
            }
            else if(pos == 1){
                // 1, 3 검사
                if(map[depth][0] == 0){
                    dp[depth] = Math.min(dp[depth], cnt+1);
                    solve(0, depth+1, cnt+1);
                }

                if(map[depth][2] == 0){
                    dp[depth] = Math.min(dp[depth], cnt+1);
                    solve(2, depth+1, cnt+1);
                }
            }
            else{
                // 1, 2 검사
                if(map[depth][0] == 0){
                    dp[depth] = Math.min(dp[depth], cnt+1);
                    solve(0, depth+1, cnt+1);
                }

                if(map[depth][1] == 0){
                    dp[depth] = Math.min(dp[depth], cnt+1);
                    solve(1, depth+1, cnt+1);
                }
            }
        }

    }



}









