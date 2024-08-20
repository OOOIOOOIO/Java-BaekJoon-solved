package problems.삼성SW역량테스트기출문제.구현;

import java.util.*;
import java.io.*;

public class 연구소3_17142_X{

    static int N, M;
    static int vCnt = 0;
    static ArrayList<ArrayList<int[]>> combiList= new ArrayList<>(); //이건 콤비
    static ArrayList<int[]> vPosList = new ArrayList<>();// 바이러스 위치들(i, j)
    static int[][] map;
    static boolean[] virus;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        //초기화
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2){
                    vPosList.add(new int[]{i, j});
                    vCnt++;
                }
            }
        }

        virus = new boolean[vCnt];



        // maxDepth = M
        // for의 i < vPosList.size()

        makeCombi(0, M);


    }

    // 바이러스들 경우의 수
    private static void makeCombi(int depth, int maxDepth){

        if(depth == maxDepth){

            bfs();
            return;
        }

        if(!virus[depth]){
            virus[depth] = true;
            makeCombi(depth + 1, maxDepth);
            virus[depth] = false;
        }


    }

    /**
     -1 : 비활
     2 : 활성
     1 : 벽
     0 : 빈칸
     그냥 2부터 시작하고 나중에 2 빼주기
     대소비교 작은게 짱
     */
    private static void bfs(){
        boolean[][] visited = new boolean[N][N];

        int[][] cloneMap = cloneMap();

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();



            for(int i = 0; i < 4; i++){
                int nextY = curr[0] + dy[i];
                int nextX = curr[1] + dx[i];

                // 범위
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < N){
                    if(cloneMap[nextY][nextX] == 0 ){

                    }
                }
            }
        }


    }



    private static int[][] cloneMap(){
        int[][] cloneMap = new int[N][N];

        for(int i = 0; i < N; i++){
            cloneMap[i] = map[i].clone();
        }

        for(int i = 0; i < vCnt; i++){
            if(!virus[i]){
                int y = vPosList.get(i)[0];
                int x = vPosList.get(i)[1];

                cloneMap[y][x] = -1; // 비활성
            }
        }

        return cloneMap;

    }



}


