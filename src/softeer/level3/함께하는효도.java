package softeer.level3;

import java.io.*;
import java.util.*;

public class 함께하는효도 {
    static int n, m;
    static int map[][];
    static ArrayList<int[]> pList = new ArrayList<>();
    static int[] dy = new int[]{0, -1, 0, 1};
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dp;

    static final int MAX_TIME = 3;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        dp = new int[4];
        int sum = 0;

        // map
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            pList.add(new int[]{y, x}); // idx 0부터 시작하게
            sum += map[y][x];
            map[y][x] = 0;
        }



        dfs(pList.get(0)[0], pList.get(0)[1], sum, 0, 0);

        System.out.println(dp[0]);


    }




    private static void dfs(int x, int y, int sum, int time, int person){
        dp[0] = Math.max(dp[0], sum);


        if(time == 3){
            if(person + 1 < m){
                dfs(pList.get(person+1)[0], pList.get(person+1)[1], sum, 0, person+1);
            }
        }
        else{
            for(int i = 0; i < 4; i++){
                int nextY = x + dy[i];
                int nextX = y + dx[i];

                if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < n){
                    int val = map[nextY][nextX];
                    map[nextY][nextX] = 0;
                    dfs(nextY, nextX, sum + val, time + 1, person);
                    map[nextY][nextX] = val;
                }
            }
        }
    }

}





