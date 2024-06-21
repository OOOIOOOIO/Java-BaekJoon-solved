package softeer.level3;

import java.io.*;
import java.util.*;

public class 나무섭지_X {

    static int n, m;
    static int[][] map;
    static List<int[]> ghostList = new ArrayList<>();
    static int[] dy = new int[]{0, -1, 0 , 1};
    static int[] dx = new int[]{-1, 0, 1 , 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        int dongX = 0;
        int dongY = 0;
        int doorY = 0;
        int doorX = 0;

        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split("");
            for(int j = 0; j < m; j++){
                if(line[j].equals("D")){ //출구 : 1
                    map[i][j] = 1;
                    doorY = i;
                    doorX = j;
                }
                else if(line[j].equals("G")){ //유령
                    ghostList.add(new int[]{i, j});
                }
                else if(line[j].equals("N")){ //동우

                    dongY = i;
                    dongX = j;
                }
                else if(line[j].equals("#")){ //벽 : -1
                    map[i][j] = -1;
                }

            }
        }



        int dongResult =  dongBfs(dongY, dongX, 0);

        if(dongResult == -1) System.out.println("No");
        else{
            if(ghostList.size() == 0) System.out.println("Yes");

            for(int[] ghost : ghostList){
                int[][] cntArr = new int[n][m];
                cntArr[ghost[0]][ghost[1]] = -1; //시작위치
                int ghostResult = ghostBfs(ghost[0], ghost[1], 0, cntArr);

                if(dongResult >= ghostResult){
                    System.out.println("No");
                    break;
                }
                else{
                    System.out.println("Yes");
                    break;
                }
            }

        }


    }

    private static int dongBfs(int dongY, int dongX, int cnt){
        Queue<int[]> queue = new LinkedList<>();
        int[][] cntArr = new int[n][m];

        queue.offer(new int[]{dongY, dongX, cnt});
        cntArr[dongY][dongX] = -1; //시작위치

        while(!queue.isEmpty()){

            int[] curr = queue.poll();

            int currY = curr[0];
            int currX = curr[1];
            int currCnt = curr[2];

            if(map[currY][currX] == 1){
//                System.out.println("currY = " + currY);
//                System.out.println("currX = " + currX);
//                System.out.println("DONG cntArr[currY][currX] = " + cntArr[currY][currX]);
                return cntArr[currY][currX];
            }

            for(int i = 0; i < 4; i++){
                int nextY = currY + dy[i];
                int nextX = currX + dx[i];

                if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < m){

                    if(map[nextY][nextX] != -1 && cntArr[nextY][nextX] == 0){
                        cntArr[nextY][nextX] = currCnt+1;
                        queue.offer(new int[]{nextY, nextX, currCnt+1});

                    }
                }
            }

        }


        return -2;
    }

    private static int ghostBfs(int ghostY, int ghostX, int cnt, int[][] cntArr){
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{ghostY, ghostX, cnt});
        cntArr[ghostY][ghostX] = -1; //시작위치

        while(!queue.isEmpty()){

            int[] curr = queue.poll();

            int currY = curr[0];
            int currX = curr[1];
            int currCnt = curr[2];

            if(map[currY][currX] == 1){
//                System.out.println("currY = " + currY);
//                System.out.println("currX = " + currX);
//                System.out.println("GHOST cntArr[currY][currX] = " + cntArr[currY][currX]);
                return cntArr[currY][currX];
            }

            for(int i = 0; i < 4; i++){
                int nextY = currY + dy[i];
                int nextX = currX + dx[i];

                if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < m){

                    if(cntArr[nextY][nextX] == 0 ){
                        cntArr[nextY][nextX] = currCnt+1;
                        queue.offer(new int[]{nextY, nextX, currCnt+1});

                    }
                }
            }

        }


        return -2;

    }



}

/**
 *
 * 4 6
 * ...#.D
 * ...#..
 * .GN#..
 * G.....
 *
 * 1 5
 * D#.NG
 */