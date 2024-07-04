package problems.삼성SW역량테스트기출문제.백트래킹;

import java.util.*;
import java.io.*;
public class 스타트와링크 {

    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);

        System.out.println(min);
    }

    // 조합을 구하고
    private static void combi(int depth, int cnt){

        if(cnt == N/2){

            getDiff();
            return;
        }

        for(int i = depth; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                combi(i+1, cnt+1);
                visited[i] = false;
            }

        }
    }


    //구한 조합에서 차를 구한다
    private static void getDiff(){
        int sumA = 0;
        int sumB = 0;
        for(int i = 0; i < N-1; i++){
            for(int j = i + 1; j < N; j++){
                // 1팀 조합
                if(visited[i] && visited[j]){
                    sumA += (map[i][j] + map[j][i]);

                }
                // 2팀일 때
                else if(visited[i] == false && visited[j] == false){
                    sumB += (map[i][j] + map[j][i]);

                }
            }
        }

        int diff = Math.abs(sumA - sumB);

        if(diff == 0){
            System.out.println(diff);
            System.exit(0); // 이렇게 시스템 종료할 수도 있음
        }

        min = Math.min(min, diff);


    }


}