package problems.category.백트래킹;

import problems.category.dfs_bfs_그래프순회.다시.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달_15686 {

    static int N;
    static int M;
    static ArrayList<Cordi> homes = new ArrayList<>();
    static ArrayList<Cordi> chickens = new ArrayList<>();
    static boolean[] visited;
    static int[][] map;
    static int min;

    static class Cordi{
        int y;
        int x;

        public Cordi(int y, int x){
            this.y = y;
            this.x = x;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    homes.add(new Cordi(i, j));
                }
                else if(map[i][j] == 2){
                    chickens.add(new Cordi(i, j));
                }

            }

        }

        min = Integer.MAX_VALUE;
        visited = new boolean[chickens.size()];

        backTracking(0, 0);

        System.out.println(min);


    }

    static void backTracking(int depth, int lastIndex){

        if(depth == M){
            int ans = 0;

            for(int i = 0; i < homes.size(); i++){
                int temp = Integer.MAX_VALUE;
                for(int j = 0; j < chickens.size(); j++){

                    if(visited[j]){
                        int dist = Math.abs(homes.get(i).x - chickens.get(j).x) + Math.abs(homes.get(i).y - chickens.get(j).y);
                        temp = Math.min(dist, temp);
                    }
                }
                ans += temp;

            }
            min = Math.min(min, ans);

            return;
        }



        for(int i = lastIndex; i < chickens.size(); i++){
            visited[i] = true;
            backTracking(depth+1, i+1);
            visited[i] = false;
        }





    }

}

