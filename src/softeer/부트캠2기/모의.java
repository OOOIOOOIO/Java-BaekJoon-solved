package softeer.부트캠2기;

import java.io.*;
import java.util.*;

/**

4
1 0 0 0
1 0 0 0
0 0 0 0
0 0 1 1

6
0 1 1 0 0 0
0 1 1 0 1 1
0 0 0 0 1 1
0 0 0 0 1 1
1 1 0 0 1 0
1 1 1 0 0 0
 */
public class 모의 {
    static int lines;
    static int areaCnt = 0;

    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static ArrayList<Integer> cntList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        lines = Integer.parseInt(br.readLine());

        area = new int[lines][lines];
        visited = new boolean[lines][lines];

        // 입력
        for(int i = 0; i < lines; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < lines; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < lines; i++){
            for(int j = 0; j < lines; j++){
                if(!visited[i][j] && area[i][j] == 1){
                    int cnt = 0;
                    bfs(i, j, cnt);
                    areaCnt++;
                }
            }
        }

        System.out.println(areaCnt);

        Collections.sort(cntList);
        for(int result : cntList){
            System.out.print(result+ " ");
        }

    }


    public static void bfs(int y, int x, int cnt){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for(int i = 0; i < 4; i++){
                int nextY = dy[i] + curr[0];
                int nextX = dx[i] + curr[1];

                if(nextY >= 0 && nextX >= 0 && nextY < lines && nextX < lines){
                    if(!visited[nextY][nextX] && area[nextY][nextX] == 1){
                        visited[nextY][nextX] = true;
                        queue.offer(new int[] {nextY, nextX});
                        cnt++;
                    }
                }

            }

        }


        if(cnt > 0) cntList.add(cnt);


    }


}

