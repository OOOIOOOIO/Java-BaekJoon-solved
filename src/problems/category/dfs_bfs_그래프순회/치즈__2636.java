package problems.category.dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 이 문제는 시간초과가 계속 났다 왜? LinkedList를 썼기 때문, 삭제일 경우 LinkedList가 더 빠를 줄 알았는데
 * ArrayList, LinkedList 둘다 O(n) 이였고, 조회는 ArrayList가 O(1), LinkedList가 O(n)이였다.
 * LinkedList가 삽입, 삭제에 더 효율적이라는 말은 무작위로 삭제, 삽입할 때인 것 같다. 조회처럼 순차적으로 삭제 및 삽입을 한다면 ArrayList가 훨씬 효율적이다.
 *
 * 일반적으로 dfs보다 bfs가 더 빠르고 효율적이라고 한다. 하지만 이는 특정 노드 혹은 최단 거리를 찾을 때이다.
 * 만약 모든 노드를 탐색한다면  dfs가 훨씬 빠르다.(이번처럼 모든 노드를 특정 값으로 초기화 시킨다던가)
 */
public class 치즈__2636 {


    static class Cordi{
        int y;
        int x;
        public Cordi(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0}; // 반시계방향
    static int[] dx = {0, -1, 0, 1};
    static int cheeseCnt;
    static int N, M;
    static int time;
    static ArrayList<Cordi> cheeseList;
//	static LinkedList<Cordi> cheeseList;

    static int removeCnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기화
        map = new int[N][M];
        visited = new boolean[N][M];
        cheeseList = new ArrayList<Cordi>();

        // 입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1) {
                    cheeseCnt++;
                    cheeseList.add(new Cordi(i, j));
                }
            }
        }


        while(cheeseCnt != 0) {

            removeCnt = 0;
//			bfsOutside(0, 0); // 외부 -1로 만들어주고
            dfsOutside(0, 0); // 외부 -1로 만들어주고(이게 더 빠름)
            bfsCheese(); // 치즈 녹여버려
            visited = new boolean[N][M];
            time++;
        }

        System.out.println(time);
        System.out.println(removeCnt);
    }

    /*
     * dfs : 외부인 곳은 다 -1로 만들어 준다.(이게 더 빠르다)
     */
    static void dfsOutside(int y, int x) {

        visited[y][x] = true;
        map[y][x] = -1;

        for(int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            // 범위에 포함되지 않는다면
            if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                // 아직 방문하지 않았다면
                if(!visited[nextY][nextX] && (map[nextY][nextX] != 1)) {

                    dfsOutside(nextY, nextX);
                }
            }
        }
    }

    /*
     * bfs : 외부인 곳은 다 -1로 만들어 준다.
     */
    static void bfsOutside(int y, int x) {
        Queue<Cordi> queue = new LinkedList<Cordi>();

        queue.offer(new Cordi(y, x));

        visited[y][x] = true; // 방문처리

        map[y][x] = -1;

        while(!(queue.isEmpty())){

            Cordi curr = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nextY = curr.y + dy[i];
                int nextX = curr.x + dx[i];


                // 범위에 포함되지 않는다면
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                    // 아직 방문하지 않았다면
                    if(!visited[nextY][nextX] && (map[nextY][nextX] != 1)) {
                        queue.add(new Cordi(nextY, nextX));

                        visited[nextY][nextX] = true;

                        if(map[nextY][nextX] == 0) map[nextY][nextX] = -1;
                    }
                }
            }

        }

    }

    static void bfsCheese() {

        for(int i = 0; i < cheeseList.size(); i++) {

//			if(removeList[k]) continue;

            Cordi curr = cheeseList.get(i);
            int outsideCnt = 0;

            for(int j = 0; j < 4; j++) {
                int nextY = curr.y + dy[j];
                int nextX = curr.x + dx[j];


                // 외부라면
                if(map[nextY][nextX] == -1) {
                    outsideCnt ++;
                }
            }

            if(outsideCnt >= 1) {
                map[curr.y][curr.x] = 0;
                cheeseCnt--;
//				removeList[k] = true;
                cheeseList.remove(i);
                i--; // 삭제했으니 당겨야된다.
                removeCnt++;
            }

        }

    }



}




