package problems.삼성SW역량테스트기출문제.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 동작 종류 : 왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기
// 공은 동시에 움직임. 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패
// 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다. 또, 빨간 구슬과 파란 구슬의 크기는 한 칸을 모두 차지

// *** TARGET : 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 구하는 프로그램(10번 내로 못 빼내면 -1 출력) ***

// Link : https://www.acmicpc.net/problem/13460
public class 구슬탈출2 {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int holeX, holeY;
    static Marble blue, red;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        // 구슬 map 구성
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                } else if(map[i][j] == 'B') {
                    blue = new Marble(0, 0, i, j, 0);
                } else if(map[i][j] == 'R') {
                    red = new Marble(i, j, 0, 0, 0);
                }
            }
        }

        System.out.println(bfs());

        br.close();
    }

    // BFS를 이용하여 탐색.  (최단거리를 찾아야하기 때문, 10 이하)
    public static int bfs() {
        Queue<Marble> queue = new LinkedList<>();
        queue.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
        visited[red.rx][red.ry][blue.rx][blue.ry] = true;

        while(!queue.isEmpty()) {
            Marble marble = queue.poll();

            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCnt = marble.cnt;

            // 이동 횟수가 10 초과시 실패
            if(curCnt > 10) {
                break;
            }

            for(int i = 0; i < 4; i++) {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                // 빨간 구슬 이동
                // 벽을 만날 때까지 해당 방향으로 계속
                while(map[newRx + dx[i]][newRy + dy[i]] != '#') {
                    newRx += dx[i];
                    newRy += dy[i];

                    // 이동 중 구멍을 만나면, flag값 기록
                    if(newRx == holeX && newRy == holeY) {
                        isRedHole = true;
                        break;
                    }
                }

                // 파란 구슬 이동
                // 벽을 만날 때까지 해당 방향으로 계속
                while(map[newBx + dx[i]][newBy + dy[i]] != '#') {
                    newBx += dx[i];
                    newBy += dy[i];

                    // 이동 중 구멍을 만나면, flag값 기록
                    if(newBx == holeX && newBy == holeY) {
                        isBlueHole = true;
                        break;
                    }
                }

                // 파란 구슬이 구멍에 들어가면 무조건 실패 -> 다음 큐 확인
                if(isBlueHole) {
                    continue;
                }

                // 빨간 구슬만 구멍에 빠지면 성공
                if(isRedHole) {
                    return curCnt;
                }

                // 둘 다 구멍에 빠지지 않았는데 이동할 위치가 같은 경우 -> 위치 조정
                // 빨간, 파란 구슬이 모두 같은 방향으로 벽까지 가기 때문에, 같은 좌표로 이동할 수 있음. 하지만, 한 좌표에는 하나의 구슬 만 있어야함
                if(newRx == newBx && newRy == newBy) {
                    if(i == 0) { // 위쪽으로 기울이기
                        // 더 큰 x값을 가지는 구슬이 뒤로 감
                        if(curRx > curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else if(i == 1) { // 오른쪽으로 기울이기
                        // 더 작은 y값을 가지는 구슬이 뒤로 감
                        if(curRy < curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    } else if(i == 2) { // 아래쪽으로 기울이기
                        // 더 작은 x값을 가지는 구슬이 뒤로 감
                        if(curRx < curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else { // 왼쪽으로 기울이기
                        // 더 큰 y값을 가지는 구슬이 뒤로 감
                        if(curRy > curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    }
                }

                // 두 구슬이 이동할 위치가 처음 방문하는 곳일 때만 큐에 추가
                if(!visited[newRx][newRy][newBx][newBy]) {
                    visited[newRx][newRy][newBx][newBy] = true;
                    queue.add(new Marble(newRx, newRy, newBx, newBy, curCnt+1));
                }
            }
        }

        return -1;
    }

}

class Marble {
    int rx;
    int ry;
    int bx;
    int by;
    int cnt;

    Marble(int rx, int ry, int bx, int by, int cnt) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}