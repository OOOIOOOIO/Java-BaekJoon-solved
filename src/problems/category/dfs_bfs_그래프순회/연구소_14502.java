package problems.category.dfs_bfs_그래프순회;

import java.util.*;
import java.io.*;
public class 연구소_14502 {

    static class Cordi{
        int y;
        int x;

        public Cordi(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int N, M;
    static int[][] originalMap;
    static ArrayList<Cordi> virusList = new ArrayList<>();
    static int maxCnt = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        originalMap = new int[N][M];

        // map
        for(int i = 0; i < N; i++){
            String[] temp = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                originalMap[i][j] = Integer.parseInt(temp[j]);
            }
        }

        // virus 리스트
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(originalMap[i][j] == 2) virusList.add(new Cordi(i, j));
            }
        }

        dfs(0);

        System.out.println(maxCnt);

    }

    public static void dfs(int wallCnt){

        if(wallCnt == 3){
            int cnt = bfs();
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(originalMap[i][j] == 0){
                    originalMap[i][j] = 1;
                    dfs(wallCnt+1); // ++ 쓰면 시간초과 나온다.
                    originalMap[i][j] = 0; // 백트랙킹
                }
            }
        }
    }

    public static int bfs(){
        Queue<Cordi> queue = new LinkedList<>();

        for(Cordi cordi : virusList){ // 2인 점들
            queue.offer(cordi);
        }

        int[][] cloneMap = new int[N][M];

        for(int i = 0; i < N; i++){
            cloneMap[i] = originalMap[i].clone(); // clone()으로 복사해야 한다.
        }

        while(!queue.isEmpty()){
            Cordi curr = queue.poll();

            for(int i = 0; i < 4; i++){
                int nextY = curr.y + dy[i];
                int nextX = curr.x + dx[i];

                if(nextY >= 0 && nextX >= 0 && nextY < N && nextX < M){
                    if(cloneMap[nextY][nextX] == 0){
                        cloneMap[nextY][nextX] = 2;
                        queue.offer(new Cordi(nextY, nextX));
                    }
                }
            }

        }

        return countSafety(cloneMap);
    }

    public static int countSafety(int[][] cloneMap){

        int cnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(cloneMap[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;

    }




}

