package problems.삼성SW역량테스트기출문제.구현;

import java.util.*;
import java.io.*;


public class 경사로_14890 {

    static int N, L;
    static int[][] map;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 0; i < N; i++){
            if(checkPath(i, 0, true)) ans++;
            if(checkPath(0, i, false)) ans++;
        }

        System.out.println(ans);

    }

    private static boolean checkPath(int y, int x, boolean flag){
        int[] height = new int[N];
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++){
            if(flag) height[i] = map[y][i]; // row
            else height[i] = map[i][x]; // column
        }

        for(int i = 0; i < N-1; i++){

            if(height[i] == height[i+1]) continue;
            else if(height[i] - 1 == height[i+1]){ // 내려갈 때, 다음 블록부터
                for(int j = i+1; j <= i + L; j++){
                    if(j < N && height[i+1] == height[j] && !visited[j]) visited[j] = true;
                    else return false;
                }
            }
            else if(height[i] + 1 == height[i+1]){ // 올라갈 때, 현재 블록부터
                for(int j = i; j > i - L; j--){
                    if(j >= 0 && height[i] == height[j] && !visited[j]) visited[j] = true;
                    else return false;
                }
            }
            else{
                return false;
            }
        }

        return true;
    }



}













