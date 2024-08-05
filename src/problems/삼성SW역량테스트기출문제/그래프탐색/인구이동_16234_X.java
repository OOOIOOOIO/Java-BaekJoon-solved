package problems.삼성SW역량테스트기출문제.그래프탐색;

import java.util.*;
import java.io.*;


public class 인구이동_16234_X {

    static int N, L, R;
    static int[][] population;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Node> migrationNodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        population = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }

    public static int move() {
        int result = 0;
        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (migrationNodes.size() > 1) {
                            changePopulation(sum);
                            isMove = true;
                        }
                    }
                }
            }

            if (!isMove) return result;

            result++;
        }
    }

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        migrationNodes = new ArrayList<>();

        q.offer(new Node(x, y));
        migrationNodes.add(new Node(x, y));
        visited[x][y] = true;

        int sum = population[x][y];
        while (!q.isEmpty()) {
            Node current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(population[current.x][current.y] - population[nx][ny]);

                    if (L <= diff && diff <= R) {
                        q.offer(new Node(nx, ny));
                        migrationNodes.add(new Node(nx, ny));
                        sum += population[nx][ny];
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return sum;
    }

    public static void changePopulation(int sum) {
        int avg = sum / migrationNodes.size();
        for (Node node : migrationNodes) {
            population[node.x][node.y] = avg;
        }
    }


    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}

//
//public class 인구이동_16234{
//
//    static int N, L, R;
//    static int[][] map;
//    static int[][] markedMap;
//    static int[][] visited;
//    static int[] dy = new int[]{-1, 0, 1, 0};
//    static int[] dx = new int[]{0, -1, 0, 1};
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = null;
//
//        st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        L = Integer.parseInt(st.nextToken());
//        R = Integer.parseInt(st.nextToken());
//
//        map = new int[N][N];
//        markedMap = new int[N][N];
//        visited = new int[N][N];
//
//        for(int i = 0; i < N; i++){
//            st = new StringTokenizer(br.readLine());
//
//            for(int j = 0; j < N; j++){
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        int ans = 0;
//
//
//        // 마킹을 했다면 bfs 돌리기
//        while(marking() > 0){
//            for(int i = 0; i < N; i++){
//                for(int j = 0; j < N; j++){
//                    if(markedMap[i][j] == 1 && visited[i][j] == 0){
//                        bfs(i, j);
//                    }
//                }
//            }
//            ans++;
//
//            resetVisited();
//            resetMarkedMap();
//
//        }
//
//
//        System.out.println(ans);
//
//    }
//
//    private static void bfs(int y, int x){
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{y, x});
//
//        List<int[]> list = new ArrayList<>();
//        list.add(new int[]{y, x});
//
//        visited[y][x] = 1;
//
//
//        int sum = map[y][x];
//        int cnt = 1;
//        while(!queue.isEmpty()){
//            int[] cPos = queue.poll();
//            int cy = cPos[0];
//            int cx = cPos[1];
//
//            for(int i = 0; i < 4; i++){
//                int ny = dy[i] + cy;
//                int nx = dx[i] + cx;
//
//                // 범위
//                if(ny >= 0 && ny < N && nx >= 0 && nx < N){
//                    if(markedMap[ny][nx] == 1 && visited[ny][nx] == 0){
//                        sum += map[ny][nx];
//                        cnt++;
//
//                        visited[ny][nx] = 1;
//                        queue.offer(new int[]{ny, nx});
//                        list.add(new int[]{ny, nx});
//                    }
//                }
//
//            }
//
//
//        }
//
//        int moveVal = (sum / cnt);
//
//        // 업데이트 해주기
//        for(int[] cordi : list){
//            int cy = cordi[0];
//            int cx = cordi[1];
//            map[cy][cx] = moveVal;
//
//        }
//
//
//    }
//
//    private static int marking(){
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{0, 0});
//
//        visited[0][0] = 1;
//
//        int cnt = 0;
//        while(!queue.isEmpty()){
//            int[] cPos = queue.poll();
//            int cy = cPos[0];
//            int cx = cPos[1];
//
//            for(int i = 0; i < 4; i++){
//                int ny = dy[i] + cy;
//                int nx = dx[i] + cx;
//
//                // 범위
//                if(ny >= 0 && ny < N && nx >= 0 && nx < N){
//                    // 사이값인지 계산
//                    if(markedMap[ny][nx] != 1 || markedMap[cy][cx] != 1){
//                        int val = Math.abs(map[cy][cx] - map[ny][nx]);
//
//                        if(val >= L && val <= R){
//                            markedMap[cy][cx] = 1;
//                            markedMap[ny][nx] = 1;
//                            cnt++;
//                        }
//
//                    }
//
//                    // 방문하지 않았다면
//                    if(visited[ny][nx] == 0){
//                        visited[ny][nx] = 1;
//                        queue.offer(new int[]{ny, nx});
//                    }
//
//                }
//
//            }
//
//        }
//
//        // visited 초기화
//        resetVisited();
//
//        return cnt;
//
//    }
//
//
//
//    private static void resetMarkedMap(){
//        for(int i = 0; i < N; i++){
//             Arrays.fill(markedMap[i], 0);
//        }
//
//
//    }
//
//
//    private static void resetVisited(){
//        for(int i = 0; i < N; i++){
//            Arrays.fill(visited[i], 0);
//        }
//
//
//    }
//
//
//}
